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

import com.meli.ordermanagement.dto.CreateOrderRequestDTO;
import com.meli.ordermanagement.dto.OrderResponseDTO;
import com.meli.ordermanagement.dto.UpdateOrderRequestDTO;
import com.meli.ordermanagement.service.OrderService;

import jakarta.validation.Valid;

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
     * It now accepts a DTO and uses @Valid to trigger validation rules.
     *
     * @param requestDTO The order DTO with user-provided data.
     * @return The newly created order as a response DTO and a "201 Created" status code.
     */
    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@Valid @RequestBody CreateOrderRequestDTO requestDTO) {
        OrderResponseDTO newOrder = orderService.createOrder(requestDTO);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    /**
     * This method handles fetching all orders in the system.
     * It now returns a list of DTOs, hiding internal database details.
     *
     * @return A list of all orders as DTOs and a "200 OK" status code.
     */
    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        List<OrderResponseDTO> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    /**
     * This method handles fetching a single, specific order by its ID.
     *
     * @param id The unique ID of the order to find.
     * @return The found order as a DTO with a "200 OK" status, or a "404 Not Found" status.
     */
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(orderDTO -> new ResponseEntity<>(orderDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * This method handles updating an existing order.
     * It now accepts an Update DTO and validates it.
     *
     * @param id         The ID of the order we want to update.
     * @param requestDTO The new information for the order (sent as a DTO).
     * @return The updated order as a DTO with a "200 OK" status, or "404 Not Found".
     */
    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> updateOrder(@PathVariable Long id, @Valid @RequestBody UpdateOrderRequestDTO requestDTO) {
        return orderService.updateOrder(id, requestDTO)
                .map(updatedOrder -> new ResponseEntity<>(updatedOrder, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * This method handles deleting an existing order.
     * It remains unchanged as it only operates on an ID.
     *
     * @param id The ID of the order we want to delete.
     * @return A "204 No Content" status if successful, or "404 Not Found".
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (orderService.deleteOrder(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}