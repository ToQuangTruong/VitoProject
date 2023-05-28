package com.example.demo.service.implement;

import com.example.demo.entity.Driver;
import com.example.demo.repository.DriverCoachRepository;
import com.example.demo.repository.DriverRepository;
import com.example.demo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private DriverCoachRepository driverCoachRepository;
    @Override
    public boolean save(Driver newDriver) {
        if(driverRepository.findDriverByDriverId(newDriver.getDriverId()) != null){
            Driver existingDriver = driverRepository.findDriverByDriverId(newDriver.getDriverId());
            existingDriver.setName(newDriver.getName());
            existingDriver.setLicenseId(newDriver.getLicenseId());
            existingDriver.setLicenseType(newDriver.getLicenseType());
            existingDriver.setAddress(newDriver.getAddress());
            existingDriver.setDateOfBirth(newDriver.getDateOfBirth());
            existingDriver.setWorkTime(newDriver.getWorkTime());
            existingDriver.setDriverCoach(driverCoachRepository.findDriverCoachByDriverId(newDriver.getDriverId()));
            driverRepository.save(existingDriver);
            return true;
        }
        newDriver.setDriverCoach(driverCoachRepository.findDriverCoachByDriverId(newDriver.getDriverId()));
        driverRepository.save(newDriver);
        return true;
    }

    @Override
    public boolean save(List<Driver> newDrivers) {
        for(Driver driver : newDrivers){
            driver.setDriverCoach(driverCoachRepository.findDriverCoachByDriverId(driver.getDriverId()));
        }
        driverRepository.saveAll(newDrivers);
        return true;
    }

    @Override
    public List<Driver> findAll() {
        return driverRepository.findAll();
    }

    @Override
    public Driver findDriverById(Long driverId) {
        return driverRepository.findDriverByDriverId(driverId);
    }

    @Override
    public boolean delete(Long driverId) {
        driverRepository.deleteDriverByDriverId(driverId);
        return true;
    }

}
