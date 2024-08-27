package com.example.runningperformance.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "position")
    private  String position;
    @Column(name = "deparment")
    private String deparment;
    @Column(name = "startingDate")
    private Date startingDate;
    @Column(name = "salary")
    private long salary;

    @OneToMany(mappedBy = "employee")
    private List<Task> Employeetasks = new ArrayList<>();

    @ManyToMany(mappedBy = "employess")
    private List<Project>projects = new ArrayList<>();

    public Employee() {
    }

    public Employee(long empId, String name, String surname, String position, String deparment, Date startingDate, long salary) {
        this.empId = empId;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.deparment = deparment;
        this.startingDate = startingDate;
        this.salary = salary;
    }

    public Employee(String name, String surname, String position, String deparment, Date startingDate, long salary) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.deparment = deparment;
        this.startingDate = startingDate;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId && salary == employee.salary && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(position, employee.position) && Objects.equals(deparment, employee.deparment) && Objects.equals(startingDate, employee.startingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, name, surname, position, deparment, startingDate, salary);
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
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

    public List<Task> getEmployeetasks() {
        return Employeetasks;
    }

    public void setEmployeetasks(List<Task> employeetasks) {
        Employeetasks = employeetasks;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
