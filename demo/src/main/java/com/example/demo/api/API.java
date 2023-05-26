package com.example.demo.api;

import com.example.demo.entity.*;
import com.example.demo.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class API {
    @Autowired
    private IService service;

    @PostMapping("/addCoach")
    public Coach addCoach(@RequestBody Coach coach){
        return service.saveCoach(coach);
    }

    @PostMapping("/addCoachs")
    public List<Coach> addCoachs(@RequestBody List<Coach> coachs) {
        return service.saveCoachs(coachs);
    }

    @PostMapping("/addDriver")
    public Driver addDriver(@RequestBody Driver driver){
        return service.saveDriver(driver);
    }

    @PostMapping("/addDrivers")
    public List<Driver> addDrivers(@RequestBody List<Driver> drivers){
        return service.saveDrivers(drivers);
    }

    @PostMapping("/addDriverCoach")
    public DriverCoach addDriverCoach(@RequestBody DriverCoach driverCoach){
        return service.saveDriverCoach(driverCoach);
    }

    @PostMapping("/addDriverCoachs")
    public List<DriverCoach> addDriverCoachs(@RequestBody List<DriverCoach> driverCoachs){
        return service.saveDriverCoachs(driverCoachs);
    }

    @PostMapping("/addRoute")
    public Route addRoute(@RequestBody Route route){
        return service.saveRoute(route);
    }

    @PostMapping("/addRoutes")
    public List<Route> addRoutes(@RequestBody List<Route> routes){
        return service.saveRoutes(routes);
    }

    @PostMapping("/addTrip")
    public Trip addTrip(@RequestBody Trip trip){
        return service.saveTrip(trip);
    }

    @PostMapping("/addTrips")
    public List<Trip> addTrips(@RequestBody List<Trip> trips){
        return service.saveTrips(trips);
    }

    @GetMapping("/coachs")
    public List<Coach> findAllCoachs(){
        return service.getCoachs();
    }

    @GetMapping("/coachById/{id}")
    public Coach findCoachById(@PathVariable Long id){
        return service.findCoachById(id);
    }

    @GetMapping("/drivers")
    public List<Driver> findAllDrivers(){
        return service.getDrivers();
    }

    @GetMapping("/driverById/{id}")
    public Driver findDriverById(@PathVariable Long id){
        return service.findDriverById(id);
    }

    @GetMapping("/driverCoachs")
    public List<DriverCoach> findAllDriverCoachs(){
        return service.getDriverCoachs();
    }

    @GetMapping("/driverCoachById/{coachId},{driverId}")
    public DriverCoach findDriverCoachById(@PathVariable Long coachId, @PathVariable Long driverId){
        return service.findDriverCoachById(coachId, driverId);
    }

    @GetMapping("/routes")
    public List<Route> findAllRoutes(){
        return service.getRoutes();
    }

    @GetMapping("/routeById/{id}")
    public Route findRouteById(@PathVariable Long id){
        return service.findRouteById(id);
    }

    @GetMapping("/trips")
    public List<Trip> findAllTrips(){
        return service.getTrips();
    }

    @GetMapping("/tripById/{id}")
    public Trip findTripById(@PathVariable Long id){
        return service.findTripById(id);
    }

    @PutMapping("/updateCoach")
    public Coach updateCoach(@RequestBody Coach coach){
        return service.saveCoach(coach);
    }

    @PutMapping("/updateDriver")
    public Driver updateDriver(@RequestBody Driver driver){
        return service.saveDriver(driver);
    }

    @PutMapping("/updateDriverCoach")
    public DriverCoach updateDriverCoach(@RequestBody DriverCoach driverCoach){
        return service.saveDriverCoach(driverCoach);
    }

    @PutMapping("/updateRoute")
    public Route updateRoute(@RequestBody Route route){
        return service.saveRoute(route);
    }

    @PutMapping("/updateTrip")
    public Trip updateTrip(@RequestBody Trip trip){
        return service.saveTrip(trip);
    }

    @DeleteMapping("/deleteCoach/{id}")
    public Coach deleteCoach(@PathVariable Long id){
        return service.deleteCoach(id);
    }

    @DeleteMapping("/deleteDriver/{id}")
    public Driver deleteDriver(@PathVariable Long id){
        return service.deleteDriver(id);
    }

    @DeleteMapping("/deleteDriverCoach/{coachId},{driverId}")
    public DriverCoach deleteDriver(@PathVariable Long coachId, @PathVariable Long driverId){
        return service.deleteDriverCoach(coachId, driverId);
    }

    @DeleteMapping("/deleteRoute/{id}")
    public Route deleteRoute(@PathVariable Long id){
        return service.deleteRoute(id);
    }

    @DeleteMapping("/deleteTrip/{id}")
    public Trip deleteTrip(@PathVariable Long id){
        return service.deleteTrip(id);
    }
}
