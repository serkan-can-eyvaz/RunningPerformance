package com.example.runningperformance.dto.request;

import jakarta.persistence.Column;

import java.util.Date;

public class TaskRequest {
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private String relevantProject;
    private  String assignedEmployee;
    private Long assignedEmployeeId; // Employee ID
    private Long projectId; // Project ID

    public TaskRequest() {
    }

    public TaskRequest(String name, String description, Date startDate, Date endDate, String revantProject) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.relevantProject = relevantProject;

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

    public String getRelevantProject() {
        return relevantProject;
    }

    public void setRelevantProject(String revantProject) {
        this.relevantProject = relevantProject;
    }

    public Long getAssignedEmployeeId() {
        return assignedEmployeeId;
    }

    public void setAssignedEmployeeId(Long assignedEmployeeId) {
        this.assignedEmployeeId = assignedEmployeeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(String assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }
}
