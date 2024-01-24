package com.example.data.controller;

import com.example.data.entity.Employee;
import com.example.data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> registerNewEmployeeHandler(@RequestBody Employee employee){
        Employee registeredEmp = employeeService.regesterEmployee(employee);

        return new ResponseEntity<>(registeredEmp, HttpStatus.CREATED);
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployeeByIdHandler(@PathVariable Integer empId){
        Employee existingEmp = employeeService.getEmployeeById(empId);

        return new ResponseEntity<>(existingEmp, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmpListByDepartmentHandler(@RequestParam String department){
        List<Employee> empList = employeeService.getEmployeesByDepartment(department);

        return new ResponseEntity<>(empList, HttpStatus.OK);
    }
}
