package com.example.JpaPractice.repository;

import com.example.JpaPractice.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    public Department findByName(String name);
}
