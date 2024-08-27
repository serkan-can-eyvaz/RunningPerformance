package entity;

import jakarta.persistence.*;

import java.util.Date;
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
}
