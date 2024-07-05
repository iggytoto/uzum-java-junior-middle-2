package com.example.demo.controllers.converter;

import com.example.demo.controllers.dto.AnimalDto;
import com.example.demo.domain.Animal;
import org.springframework.stereotype.Component;

@Component("animalConverter")
public class AnimalConverter implements Converter<AnimalDto, Animal> {

    @Override
    public Animal convert(AnimalDto t) {
        return new Animal(t.getId(), t.getName());
    }

    @Override
    public AnimalDto convertBack(Animal t) {
        final var result = new AnimalDto();
        result.setId(t.getId());
        result.setName(t.getName());
        return result;
    }
}
