package com.personal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Spring-Boot startup class to run the application
 *
 * @author Eswar Ambati
 */
@SpringBootApplication
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

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

    /**
     * Added cors configuration to support requests from cross origins.
     *
     * @param request - the http servlet request
     * @return - CorsConfigurationSource
     */
    @Primary
    @Bean
    public CorsConfigurationSource corsConfiguration(HttpServletRequest request) {
        return new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest httpServletRequest) {
                LOG.info("Enabled CORS for all Origins, Methods and Headers");
                CorsConfiguration corsConfiguration = new CorsConfiguration();

                corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
                corsConfiguration.setAllowCredentials(true);
                corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
                corsConfiguration.setAllowedMethods(Arrays.asList("GET", "PUT", "OPTIONS", "POST", "HEAD", "DELETE"));

                return corsConfiguration;
            }
        };
    }


}