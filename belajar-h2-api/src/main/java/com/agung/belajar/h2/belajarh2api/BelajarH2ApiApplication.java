package com.agung.belajar.h2.belajarh2api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BelajarH2ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BelajarH2ApiApplication.class, args);
    }

}
