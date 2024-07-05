package com.example.demo.controllers;

import com.example.demo.controllers.dto.AnimalDto;
import com.example.demo.infrastructure.dal.AnimalRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AnimalControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    AnimalRepository animalRepository;

    @Test
    void getAllAnimals() throws Exception {


        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/animal/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        List<AnimalDto> animalDtos = mapper.readValue(mvcResult.getResponse().getContentAsByteArray(), new TypeReference<List<AnimalDto>>() {
        });

        Assertions.assertEquals(1, animalDtos.size());
        Assertions.assertEquals(1, animalDtos.get(0).getId());
        Assertions.assertEquals("asdasd", animalDtos.get(0).getName());
    }

    @Test
    void saveNewAnimal() {
    }
}