package entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
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
    @Column(name = "revantProjecet")
    private String revantProject;
    @Column(name = "assignedEmployee")
    private String assignedEmployee;
}
