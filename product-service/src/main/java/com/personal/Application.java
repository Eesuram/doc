package com.personal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring-Boot startup class to run the application
 *
 * @author Eswar Ambati
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Map<String, String> discountMap() {
        return new HashMap<String, String>() {
            {
                put("20", ">= 20%");
                put("40", ">= 40%");
                put("50", ">= 50%");
                put("60", ">= 60%");
                put("70", ">= 70%");
                put("80", ">= 80%");
                put("90", ">= 90%");
            }
        };
    }
}