package com.meli.ordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.ordermanagement.model.Order;
import com.meli.ordermanagement.service.OrderService;

/**
 * This is the main "Receptionist" for our application (a REST Controller).
 * It handles all incoming web requests related to orders.
 * The @RestController tag tells Spring that this class will be receiving and sending web requests (like JSON).
 * The @RequestMapping("/api/orders") tag means all URLs for this controller will start with "http://.../api/orders".
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    // The receptionist needs a direct line to the "brain" of the operation (our OrderService).
    private final OrderService orderService;

    /**
     * This is the constructor. When Spring builds this Controller, it automatically
     * "injects" or provides a ready-to-use copy of the OrderService. This is called dependency injection.
     *
     * @param orderService The main service (the "brain") that handles all the business logic.
     */
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * This method handles creating a new order.
     * It listens for a POST request to "/api/orders".
     * The @RequestBody tag tells Spring to take the JSON sent by the user and turn it into an Order object.
     *
     * @param order The order information (like customerName, totalAmount) sent by the user.
     * @return The newly created order (now with an ID and date) and a "201 Created" status code.
     */
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order newOrder = orderService.createOrder(order);
        // We return a ResponseEntity to have full control over the web response.
        // This sends back the new order and a "CREATED" status, which is the standard for a successful POST.
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    /**
     * This method handles fetching all orders in the system.
     * It listens for a GET request to "/api/orders".
     *
     * @return A list of all orders and a "200 OK" status code.
     */
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    /**
     * This method handles fetching a single, specific order by its ID.
     * It listens for a GET request to "/api/orders/{id}" (e.g., "/api/orders/1").
     * The @PathVariable tag grabs the "id" from the URL and passes it to the method.
     *
     * @param id The unique ID of the order to find.
     * @return The found order with a "200 OK" status, or a "404 Not Found" status if no order has that ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        // We use .map() and .orElse() to handle the two possible outcomes gracefully.
        return orderService.getOrderById(id)
                .map(order -> new ResponseEntity<>(order, HttpStatus.OK)) // Case 1: We found it.
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));      // Case 2: We didn't find it.
    }

    /**
     * This method handles updating an existing order.
     * It listens for a PUT request to "/api/orders/{id}".
     *
     * @param id           The ID of the order we want to update.
     * @param orderDetails The new information for the order (sent as JSON).
     * @return The updated order with a "200 OK" status, or "404 Not Found" if the ID doesn't exist.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        return orderService.updateOrder(id, orderDetails)
                .map(updatedOrder -> new ResponseEntity<>(updatedOrder, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * This method handles deleting an existing order.
     * It listens for a DELETE request to "/api/orders/{id}".
     *
     * @param id The ID of the order we want to delete.
     * @return A "204 No Content" status if the deletion was successful, or "404 Not Found" if the ID didn't exist.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (orderService.deleteOrder(id)) {
            // "No Content" is the standard response for a successful deletion.
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}