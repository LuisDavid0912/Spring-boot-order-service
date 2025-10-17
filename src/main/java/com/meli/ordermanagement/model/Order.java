package com.meli.ordermanagement.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * This class is the "Blueprint" for an Order. It defines all the properties an order can have.
 * It's not code that "runs," it's just a definition of data.
 *
 * @Entity This tag tells Spring: "Hey, this blueprint should be turned into a table in my database."
 * @Table(name = "orders") This specifically names the database table "orders" (which is good, since "order" is a reserved SQL word).
 * @Data This is a shortcut from the Lombok library. It automatically writes all the boring "getter" and "setter" methods
 * for us in the background, so our code stays clean.
 */
@Entity
@Table(name = "orders")
@Data
public class Order {

    /**
     * The unique tracking number for the order.
     * @Id This marks it as the Primary Key (the main ID).
     * @GeneratedValue This tells the database to automatically generate this number (like 1, 2, 3...)
     * whenever we create a new order.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the customer who placed the order.
     */
    private String customerName;

    /**
     * The exact date and time when the order was created.
     */
    private LocalDateTime orderDate;

    /**
     * The current status of the order (e.g., "Pending", "Shipped", "Cancelled").
     */
    private String status;

    /**
     * The total cost of the order.
     * We use BigDecimal because it's a special type that is very precise and safe for handling money.
     * (Using 'float' or 'double' for money can cause tiny rounding errors).
     */
    private BigDecimal totalAmount;
}