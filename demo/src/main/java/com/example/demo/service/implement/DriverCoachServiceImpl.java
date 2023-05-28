package com.example.demo.service.implement;

import com.example.demo.entity.DriverCoach;
import com.example.demo.repository.CoachRepository;
import com.example.demo.repository.DriverCoachRepository;
import com.example.demo.repository.DriverRepository;
import com.example.demo.service.DriverCoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverCoachServiceImpl implements DriverCoachService {

    @Autowired
    private DriverCoachRepository driverCoachRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private DriverRepository driverRepository;
    @Override
    public boolean save(DriverCoach newDriverCoach) {
        if(driverCoachRepository.findDriverCoachByCoachIdAndDriverId(newDriverCoach.getCoachId(), newDriverCoach.getDriverId()) != null){
            DriverCoach existingDriverCoach = driverCoachRepository.findDriverCoachByCoachIdAndDriverId(newDriverCoach.getCoachId(), newDriverCoach.getDriverId());
            existingDriverCoach.setType(newDriverCoach.getType());
            existingDriverCoach.setCoach(coachRepository.findCoachByCoachId(newDriverCoach.getCoachId()));
            existingDriverCoach.setDriver(driverRepository.findDriverByDriverId(newDriverCoach.getDriverId()));
            driverCoachRepository.save(existingDriverCoach);
            return true;
        }
        newDriverCoach.setCoach(coachRepository.findCoachByCoachId(newDriverCoach.getCoachId()));
        newDriverCoach.setDriver(driverRepository.findDriverByDriverId(newDriverCoach.getDriverId()));
        driverCoachRepository.save(newDriverCoach);
        return true;
    }

    @Override
    public boolean save(List<DriverCoach> newDriverCoachs) {
        for(DriverCoach driverCoach : newDriverCoachs){
            driverCoach.setCoach(coachRepository.findCoachByCoachId(driverCoach.getCoachId()));
            driverCoach.setDriver(driverRepository.findDriverByDriverId(driverCoach.getDriverId()));
        }
        driverCoachRepository.saveAll(newDriverCoachs);
        return true;
    }

    @Override
    public List<DriverCoach> findAll() {
        return driverCoachRepository.findAll();
    }

    @Override
    public DriverCoach findDriverCoachById(Long coachId, Long driverId) {
        return driverCoachRepository.findDriverCoachByCoachIdAndDriverId(coachId, driverId);
    }

    @Override
    public boolean delete(Long coachId, Long driverId) {
        driverCoachRepository.deleteDriverCoachByCoachIdAndDriverId(coachId, driverId);
        return true;
    }

}
