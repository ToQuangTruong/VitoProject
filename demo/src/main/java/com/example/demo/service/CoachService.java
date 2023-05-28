package com.example.demo.service;

import com.example.demo.entity.Coach;

import java.util.List;

public interface CoachService {
    boolean save(Coach newCoach);
    boolean save(List<Coach> newCoachs);
    List<Coach> findAll();
    Coach findCoachById(Long coachId);
    boolean delete(Long coachId);
}
