package com.example.demo.services;

import com.example.demo.domain.Animal;
import com.example.demo.domain.Cage;

import java.util.List;

public interface ZooService {

    List<Cage> getAllCages();

    Cage putAnimalInTheCage(int animalId, int cageId);

    List<Animal> getAllAnimals();


    Animal registerNewAnimal(Animal animal);

    Cage createCage();
}
