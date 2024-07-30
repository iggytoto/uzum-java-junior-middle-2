package com.example.demo;

import com.example.demo.domain.Animal;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Map;

@Configuration
public class DemoApplicationKafkaConfiguration {

    @Bean
    public NewTopic animalTopic() {
        return TopicBuilder
                .name("animals")
                .build();
    }

//    @Bean
//    public ConsumerFactory<String, ?> consumerFactory(ConsumerConfig cc) {
//
//        final var ds = new JsonDeserializer<>();
//        ds.addTrustedPackages("*");
//
//        return new DefaultKafkaConsumerFactory<>(
//                cc.originals(),
//                new StringDeserializer(),
//                ds
//        );
//    }
}
