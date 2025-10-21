package com.meli.ordermanagement.service;

import com.meli.ordermanagement.dto.CreateOrderRequestDTO;
import com.meli.ordermanagement.dto.OrderResponseDTO;
import com.meli.ordermanagement.dto.UpdateOrderRequestDTO;
import com.meli.ordermanagement.model.Order;
import com.meli.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
     * The business logic for creating a new order using a DTO.
     *
     * @param requestDTO The "form" with the basic order info from the user.
     * @return The final, saved order, converted to a response DTO.
     */
    public OrderResponseDTO createOrder(CreateOrderRequestDTO requestDTO) {
        // Convert the incoming DTO to a database Entity
        Order order = new Order();
        order.setCustomerName(requestDTO.getCustomerName());
        order.setTotalAmount(requestDTO.getTotalAmount());
        
        // This is our business logic:
        // 1. Set the order's date to the exact time it was created.
        order.setOrderDate(LocalDateTime.now());
        // 2. Set the default status to "Pending".
        order.setStatus("Pending");

        // 3. Tell the repository to save this new order to the database.
        Order savedOrder = orderRepository.save(order);

        // Convert the saved Entity back to a DTO for the response
        return convertToDTO(savedOrder);
    }

    /**
     * Logic for getting a list of all orders, returned as DTOs.
     *
     * @return A list of every order in the database, converted to DTOs.
     */
    public List<OrderResponseDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::convertToDTO) // Convert each Order to an OrderResponseDTO
                .collect(Collectors.toList());
    }

    /**
     * Logic for finding one specific order, returned as a DTO.
     * We return an "Optional" because the order might not exist.
     *
     * @param id The ID of the order to find.
     * @return An Optional that might contain the order DTO, or might be empty.
     */
    public Optional<OrderResponseDTO> getOrderById(Long id) {
        return orderRepository.findById(id).map(this::convertToDTO);
    }

    /**
     * Logic for updating an existing order using a DTO.
     *
     * @param id           The ID of the order to update.
     * @param requestDTO An Order object containing the new information.
     * @return An Optional containing the updated order DTO, or empty if the ID wasn't found.
     */
    public Optional<OrderResponseDTO> updateOrder(Long id, UpdateOrderRequestDTO requestDTO) {
        // First, we find the order we want to update.
        return orderRepository.findById(id)
                .map(existingOrder -> {
                    // If we find it, we update its fields with the new details from the DTO.
                    existingOrder.setCustomerName(requestDTO.getCustomerName());
                    existingOrder.setStatus(requestDTO.getStatus());
                    existingOrder.setTotalAmount(requestDTO.getTotalAmount());
                    
                    // Finally, we save the changed order back to the database.
                    Order updatedOrder = orderRepository.save(existingOrder);

                    // Convert the updated entity to a DTO for the response
                    return convertToDTO(updatedOrder);
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

    /**
     * Private helper method to convert a database Order entity into a response DTO.
     * This avoids repeating code and separates concerns.
     *
     * @param order The database entity.
     * @return The response DTO.
     */
    private OrderResponseDTO convertToDTO(Order order) {
        OrderResponseDTO dto = new OrderResponseDTO();
        dto.setId(order.getId());
        dto.setCustomerName(order.getCustomerName());
        dto.setOrderDate(order.getOrderDate());
        dto.setStatus(order.getStatus());
        dto.setTotalAmount(order.getTotalAmount());
        return dto;
    }
}