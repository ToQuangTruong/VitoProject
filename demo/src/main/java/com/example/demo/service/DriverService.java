package com.example.demo.service;

import com.example.demo.entity.Driver;

import java.util.List;

public interface DriverService {
    boolean save(Driver newDriver);
    boolean save(List<Driver> newDrivers);
    List<Driver> findAll();
    Driver findDriverById(Long driverId);
    boolean delete(Long driverId);
}
