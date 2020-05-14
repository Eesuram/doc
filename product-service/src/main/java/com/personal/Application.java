package com.personal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.TreeMap;

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
    public Map<String, String> discounts() {
        return new TreeMap<String, String>() {
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

    @Bean
    public Map<String, String> priceRanges() {
        return new TreeMap<String, String>() {
            {
                put("0-100", "<= $100");
                put("0-200", "<= $200");
                put("0-300", "<= $300");
                put("0-400", "<= $400");
                put("0-500", "<= $500");
            }
        };
    }

}