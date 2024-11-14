package org.example.formauto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("org.example.formauto.entities")
public class FormautoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormautoApplication.class, args);
    }

}
