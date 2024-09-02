package com.example.runningperformance.dto.request;

import java.util.Date;
import java.util.List;

public class EmployeeRequest  {
    private String name;
    private String surname;
    private String position;
    private String deparment;
    private Date startingDate;
    private long salary;
    private List<Long> taskIds; // TaskRequest yerine Long tipinde task ID'leri

    public EmployeeRequest() {}

    public EmployeeRequest(String name, String surname, String position, String deparment, Date startingDate, long salary) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.deparment = deparment;
        this.startingDate = startingDate;
        this.salary = salary;
    }

    public List<Long> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<Long> taskIds) {
        this.taskIds = taskIds;
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
