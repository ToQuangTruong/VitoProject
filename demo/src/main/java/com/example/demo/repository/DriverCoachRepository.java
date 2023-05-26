package com.example.demo.repository;

import com.example.demo.entity.DriverCoach;
import com.example.demo.entity.DriverCoachPKId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverCoachRepository extends JpaRepository<DriverCoach, DriverCoachPKId> {
    List<DriverCoach> findDriverCoachByCoachId(Long coachId);
    List<DriverCoach> findDriverCoachByDriverId(Long driverId);

    DriverCoach findDriverCoachByCoachIdAndDriverId(Long coachId, Long driverId);
    DriverCoach deleteDriverCoachByCoachIdAndDriverId(Long coachId, Long driverId);
}
