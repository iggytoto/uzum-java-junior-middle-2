package com.example.demo.controllers;

import com.example.demo.domain.Cage;
import com.example.demo.services.ZooService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cage/")
@RequiredArgsConstructor
public class CageController {

    private final ZooService zooService;

    @GetMapping
    public List<Cage> getAllCages() {
        return zooService.getAllCages();
    }

    @PostMapping("/{cageId}/{animalId}")
    public Cage putAnimalInTheCage(
            @PathVariable("cageId") int cageId,
            @PathVariable("animalId") int animalId) {
        return zooService.putAnimalInTheCage(animalId,cageId);
    }

    @PostMapping("/add")
    public Cage createCage(){
        return zooService.createCage();
    }
}
