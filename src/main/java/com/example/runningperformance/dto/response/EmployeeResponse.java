package com.example.runningperformance.dto.response;

import jakarta.persistence.Column;

import java.util.Date;
import java.util.List;

public class EmployeeResponse {
    private long id;
    private String name;
    private String surname;
    private  String position;
    private String deparment;
    private Date startingDate;

    private long salary;
    private List<TaskResponse> taskResponseList;

    public  EmployeeResponse() {}

    public EmployeeResponse(long id,String name, String surname, String position, String deparment, Date startingDate, long salary, List<TaskResponse> taskResponseList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.deparment = deparment;
        this.startingDate = startingDate;

        this.salary = salary;
        this.taskResponseList = taskResponseList;
    }

    public EmployeeResponse(long id, String name, String surname, String position, String deparment, Date startingDate, long salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.deparment = deparment;
        this.startingDate = startingDate;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<TaskResponse> getTaskResponseList() {
        return taskResponseList;
    }

    public void setTaskResponseList(List<TaskResponse> taskResponseList) {
        this.taskResponseList = taskResponseList;
    }
}
