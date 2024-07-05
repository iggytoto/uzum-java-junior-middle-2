package com.example.demo.services;

import com.example.demo.domain.Animal;
import com.example.demo.domain.Cage;
import com.example.demo.infrastructure.dal.AnimalRepository;
import com.example.demo.infrastructure.dal.CageRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZooServiceImpl implements ZooService {

    private final AnimalRepository animalRepository;
    private final CageRepository cageRepository;

    private final ExternalService externalService;

    private final EntityManager entityManager;


    @Override
    public List<Cage> getAllCages() {
        return cageRepository.findAll();
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT)
    public Cage putAnimalInTheCage(int animalId, int cageId) {
        final Animal animal = animalRepository.findById(animalId).orElseThrow();
        final Cage cage = cageRepository.findById(cageId).orElseThrow();

        cage.setAnimal(animal);

        cageRepository.save(cage);
        return cage;
    }

    @Override
    public List<Animal> getAllAnimals() {
        System.out.println(externalService.getString());
        return animalRepository.findAll();
    }

    @Override
    public Animal registerNewAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Cage createCage() {
        return cageRepository.save(new Cage());
    }

    @Override
    public List<Animal> getAnimalByName(String name) {
        return animalRepository.getAnimalsByName(name);
    }
}
