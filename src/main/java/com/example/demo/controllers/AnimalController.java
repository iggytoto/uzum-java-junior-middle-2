package com.example.demo.controllers;

import com.example.demo.controllers.converter.AnimalConverter;
import com.example.demo.controllers.converter.Converter;
import com.example.demo.controllers.dto.AnimalDto;
import com.example.demo.domain.Animal;
import com.example.demo.services.ZooService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
@RequiredArgsConstructor
public class AnimalController {
    private final ZooService zooService;
    private final Converter<AnimalDto, Animal> animalDtoConverter;


    @GetMapping("/all")
    public List<AnimalDto> getAllAnimals() {
        return zooService.getAllAnimals().stream().map(animalDtoConverter::convertBack).toList();
    }

    @GetMapping("/test/{pathparam1}/{pathparam2}/")
    public void test(
            @PathVariable("pathparam1") String pp1,
            @PathVariable("pathparam2") String pp2,
            @RequestParam("queryp1") String qp1,
            @RequestBody Object rb
    ){
        System.out.println("Asdasdasd");
    }


    @PostMapping("/add")
    public AnimalDto saveNewAnimal(@RequestBody() AnimalDto animal) {
        return animalDtoConverter.convertBack(zooService.registerNewAnimal(animalDtoConverter.convert(animal)));
    }

}
