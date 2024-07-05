package com.example.demo.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("employee")
public class Employee extends Person {

    private String rank;
}
