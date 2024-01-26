package com.example.common.controller;

import com.example.data.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public class commonController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String DATA_BASE_URL = "http://localhost:8081";
    private static final String ATTENDANCE_BASE_URL = "http://localhost:8082";
    private static final String SALARY_BASE_URL = "http://localhost:8083";
    private static final String CALCULATION_BASE_URL = "http://localhost:8084";


    @PostMapping("/employees")
    public Employee registerNewEmployeeHandler(@RequestBody Employee employee){

        String url = DATA_BASE_URL+"/employees";

        return restTemplate.postForObject(url, new HttpEntity<>(employee), Employee.class);

    }
    @GetMapping("/employees/{empId}")
    public ResponseEntity<Employee> getEmployeeByIdHandler(@PathVariable Integer empId){

        String url = DATA_BASE_URL+"/employees/"+empId;

        Employee res = restTemplate.getForObject(url, Employee.class);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmpListByDepartmentHandler(@RequestParam String department){

        String url = DATA_BASE_URL+"/employees?department="+department;
        List<Employee> empList = Arrays.stream(Objects.requireNonNull(restTemplate.getForObject(url, Employee[].class))).toList();
        return new ResponseEntity<>(empList, HttpStatus.OK);
    }

    @GetMapping("/attendances")
    public ResponseEntity<String> getAttendance(){

        String url = ATTENDANCE_BASE_URL+"/attendances";

        return new ResponseEntity<>(restTemplate.getForObject(url, String.class), HttpStatus.OK);
    }

    @GetMapping("/salary")
    public ResponseEntity<String> getSalaryHandler(){

        String url = SALARY_BASE_URL+"/salary";

        return new ResponseEntity<>(restTemplate.getForObject(url, String.class), HttpStatus.OK);
    }

    @GetMapping("/calculations")
    public ResponseEntity<String> calculateHandler(){
        String url = CALCULATION_BASE_URL+"/calculations";
        return new ResponseEntity<>(restTemplate.getForObject(url, String.class), HttpStatus.OK);
    }

}
