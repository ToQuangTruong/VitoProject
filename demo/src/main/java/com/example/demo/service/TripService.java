package com.example.demo.service;

import com.example.demo.entity.Trip;

import java.util.List;

public interface TripService {
    boolean save(Trip newTrip);
    boolean save(List<Trip> newTrips);
    List<Trip> findAll();
    Trip findTripById(Long TripId);
    boolean delete(Long tripId);
}
