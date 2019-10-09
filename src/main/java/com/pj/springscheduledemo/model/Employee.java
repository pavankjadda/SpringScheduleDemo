package com.pj.springscheduledemo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
@Data
public class Employee implements Serializable
{
    private static final long serialVersionUID = -5240924860000009802L;

    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email",unique = true, columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(name = "phone")
    private String phone;
}
