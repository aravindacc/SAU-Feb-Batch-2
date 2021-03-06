package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DriverClass {

    public static void main(String[] args) {
        System.out.println("Starting Kafka Order System Application on port 8083");
        SpringApplication.run(DriverClass.class, args);

    }

}