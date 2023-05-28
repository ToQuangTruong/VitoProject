package com.example.demo.service.implement;

import com.example.demo.entity.Route;
import com.example.demo.repository.RouteRepository;
import com.example.demo.repository.TripRepository;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private TripRepository tripRepository;

    @Override
    public boolean save(Route newRoute) {
        if(routeRepository.findRouteByRouteId(newRoute.getRouteId()) != null){
            Route existingRoute = routeRepository.findRouteByRouteId(newRoute.getRouteId());
            existingRoute.setFirstPoint(newRoute.getFirstPoint());
            existingRoute.setEndPoint(newRoute.getEndPoint());
            existingRoute.setDistance(newRoute.getDistance());
            existingRoute.setComplicateLevel(newRoute.getComplicateLevel());
            existingRoute.setTrips(tripRepository.findAllByRouteId(newRoute.getRouteId()));
            routeRepository.save(existingRoute);
            return true;
        }
        newRoute.setTrips(tripRepository.findAllByRouteId(newRoute.getRouteId()));
        routeRepository.save(newRoute);
        return true;
    }

    @Override
    public boolean save(List<Route> newRoutes) {
        for (Route route : newRoutes){
            route.setTrips(tripRepository.findAllByRouteId(route.getRouteId()));
        }
        routeRepository.saveAll(newRoutes);
        return true;
    }

    @Override
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public Route findRouteById(Long routeId) {
        return routeRepository.findRouteByRouteId(routeId);
    }

    @Override
    public boolean delete(Long routeId) {
        routeRepository.deleteRouteByRouteId(routeId);
        return true;
    }
}
