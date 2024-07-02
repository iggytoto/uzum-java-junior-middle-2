package com.example.demo.services;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class ExternalServiceImpl implements ExternalService {
    @SneakyThrows
    @Override
    public String getString() {
        Thread.sleep(1000);
        return "asdasdasdasd";
    }
}
