package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Region {


    @Id
    @GeneratedValue
    private int id;

    @ManyToMany
    private Set<Cage> cages = new HashSet<>();
}
