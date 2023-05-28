package com.example.demo.repository;

import com.example.demo.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    Coach findCoachByCoachId(Long coachId);

    @Modifying
    void deleteCoachByCoachId(Long coachId);
}
