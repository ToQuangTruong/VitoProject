package com.example.demo.controller;

import com.example.demo.entity.Driver;
import com.example.demo.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Driver driver){
        return ResponseEntity.status(HttpStatus.OK).body(driverService.save(driver));
    }

    @PostMapping("/adds")
    public ResponseEntity<?> add(@RequestBody List<Driver> drivers){
        return ResponseEntity.status(HttpStatus.OK).body(driverService.save(drivers));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(driverService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findDriverById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(driverService.findDriverById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Driver driver){
        return ResponseEntity.status(HttpStatus.OK).body(driverService.save(driver));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(driverService.delete(id));
    }
}
