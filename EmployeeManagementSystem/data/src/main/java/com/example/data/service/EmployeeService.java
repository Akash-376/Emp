package com.example.data.service;

import com.example.data.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee regesterEmployee(Employee employee);

    public Employee getEmployeeById(Integer empId);

    public List<Employee> getEmployeesByDepartment(String department);
}
