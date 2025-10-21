package com.meli.ordermanagement.service;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.meli.ordermanagement.model.Order;
import com.meli.ordermanagement.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock 
    private OrderRepository orderRepository;

    @InjectMocks 
    private OrderService orderService;

    @Test 
    public void whenGetAllOrders_shouldReturnOrderList() {
        List<Order> mockOrders = new ArrayList<>();
        mockOrders.add(new Order()); 
        when(orderRepository.findAll()).thenReturn(mockOrders); 

        List<com.meli.ordermanagement.dto.OrderResponseDTO> foundOrders = orderService.getAllOrders();

        assertThat(foundOrders).isNotEmpty();
        assertThat(foundOrders.size()).isEqualTo(1);
    }
}