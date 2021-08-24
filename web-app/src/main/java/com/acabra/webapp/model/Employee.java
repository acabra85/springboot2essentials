package com.acabra.webapp.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "EMPLOYEE_ID")
    private String id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "POSITION")
    @Enumerated(EnumType.STRING)
    private JobPosition position;

    public Employee(String id, String name, String lastName, JobPosition position) {
        this.id = id;
        this.firstName = name;
        this.lastName = lastName;
        this.position = position;
    }

    public Employee() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public JobPosition getPosition() {
        return position;
    }

    public void setPosition(JobPosition position) {
        this.position = position;
    }
}
