package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;
    @Column(name = "budget")
    private long bugdet;
    @Column(name = "projectManager")
    private String projectManager;

    @OneToMany(mappedBy = "project")
    private List<Task>projectTasks = new ArrayList<Task>();

    @ManyToMany
    @JoinTable(name = "employeeProject",joinColumns = @JoinColumn(name ="projectId"),inverseJoinColumns = @JoinColumn(name ="employeeId" ))
    private List<Employee>employees = new ArrayList<>();

    public Project(){}

    public Project(long id, String name, Date startDate, Date endDate, long bugdet, String projectManager, List<Task> projectTasks, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bugdet = bugdet;
        this.projectManager = projectManager;
        this.projectTasks = projectTasks;
        this.employees = employees;
    }

    public Project(String name, Date startDate, Date endDate, long bugdet, String projectManager, List<Task> projectTasks, List<Employee> employees) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.bugdet = bugdet;
        this.projectManager = projectManager;
        this.projectTasks = projectTasks;
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id && bugdet == project.bugdet && Objects.equals(name, project.name) && Objects.equals(startDate, project.startDate) && Objects.equals(endDate, project.endDate) && Objects.equals(projectManager, project.projectManager) && Objects.equals(projectTasks, project.projectTasks) && Objects.equals(employees, project.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, endDate, bugdet, projectManager, projectTasks, employees);
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

    public List<Task> getProjectTasks() {
        return projectTasks;
    }

    public void setProjectTasks(List<Task> projectTasks) {
        this.projectTasks = projectTasks;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
