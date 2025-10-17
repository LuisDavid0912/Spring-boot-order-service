package com.meli.ordermanagement.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.ordermanagement.model.Order;
import com.meli.ordermanagement.repository.OrderRepository;

/**
 * This is the "Brain" of the application (a Service).
 * It holds all the business logic and coordinates the work.
 *
 * For example, the Controller (receptionist) says "Hey, I have a new order,"
 * and the Service (brain) says "Great, I'll add the date and status, and then I'll
 * tell the Repository (database manager) to save it."
 *
 * @Service This tag tells Spring: "This class contains the main business logic."
 */
@Service
public class OrderService {

    // The brain needs its main tool: the "database manager" (Repository).
    private final OrderRepository orderRepository;

    /**
     * Constructor for the service.
     * Spring's @Autowired will automatically provide (inject) the OrderRepository
     * so this service can use it.
     *
     * @param orderRepository The repository that will handle database operations.
     */
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /**
     * The business logic for creating a new order.
     *
     * @param order The basic order info from the user.
     * @return The final, saved order (now with an ID, date, and status).
     */
    public Order createOrder(Order order) {
        // This is our business logic:
        // 1. Set the order's date to the exact time it was created.
        order.setOrderDate(LocalDateTime.now());
        // 2. Set the default status to "Pending".
        order.setStatus("Pending");
        
        // 3. Tell the repository to save this new order to the database.
        return orderRepository.save(order);
    }

    /**
     * Logic for getting a list of all orders.
     *
     * @return A list of every order in the database.
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Logic for finding one specific order.
     * We return an "Optional" because the order might not exist,
     * and this is a safe way to handle that possibility.
     *
     * @param id The ID of the order to find.
     * @return An Optional that might contain the order, or might be empty.
     */
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    /**
     * Logic for updating an existing order.
     *
     * @param id           The ID of the order to update.
     * @param orderDetails An Order object containing the new information.
     * @return An Optional containing the updated order, or empty if the ID wasn't found.
     */
    public Optional<Order> updateOrder(Long id, Order orderDetails) {
        // First, we find the order we want to update.
        return orderRepository.findById(id)
                .map(existingOrder -> {
                    // If we find it, we update its fields with the new details.
                    existingOrder.setCustomerName(orderDetails.getCustomerName());
                    existingOrder.setStatus(orderDetails.getStatus());
                    existingOrder.setTotalAmount(orderDetails.getTotalAmount());
                    // Finally, we save the changed order back to the database.
                    return orderRepository.save(existingOrder);
                });
    }

    /**
     * Logic for deleting an order.
     *
     * @param id The ID of the order to delete.
     * @return 'true' if the deletion was successful, 'false' if the order was not found.
     */
    public boolean deleteOrder(Long id) {
        // First, find the order.
        return orderRepository.findById(id)
                .map(order -> {
                    // If we find it, delete it.
                    orderRepository.delete(order);
                    return true; // Report success.
                }).orElse(false); // Otherwise, report failure (it wasn't found).
    }
}