package com.example.runningperformance.dto.response;

import jakarta.persistence.Column;

import java.util.Date;

public class ProjectResponse
{
    private long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private long bugdet;
    private String projectManager;

    public ProjectResponse() {
    }

    public ProjectResponse(long id, String name, Date startDate, Date endDate, long bugdet, String projectManager) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bugdet = bugdet;
        this.projectManager = projectManager;
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

    public long getBugdet() {
        return bugdet;
    }

    public void setBugdet(long bugdet) {
        this.bugdet = bugdet;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }
}
