package com.example.runningperformance.dto.request;

import jakarta.persistence.Column;

import java.util.Date;

public class EmployeeRequest  {

    private long employeeId;
    private String name;
    private String surname;
    private  String position;
    private String deparment;
    private Date startingDate;
    private long salary;

    public EmployeeRequest() {}

    public EmployeeRequest(long employeeId, String name, String surname, String position, String deparment, Date startingDate, long salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.deparment = deparment;
        this.startingDate = startingDate;
        this.salary = salary;
    }

    public EmployeeRequest(String name, String surname, String position, String deparment, Date startingDate, long salary) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.deparment = deparment;
        this.startingDate = startingDate;
        this.salary = salary;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDeparment() {
        return deparment;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
