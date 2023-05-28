package com.example.demo.controller;

import com.example.demo.entity.Trip;
import com.example.demo.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Trip trip){
        return ResponseEntity.status(HttpStatus.OK).body(tripService.save(trip));
    }

    @PostMapping("/adds")
    public ResponseEntity<?> add(@RequestBody List<Trip> trips){
        return ResponseEntity.status(HttpStatus.OK).body(tripService.save(trips));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(tripService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findTripById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(tripService.findTripById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Trip trip){
        return ResponseEntity.status(HttpStatus.OK).body(tripService.save(trip));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>  delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(tripService.delete(id));
    }
}
