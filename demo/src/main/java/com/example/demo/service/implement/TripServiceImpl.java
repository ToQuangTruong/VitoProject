package com.example.demo.service.implement;

import com.example.demo.entity.Trip;
import com.example.demo.repository.CoachRepository;
import com.example.demo.repository.RouteRepository;
import com.example.demo.repository.TripRepository;
import com.example.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Override
    public boolean save(Trip newTrip) {
        if(tripRepository.findTripByTripId(newTrip.getTripId()) != null){
            Trip existingTrip = tripRepository.findTripByTripId(newTrip.getTripId());
            existingTrip.setRouteId(newTrip.getRouteId());
            existingTrip.setGuestNumber(newTrip.getGuestNumber());
            existingTrip.setPrice(newTrip.getPrice());
            existingTrip.setCoachId(newTrip.getCoachId());
            existingTrip.setRoute(routeRepository.findRouteByRouteId(newTrip.getRouteId()));
            existingTrip.setCoach(coachRepository.findCoachByCoachId(newTrip.getCoachId()));
            tripRepository.save(existingTrip);
            return true;
        }

        newTrip.setRoute(routeRepository.findRouteByRouteId(newTrip.getRouteId()));
        newTrip.setCoach(coachRepository.findCoachByCoachId(newTrip.getCoachId()));
        tripRepository.save(newTrip);
        return true;
    }

    @Override
    public boolean save(List<Trip> newTrips) {
        for(Trip trip : newTrips){
            trip.setRoute(routeRepository.findRouteByRouteId(trip.getRouteId()));
            trip.setCoach(coachRepository.findCoachByCoachId(trip.getCoachId()));
        }
        tripRepository.saveAll(newTrips);
        return true;
    }

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public Trip findTripById(Long TripId) {
        return tripRepository.findTripByTripId(TripId);
    }

    @Override
    public boolean delete(Long tripId) {
        tripRepository.deleteTripByTripId(tripId);
        return true;
    }
}
