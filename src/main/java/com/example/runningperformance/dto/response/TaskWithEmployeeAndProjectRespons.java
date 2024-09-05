package com.example.runningperformance.dto.response;

import java.util.Date;

public class TaskWithEmployeeAndProjectRespons {
    private long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private EmployeeResponse employeeResponse;
    private ProjectResponse projectResponse;

    public TaskWithEmployeeAndProjectRespons()
    {}

    public TaskWithEmployeeAndProjectRespons(long id, String name, String description, Date startDate, Date endDate, EmployeeResponse employeeResponse, ProjectResponse projectResponse) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeResponse = employeeResponse;
        this.projectResponse = projectResponse;
    }

    public TaskWithEmployeeAndProjectRespons(String name, String description, Date startDate, Date endDate, EmployeeResponse employeeResponse, ProjectResponse projectResponse) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeResponse = employeeResponse;
        this.projectResponse = projectResponse;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public EmployeeResponse getEmployeeResponse() {
        return employeeResponse;
    }

    public void setEmployeeResponse(EmployeeResponse employeeResponse) {
        this.employeeResponse = employeeResponse;
    }

    public ProjectResponse getProjectResponse() {
        return projectResponse;
    }

    public void setProjectResponse(ProjectResponse projectResponse) {
        this.projectResponse = projectResponse;
    }
}
