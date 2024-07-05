package com.example.demo.domain;

import jakarta.persistence.*;
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

    @OneToOne
    private Animal animal;

    @ManyToMany
    private Set<Region> regions = new HashSet();

}
