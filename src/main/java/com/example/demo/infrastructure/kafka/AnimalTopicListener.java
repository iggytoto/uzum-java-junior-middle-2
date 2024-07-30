package com.example.demo.infrastructure.kafka;

import com.example.demo.domain.Animal;
import com.example.demo.services.ZooService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnimalTopicListener {

    private final ZooService zooService;

    @KafkaListener(topics = {"animals"}, groupId = "animal-group")
    public void consume(Animal animal) {
        zooService.registerNewAnimal(animal);
        System.out.println("Animal recieved and saved");
    }
}
