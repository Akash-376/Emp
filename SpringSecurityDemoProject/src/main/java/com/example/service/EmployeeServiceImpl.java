package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee regesterEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer empId){
        return employeeRepository.findById(empId).orElseThrow(()-> new RuntimeException("invalid employee Id: "+ empId));
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        List<Employee> empList = employeeRepository.findByDepartment(department);
        if (empList.isEmpty()) throw new RuntimeException("No any employee found in database");

        return empList;
    }
}
