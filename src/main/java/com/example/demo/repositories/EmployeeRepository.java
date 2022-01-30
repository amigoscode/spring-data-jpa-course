package com.example.demo.repositories;

import com.example.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmployeeId(Integer employeeId);
    List<Employee> findByEmployeeName(String employeeName);
    List<Employee> findByEmployeeNameAndLeftJobFalse(String employeeName);
}
