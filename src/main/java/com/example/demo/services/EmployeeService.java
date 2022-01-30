package com.example.demo.services;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> saveAllEmployees(List<Employee> employees)
    {
        return employeeRepository.saveAll(employees);
    }

    public List<Employee> findAllEmployees()
    {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Integer id)
    {
        return employeeRepository.findByEmployeeId(id);
    }

    public List<Employee> findEmployeesByName(String name)
    {
        return employeeRepository.findByEmployeeName(name);
    }

    public List<Employee> findAllEmployeesById(List<Integer> employeeIds)
    {
        return employeeRepository.findAllById(employeeIds);
    }
}
