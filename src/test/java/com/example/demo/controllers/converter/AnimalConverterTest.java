package com.example.demo.controllers.converter;

import com.example.demo.controllers.dto.AnimalDto;
import com.example.demo.domain.Animal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalConverterTest {

    private AnimalConverter converter = new AnimalConverter();

    @Test
    void convert() {
        Animal result = converter.convert(AnimalDto.builder().id(1).Name("test").build());
        Assertions.assertEquals(1,result.getId());
        Assertions.assertEquals("test",result.getName());
    }

    @Test
    void convertBack() {
    }
}