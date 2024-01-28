package com.example.JpaPractice.controller;

import com.example.JpaPractice.Entity.Department;
import com.example.JpaPractice.Entity.Employee;
import com.example.JpaPractice.repository.DepartmentRepository;
import com.example.JpaPractice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @PostMapping("employees")
    public ResponseEntity<Employee> addEmpHandler(@RequestBody Employee emp){
        Department existindDepartment = departmentRepository.findByName(emp.getDepartment().getName());
        if(existindDepartment != null){
            emp.setDepartment(existindDepartment);
        }
        return new ResponseEntity<>(employeeRepository.save(emp), HttpStatus.CREATED);
    }

    @PatchMapping("employees/{empId}/{managerId}")
    public ResponseEntity<String> assignManagerToEmp(@PathVariable Integer empId, @PathVariable Integer managerId){
        if(Objects.equals(empId, managerId)) throw  new RuntimeException("manager Id and Employee Id can't be same");

        Employee existingEmp = employeeRepository.findById(empId).orElseThrow(()-> new RuntimeException("Invalid emp Id"));

        Employee existingManager = employeeRepository.findById(managerId).orElseThrow(()-> new RuntimeException("Invalid manager Id"));

        existingEmp.setManager(existingManager);
        employeeRepository.save(existingEmp);
        return new ResponseEntity<>("manager assigned successfully", HttpStatus.OK);

    }

    @GetMapping("/employees/{department}")
    public ResponseEntity<List<Employee>> employeeByDepartmentNameHandler(@PathVariable String department){
        List<Employee> employeeList = employeeRepository.findByDepartment_Name(department);

        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/employeesAfterDate/{date}")
    public ResponseEntity<List<Employee>> getEmpHandlerAfterDate(@PathVariable LocalDate date){
        List<Employee> employeeList = employeeRepository.findByJoinDateAfter(date);

        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
    @GetMapping("/employeesBySkill/{skill}")
    public ResponseEntity<List<Employee>> getEmployeeBasedOnOneSkill(@PathVariable String skill){

        List<Employee> employeeList = employeeRepository.findBySkillsContainingIgnoreCase(skill);

        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/employeesBySkills/{skill1}/{skill2}")
    public ResponseEntity<List<Employee>> getEmployeeBasedOnTwoSkill(@PathVariable String skill1, @PathVariable String skill2){

        List<Employee> employeeList = employeeRepository.findBySkillsContainingAndSkillsContaining(skill1, skill2);

        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }
}
