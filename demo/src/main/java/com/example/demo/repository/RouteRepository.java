package com.example.demo.repository;

import com.example.demo.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    Route findRouteByRouteId(Long routeId);

    @Modifying
    void deleteRouteByRouteId(Long routeId);
}
