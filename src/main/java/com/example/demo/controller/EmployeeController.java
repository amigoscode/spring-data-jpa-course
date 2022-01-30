package com.example.demo.controller;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees/")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees)
    {
        return employeeService.saveAllEmployees(employees);
    }

    @GetMapping("allEmployees")
    public List<Employee> getAllEmployees()
    {
        return employeeService.findAllEmployees();
    }

    @GetMapping("employeesWithName")
    public List<Employee> getAllEmployeesWithName(@RequestParam String employeeName)
    {
        return employeeService.findEmployeesByName(employeeName);
    }

    @GetMapping("employeeById")
    public Employee getEmployeeById(@RequestParam Integer employeeId)
    {
        return employeeService.findEmployeeById(employeeId);
    }

    @GetMapping("employeesById")
    public List<Employee> getEmployeesIdBy(@RequestBody List<Integer> employeeIds)
    {
        return employeeService.findAllEmployeesById(employeeIds);
    }

    @GetMapping("employeesByNameAndActive")
    public List<Employee> getEmployeesByNameAndActive(@RequestParam("name") String employeeName)
    {
        return employeeRepository.findByEmployeeNameAndLeftJobFalse(employeeName);
    }
}
