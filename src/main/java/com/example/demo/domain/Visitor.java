package com.example.demo.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@DiscriminatorValue("person")
public class Visitor extends Person {

    private String name;
}
