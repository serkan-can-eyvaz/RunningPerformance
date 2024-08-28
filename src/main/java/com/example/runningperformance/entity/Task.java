package com.example.runningperformance.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;
    @Column(name = "relevantProjecet")
    private String relevantProject;
    @Column(name = "assignedEmployee")
    private String assignedEmployee;

    @ManyToOne
    @JoinColumn(name = "employeedId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "projectId")
    private Project project;

    public Task()
    {

    }
    public Task(long id, String name, String description, Date startDate, Date endDate, String relevantProject, String assignedEmployee, Employee employee, Project project) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.relevantProject = relevantProject;
        this.assignedEmployee = assignedEmployee;
        this.employee = employee;
        this.project = project;
    }

    public Task(String name, String description, Date startDate, Date endDate, String relevantProject, String assignedEmployee, Employee employee, Project project) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.relevantProject = relevantProject;
        this.assignedEmployee = assignedEmployee;
        this.employee = employee;
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(startDate, task.startDate) && Objects.equals(endDate, task.endDate) && Objects.equals(relevantProject, task.relevantProject) && Objects.equals(assignedEmployee, task.assignedEmployee) && Objects.equals(employee, task.employee) && Objects.equals(project, task.project);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, startDate, endDate, relevantProject, assignedEmployee, employee, project);
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

    public String getRelevantProject() {
        return relevantProject;
    }

    public void setRelevantProject(String revantProject) {
        this.relevantProject = revantProject;
    }

    public String getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(String assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
