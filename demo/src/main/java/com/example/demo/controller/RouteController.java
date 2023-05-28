package com.example.demo.controller;

import com.example.demo.entity.Route;
import com.example.demo.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Route route){
        return ResponseEntity.status(HttpStatus.OK).body(routeService.save(route));
    }

    @PostMapping("/adds")
    public ResponseEntity<?> add(@RequestBody List<Route> routes){
        return ResponseEntity.status(HttpStatus.OK).body(routeService.save(routes));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(routeService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findRouteById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(routeService.findRouteById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Route route){
        return ResponseEntity.status(HttpStatus.OK).body(routeService.save(route));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(routeService.delete(id));
    }
}
