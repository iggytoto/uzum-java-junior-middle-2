package com.example.demo.services;

import com.example.demo.domain.Cage;
import com.example.demo.infrastructure.AnimalRepository;
import com.example.demo.infrastructure.CageRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ZooServiceImplTest {

    @Autowired
    private ZooServiceImpl instance;

    @Autowired
    private CageRepository cageRepository;

    @MockBean
    private ExternalService externalService;

    @Test
    public void getAllCages(){
        cageRepository.save(new Cage());
        cageRepository.save(new Cage());
        cageRepository.save(new Cage());

        Assertions.assertEquals(3,instance.getAllCages().size());
    }

    @Test
    public void getAllAnimals(){
        Mockito.when(externalService.getString()).thenReturn("dddd");

        instance.getAllAnimals();

    }

}