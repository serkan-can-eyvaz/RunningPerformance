package com.example.runningperformance.dto.request;

import java.util.Date;
import java.util.List;

public class ProjectRequest {

    private String name;
    private Date startDate;
    private Date endDate;
    private long bugdet;
    private String projectManager;
    private List<Long> TaskIds;

    public ProjectRequest() {}

    public ProjectRequest(String name, Date startDate, Date endDate, long bugdet, String projectManager, List<Long> taskIds) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bugdet = bugdet;
        this.projectManager = projectManager;
        TaskIds = taskIds;
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

    public List<Long> getTaskIds() {
        return TaskIds;
    }

    public void setTaskIds(List<Long> taskIds) {
        TaskIds = taskIds;
    }
}
