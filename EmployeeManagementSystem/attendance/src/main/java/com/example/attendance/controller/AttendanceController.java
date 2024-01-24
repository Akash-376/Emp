package com.example.attendance.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    @GetMapping
    public ResponseEntity<String> getAttendance(){
        return new ResponseEntity<>("Attendance fetched from database", HttpStatus.OK);
    }
}
