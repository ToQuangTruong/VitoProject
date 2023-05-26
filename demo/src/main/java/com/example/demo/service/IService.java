package com.example.demo.service;

import com.example.demo.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IService {
    Coach saveCoach(Coach newCoach);
    Driver saveDriver(Driver newDriver);
    DriverCoach saveDriverCoach(DriverCoach newDriverCoach);
    Route saveRoute(Route newRoute);
    Trip saveTrip(Trip newTrip);
    List<Coach> saveCoachs(List<Coach> newCoachs);
    List<Driver> saveDrivers(List<Driver> newDrivers);
    List<DriverCoach> saveDriverCoachs(List<DriverCoach> newDriverCoachs);
    List<Route> saveRoutes(List<Route> newRoutes);
    List<Trip> saveTrips(List<Trip> newTrips);

    List<Coach> getCoachs();
    List<Driver> getDrivers();
    List<DriverCoach> getDriverCoachs();
    List<Route> getRoutes();
    List<Trip> getTrips();

    Coach findCoachById(Long coachId);
    Driver findDriverById(Long driverId);
    DriverCoach findDriverCoachById(Long coachId, Long driverId);
    Route findRouteById(Long routeId);
    Trip findTripById(Long TripId);

    Coach deleteCoach(Long coachId);
    Driver deleteDriver(Long driverId);
    DriverCoach deleteDriverCoach(Long coachId, Long driverId);
    Route deleteRoute(Long routeId);
    Trip deleteTrip(Long tripId);
}
