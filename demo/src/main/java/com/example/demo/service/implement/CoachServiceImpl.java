package com.example.demo.service.implement;

import com.example.demo.entity.Coach;
import com.example.demo.repository.CoachRepository;
import com.example.demo.repository.DriverCoachRepository;
import com.example.demo.repository.TripRepository;
import com.example.demo.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private DriverCoachRepository driverCoachRepository;
    @Override
    public boolean save(Coach newCoach) {
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
            coachRepository.save(existingCoach);
            return true;
        }

        newCoach.setTrips(tripRepository.findAllByCoachId(newCoach.getCoachId()));
        newCoach.setDriverCoach(driverCoachRepository.findDriverCoachByCoachId(newCoach.getCoachId()));
        coachRepository.save(newCoach);
        return true;
    }

    @Override
    public boolean save(List<Coach> newCoachs) {
        for(Coach coach : newCoachs){
            coach.setTrips(tripRepository.findAllByCoachId(coach.getCoachId()));
            coach.setDriverCoach(driverCoachRepository.findDriverCoachByCoachId(coach.getCoachId()));
        }
        coachRepository.saveAll(newCoachs);
        return true;
    }

    @Override
    public List<Coach> findAll() {
        return coachRepository.findAll();
    }

    @Override
    public Coach findCoachById(Long coachId) {
        return coachRepository.findCoachByCoachId(coachId);
    }

    @Override
    public boolean delete(Long coachId) {
        coachRepository.deleteCoachByCoachId(coachId);
        return true;
    }
}
