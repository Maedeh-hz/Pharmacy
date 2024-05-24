package com.example.pharmacy_spring_boot.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PasswordGenerator {
    @Bean
    public PasswordGenerator passwordGenerator(){
        return new PasswordGenerator();
    }
}
