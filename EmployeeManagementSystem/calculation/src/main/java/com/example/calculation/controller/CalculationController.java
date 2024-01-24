package com.example.calculation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculations")
public class CalculationController {

    @GetMapping
    public ResponseEntity<String> calculateHandler(){
        return new ResponseEntity<>("Calculation done (Dummy)", HttpStatus.OK);
    }
}
