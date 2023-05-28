package com.example.demo.service;

import com.example.demo.entity.Route;

import java.util.List;

public interface RouteService {
    boolean save(Route newRoute);
    boolean save(List<Route> newRoutes);
    List<Route> findAll();
    Route findRouteById(Long routeId);
    boolean delete(Long routeId);
}
