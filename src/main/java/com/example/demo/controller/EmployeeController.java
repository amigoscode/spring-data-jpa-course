package com.example.demo.controller;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Constraint;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("employees/")
@Validated
//to check the method arguments being passed
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

    @PostMapping("addEmployee")
    public Employee addEmployee(@RequestBody @Valid Employee employee)
    {
        return employeeRepository.save(employee);
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
    public Employee getEmployeeById(@RequestParam @Min(value = 1, message = "Min value of ID should be 1")
                                                Integer employeeId)
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

    @GetMapping("getEmployeeByIdJPQL")
    public Employee getEmployeeByIdJPQL(@RequestParam Integer employeeId)
    {
        return employeeRepository.getEmployeeById(employeeId);
    }

    @GetMapping("getEmployeeByNameJPQL")
    public List<Employee> getEmployeeByNameJPQL(@RequestParam String name)
    {
        return employeeRepository.getEmployeeByName(name);
    }

    @GetMapping("getEmployeeByNameActiveJPQL")
    public List<Employee> getEmployeeByNameActiveJPQL(@RequestParam String name)
    {
        return employeeRepository.getEmployeeByNameActive(name);
    }

    @GetMapping("getEmployeeByNameAndStatusJPQL")
    public List<Employee> getEmployeeByNameAndStatusJPQL(@RequestParam String name, Boolean leftJob)
    {
        return employeeRepository.getEmployeeByNameAndStatus(name, leftJob);
    }

    @GetMapping("getEmployeeByDeptJPQL")
    public List<Employee> getEmployeeByDeptJPQL(@RequestParam String deptName)
    {
        return employeeRepository.getEmployeeByDept(deptName);
    }

    @GetMapping("getEmployeeByDeptsJPQL")
    public List<Employee> getEmployeeByDeptsJPQL(@RequestBody List<String> deptName)
    {
        return employeeRepository.getEmployeeByDepts(deptName);
    }

    @GetMapping("getEmployeeBySalaryJPQL")
    public List<Employee> getEmployeeBySalaryJPQL(@RequestParam Float baseSalary)
    {
        return employeeRepository.getEmployeeBySalary(baseSalary);
    }

    @GetMapping("getEmployeesBetweenAgesJPQL")
    public List<Employee> getEmployeesBetweenAges(@RequestParam Integer startAge, @RequestParam Integer endAge)
    {
        return employeeRepository.getEmployeesBetweenAges(startAge, endAge);
    }

    @GetMapping("getEmployeesNameDeptBetweenAgesJPQL")
    public List<Object> getEmployeesNameDeptBetweenAges(@RequestParam Integer startAge, @RequestParam Integer endAge)
    {
        return employeeRepository.getEmployeesNamesDeptsBetweenAges(startAge, endAge);
    }

    @GetMapping("getEmployeesNameDeptBetweenAgesNative")
    public List<Object> getEmployeesNameDeptBetweenAgesNative(@RequestParam Integer startAge,
                                                              @RequestParam Integer endAge)
    {
        return employeeRepository.getEmployeesNamesDeptsBetweenAgesNative(startAge, endAge);
    }

//    to throw a proper exception for method aryument Id being greater than 0 with @Validated annotation
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintValidationException(ConstraintViolationException ex)
    {
        return new ResponseEntity<>("Error:"+ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
