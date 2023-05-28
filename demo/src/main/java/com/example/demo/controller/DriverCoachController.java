package com.example.demo.controller;

import com.example.demo.entity.DriverCoach;
import com.example.demo.service.DriverCoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driverCoach")
public class DriverCoachController {

    @Autowired
    private DriverCoachService driverCoachService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody DriverCoach driverCoach){
        return ResponseEntity.status(HttpStatus.OK).body(driverCoachService.save(driverCoach));
    }

    @PostMapping("/adds")
    public ResponseEntity<?> add(@RequestBody List<DriverCoach> driverCoachs){
        return ResponseEntity.status(HttpStatus.OK).body(driverCoachService.save(driverCoachs));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(driverCoachService.findAll());
    }

    @GetMapping("/findById/{coachId},{driverId}")
    public ResponseEntity<?> findDriverCoachById(@PathVariable Long coachId, @PathVariable Long driverId){
        return ResponseEntity.status(HttpStatus.OK).body(driverCoachService.findDriverCoachById(coachId, driverId));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody DriverCoach driverCoach){
        return ResponseEntity.status(HttpStatus.OK).body(driverCoachService.save(driverCoach));
    }

    @DeleteMapping("/delete/{coachId},{driverId}")
    public ResponseEntity<?> delete(@PathVariable Long coachId, @PathVariable Long driverId){
        return ResponseEntity.status(HttpStatus.OK).body(driverCoachService.delete(coachId, driverId));
    }
}
