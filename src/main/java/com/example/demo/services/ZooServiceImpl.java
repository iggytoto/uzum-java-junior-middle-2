package com.example.demo.services;

import com.example.demo.domain.Animal;
import com.example.demo.domain.Cage;
import com.example.demo.infrastructure.AnimalRepository;
import com.example.demo.infrastructure.CageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZooServiceImpl implements ZooService {

    private final AnimalRepository animalRepository;
    private final CageRepository cageRepository;

    private final ExternalService externalService;


    @Override
    public List<Cage> getAllCages() {
        return cageRepository.findAll();
    }

    @Override
    public Cage putAnimalInTheCage(int animalId, int cageId) {
        final Animal animal = animalRepository.findById(animalId).orElseThrow();
        final Cage cage = cageRepository.findById(cageId).orElseThrow();

        cage.getAnimals().add(animal);

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
}
