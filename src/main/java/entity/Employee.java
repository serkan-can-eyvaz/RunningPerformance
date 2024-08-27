package entity;

import jakarta.persistence.*;

import java.util.Date;

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
}
