package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAPI implements IService{

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DriverCoachRepository driverCoachRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private TripRepository tripRepository;

    @Override
    public Coach saveCoach(Coach newCoach) {
        if(coachRepository.findCoachByCoachId(newCoach.getCoachId()) != null){
            Coach existingCoach = coachRepository.findCoachByCoachId(newCoach.getCoachId());
            existingCoach.setModel(newCoach.getModel());
            existingCoach.setManufacturer(newCoach.getManufacturer());
            existingCoach.setVersion(newCoach.getVersion());
            existingCoach.setSeatNumber(newCoach.getSeatNumber());
            existingCoach.setYearUsed(newCoach.getYearUsed());
            existingCoach.setLastMaintenanceDay(newCoach.getLastMaintenanceDay());
            existingCoach.setTrips(tripRepository.findAllByCoachId(newCoach.getCoachId()));
            existingCoach.setDriverCoach(driverCoachRepository.findDriverCoachByCoachId(newCoach.getCoachId()));
            return coachRepository.save(existingCoach);
        }

        newCoach.setTrips(tripRepository.findAllByCoachId(newCoach.getCoachId()));
        newCoach.setDriverCoach(driverCoachRepository.findDriverCoachByCoachId(newCoach.getCoachId()));
        return coachRepository.save(newCoach);
    }

    @Override
    public Driver saveDriver(Driver newDriver) {
        if(driverRepository.findDriverByDriverId(newDriver.getDriverId()) != null){
            Driver existingDriver = driverRepository.findDriverByDriverId(newDriver.getDriverId());
            existingDriver.setName(newDriver.getName());
            existingDriver.setLicenseId(newDriver.getLicenseId());
            existingDriver.setLicenseType(newDriver.getLicenseType());
            existingDriver.setAddress(newDriver.getAddress());
            existingDriver.setDateOfBirth(newDriver.getDateOfBirth());
            existingDriver.setWorkTime(newDriver.getWorkTime());
            existingDriver.setDriverCoach(driverCoachRepository.findDriverCoachByDriverId(newDriver.getDriverId()));
            return driverRepository.save(existingDriver);
        }
        newDriver.setDriverCoach(driverCoachRepository.findDriverCoachByDriverId(newDriver.getDriverId()));
        return driverRepository.save(newDriver);
    }

    @Override
    public DriverCoach saveDriverCoach(DriverCoach newDriverCoach) {
        if(driverCoachRepository.findDriverCoachByCoachIdAndDriverId(newDriverCoach.getCoachId(), newDriverCoach.getDriverId()) != null){
            DriverCoach existingDriverCoach = driverCoachRepository.findDriverCoachByCoachIdAndDriverId(newDriverCoach.getCoachId(), newDriverCoach.getDriverId());
            existingDriverCoach.setType(newDriverCoach.getType());
            existingDriverCoach.setCoach(coachRepository.findCoachByCoachId(newDriverCoach.getCoachId()));
            existingDriverCoach.setDriver(driverRepository.findDriverByDriverId(newDriverCoach.getDriverId()));
            return driverCoachRepository.save(existingDriverCoach);
        }
        newDriverCoach.setCoach(coachRepository.findCoachByCoachId(newDriverCoach.getCoachId()));
        newDriverCoach.setDriver(driverRepository.findDriverByDriverId(newDriverCoach.getDriverId()));
        return driverCoachRepository.save(newDriverCoach);
    }

    @Override
    public Route saveRoute(Route newRoute) {
        if(routeRepository.findRouteByRouteId(newRoute.getRouteId()) != null){
            Route existingRoute = routeRepository.findRouteByRouteId(newRoute.getRouteId());
            existingRoute.setFirstPoint(newRoute.getFirstPoint());
            existingRoute.setEndPoint(newRoute.getEndPoint());
            existingRoute.setDistance(newRoute.getDistance());
            existingRoute.setComplicateLevel(newRoute.getComplicateLevel());
            existingRoute.setTrips(tripRepository.findAllByRouteId(newRoute.getRouteId()));
            return routeRepository.save(existingRoute);
        }
        newRoute.setTrips(tripRepository.findAllByRouteId(newRoute.getRouteId()));
        return routeRepository.save(newRoute);
    }

    @Override
    public Trip saveTrip(Trip newTrip) {
        if(tripRepository.findTripByTripId(newTrip.getTripId()) != null){
            Trip existingTrip = tripRepository.findTripByTripId(newTrip.getTripId());
            existingTrip.setRouteId(newTrip.getRouteId());
            existingTrip.setGuestNumber(newTrip.getGuestNumber());
            existingTrip.setPrice(newTrip.getPrice());
            existingTrip.setCoachId(newTrip.getCoachId());
            existingTrip.setRoute(routeRepository.findRouteByRouteId(newTrip.getRouteId()));
            existingTrip.setCoach(coachRepository.findCoachByCoachId(newTrip.getCoachId()));
            return tripRepository.save(existingTrip);
        }

        newTrip.setRoute(routeRepository.findRouteByRouteId(newTrip.getRouteId()));
        newTrip.setCoach(coachRepository.findCoachByCoachId(newTrip.getCoachId()));
        return tripRepository.save(newTrip);
    }

    @Override
    public List<Coach> saveCoachs(List<Coach> newCoachs) {
        for(Coach coach : newCoachs){
            coach.setTrips(tripRepository.findAllByCoachId(coach.getCoachId()));
            coach.setDriverCoach(driverCoachRepository.findDriverCoachByCoachId(coach.getCoachId()));
        }
        return coachRepository.saveAll(newCoachs);
    }

    @Override
    public List<Driver> saveDrivers(List<Driver> newDrivers) {
        for(Driver driver : newDrivers){
            driver.setDriverCoach(driverCoachRepository.findDriverCoachByDriverId(driver.getDriverId()));
        }
        return driverRepository.saveAll(newDrivers);
    }

    @Override
    public List<DriverCoach> saveDriverCoachs(List<DriverCoach> newDriverCoachs) {
        for(DriverCoach driverCoach : newDriverCoachs){
            driverCoach.setCoach(coachRepository.findCoachByCoachId(driverCoach.getCoachId()));
            driverCoach.setDriver(driverRepository.findDriverByDriverId(driverCoach.getDriverId()));
        }
        return driverCoachRepository.saveAll(newDriverCoachs);
    }

    @Override
    public List<Route> saveRoutes(List<Route> newRoutes) {
        for (Route route : newRoutes){
            route.setTrips(tripRepository.findAllByRouteId(route.getRouteId()));
        }
        return routeRepository.saveAll(newRoutes);
    }

    @Override
    public List<Trip> saveTrips(List<Trip> newTrips) {
        for(Trip trip : newTrips){
            trip.setRoute(routeRepository.findRouteByRouteId(trip.getRouteId()));
            trip.setCoach(coachRepository.findCoachByCoachId(trip.getCoachId()));
        }
        return tripRepository.saveAll(newTrips);
    }

    @Override
    public List<Coach> getCoachs() {
        return coachRepository.findAll();
    }

    @Override
    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public List<DriverCoach> getDriverCoachs() {
        return driverCoachRepository.findAll();
    }

    @Override
    public List<Route> getRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public List<Trip> getTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Coach findCoachById(Long coachId) {
        return coachRepository.findCoachByCoachId(coachId);
    }

    @Override
    public Driver findDriverById(Long driverId) {
        return driverRepository.findDriverByDriverId(driverId);
    }

    @Override
    public DriverCoach findDriverCoachById(Long coachId, Long driverId) {
        return driverCoachRepository.findDriverCoachByCoachIdAndDriverId(coachId, driverId);
    }

    @Override
    public Route findRouteById(Long routeId) {
        return routeRepository.findRouteByRouteId(routeId);
    }

    @Override
    public Trip findTripById(Long TripId) {
        return tripRepository.findTripByTripId(TripId);
    }

    @Override
    public Coach deleteCoach(Long coachId) {
        return coachRepository.deleteCoachByCoachId(coachId);
    }

    @Override
    public Driver deleteDriver(Long driverId) {
        return driverRepository.deleteDriverByDriverId(driverId);
    }

    @Override
    public DriverCoach deleteDriverCoach(Long coachId, Long driverId) {
        return driverCoachRepository.deleteDriverCoachByCoachIdAndDriverId(coachId, driverId);
    }

    @Override
    public Route deleteRoute(Long routeId) {
        return routeRepository.deleteRouteByRouteId(routeId);
    }

    @Override
    public Trip deleteTrip(Long tripId) {
        return tripRepository.deleteTripByTripId(tripId);
    }
}
