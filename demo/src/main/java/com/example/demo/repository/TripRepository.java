package com.example.demo.repository;

import com.example.demo.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    Trip findTripByTripId(Long tripId);
    List<Trip> findAllByCoachId(Long coachId);
    List<Trip> findAllByRouteId(Long routeId);

    @Modifying
    void deleteTripByTripId(Long tripId);
}
