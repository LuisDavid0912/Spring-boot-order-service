package com.meli.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meli.ordermanagement.model.Order;

/**
 * This is the "Database Manager" interface (a Repository).
 * Its only job is to talk to the database.
 *
 * @Repository This tag tells Spring: "This file is in charge of database operations."
 *
 * By "extending" JpaRepository, we get a huge amount of pre-built functionality from Spring Data JPA.
 * Spring automatically gives us methods like save(), findById(), findAll(), delete(), etc., for our "Order" blueprint.
 * We don't have to write any SQL code at all!
 *
 * It knows to manage "Order" objects, and it knows their ID is of type "Long".
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // That's it! No more code is needed here.
    // Spring provides all the functionality in the background.
}