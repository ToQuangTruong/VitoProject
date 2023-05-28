package com.example.demo.controller;

import com.example.demo.entity.Coach;
import com.example.demo.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {

    @Autowired
    private CoachService coachService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Coach coach){
        return ResponseEntity.status(HttpStatus.OK).body(coachService.save(coach));
    }

    @PostMapping("/adds")
    public ResponseEntity<?> add(@RequestBody List<Coach> coachs) {
        return ResponseEntity.status(HttpStatus.OK).body(coachService.save(coachs));
    }

    @GetMapping("/findAll")
    public ResponseEntity<?>  findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(coachService.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findCoachById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(coachService.findCoachById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Coach coach){
        return ResponseEntity.status(HttpStatus.OK).body(coachService.save(coach));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(coachService.delete(id));
    }
}
