package com.example.demo.service;

import com.example.demo.entity.DriverCoach;

import java.util.List;

public interface DriverCoachService {
    boolean save(DriverCoach newDriverCoach);
    boolean save(List<DriverCoach> newDriverCoachs);
    List<DriverCoach> findAll();
    DriverCoach findDriverCoachById(Long coachId, Long driverId);
    boolean delete(Long coachId, Long driverId);
}
