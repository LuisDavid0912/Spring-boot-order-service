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

@ExtendWith(MockitoExtension.class) // Habilita la magia de Mockito
public class OrderServiceTest {

    @Mock // 1. Creamos una versión "falsa" del Repository
    private OrderRepository orderRepository;

    @InjectMocks // 2. Creamos una instancia real del Service, pero le "inyectamos" el Repository falso
    private OrderService orderService;

    @Test // 3. Esto marca el método como una prueba que se puede ejecutar
    public void whenGetAllOrders_shouldReturnOrderList() {
        // Arrange: Preparamos el escenario
        List<Order> mockOrders = new ArrayList<>();
        mockOrders.add(new Order()); // Agregamos una orden de ejemplo
        when(orderRepository.findAll()).thenReturn(mockOrders); // 4. Le decimos al Repository falso qué hacer

        // Act: Ejecutamos la acción que queremos probar
        List<Order> foundOrders = orderService.getAllOrders();

        // Assert: Verificamos que el resultado es el esperado
        assertThat(foundOrders).isNotEmpty();
        assertThat(foundOrders.size()).isEqualTo(1);
    }
}