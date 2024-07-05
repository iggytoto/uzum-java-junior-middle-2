package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class AnimalGroup {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    private Set<Animal> animals = new HashSet<>();

}
