package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.hibernate.collection.spi.PersistentSet;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Cage {

    @Id
    @GeneratedValue
    private int number;

    @OneToMany()
    private Set<Animal> animals = new HashSet<>();

}
