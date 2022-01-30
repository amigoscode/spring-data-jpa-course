package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    @JsonIgnore
    private Integer employeeId;

    @Column(name = "employee_name", nullable = false, length = 100)
    private String employeeName;

    @Column(name = "department", nullable = false, length = 100)
    private String department;

    @Column(name = "joining_date", nullable = false)
    private Date joiningDate;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "address", nullable = false, length = 250)
    private String address;

    @Column(name = "salary", nullable = false, precision = 7, scale = 2)
    private Float salary;

    @Column(name = "left_on")
    private ZonedDateTime leftOn;

    @Column(name = "left_job", nullable = false)
    private boolean leftJob;

    public Employee(Integer employeeId, String employeeName, String department,
                    Date joiningDate, Integer age, String address, Float salary, ZonedDateTime leftOn, boolean leftJob) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.joiningDate = joiningDate;
        this.age = age;
        this.address = address;
        this.salary = salary;
        this.leftOn = leftOn;
        this.leftJob = leftJob;
    }

    public Employee() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public ZonedDateTime getLeftOn() {
        return leftOn;
    }

    public void setLeftOn(ZonedDateTime leftOn) {
        this.leftOn = leftOn;
    }

    public boolean isLeftJob() {
        return leftJob;
    }

    public void setLeftJob(boolean leftJob) {
        this.leftJob = leftJob;
    }
}
