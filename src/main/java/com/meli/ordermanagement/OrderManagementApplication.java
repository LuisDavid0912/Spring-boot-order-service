package com.meli.ordermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the "On Switch" for the entire application.
 *
 * @SpringBootApplication This one powerful tag tells Spring Boot to:
 * 1. Automatically configure all the settings.
 * 2. Scan all our other files (like Controller, Service, Repository) and understand how they connect.
 * 3. Start the web server.
 */
@SpringBootApplication
public class OrderManagementApplication {

    /**
     * This is the main "ignition key".
     * When we run this file, this 'main' method is what gets executed,
     * and the SpringApplication.run() command is what officially starts
     * the entire application.
     *
     * @param args Command-line arguments (we don't use them here, but it's required).
     */
    public static void main(String[] args) {
        SpringApplication.run(OrderManagementApplication.class, args);
    }

}