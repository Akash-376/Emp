package com.example.JpaPractice.repository;

import com.example.JpaPractice.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findByDepartment_Name(String department);

    public List<Employee> findByJoinDateAfter(LocalDate date);

    public List<Employee> findBySkillsContainingIgnoreCase(String skill);
    public List<Employee> findBySkillsContainingAndSkillsContaining(String skill1, String skill2);
}
