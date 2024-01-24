package com.example.salary.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salary")
public class salaryController {
    @GetMapping
    public ResponseEntity<String> getSalaryHandler(){
        return new ResponseEntity<>("salary fetched", HttpStatus.OK);
    }
}
