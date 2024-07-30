package com.example.demo.services;

import com.example.demo.domain.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, Animal> kafkaTemplate;

    private final String TOPIC = "animals";


    public void send(Animal animalToSend) {
        final CompletableFuture<SendResult<String, Animal>> f = kafkaTemplate.send(TOPIC, animalToSend);
        f.whenComplete((result, exception) -> {
            if (exception != null) {
                f.completeExceptionally(exception);
            } else {
                f.complete(result);
            }
        });
        System.out.println("Animal send to kafka topic:" + TOPIC);
    }
}
