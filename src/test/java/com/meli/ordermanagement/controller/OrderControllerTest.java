package com.meli.ordermanagement.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.ordermanagement.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // 1. Levanta una aplicación de Spring Boot completa para la prueba
@AutoConfigureMockMvc // 2. Nos da una herramienta para simular peticiones web
@Transactional // 3. Asegura que la base de datos se limpie después de cada prueba
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc; // 4. El "Postman" para nuestras pruebas

    @Autowired
    private ObjectMapper objectMapper; // Una herramienta para convertir objetos Java a JSON

    @Test
    public void whenCreateOrder_thenStatus201AndOrderReturned() throws Exception {
        // Arrange: Preparamos el escenario
        Order newOrder = new Order();
        newOrder.setCustomerName("Integration Test Customer");
        newOrder.setTotalAmount(new BigDecimal("123.45"));

        // Act & Assert: Ejecutamos la acción y verificamos el resultado
        mockMvc.perform(post("/api/orders") // Simula una petición POST
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newOrder)))
                .andExpect(status().isCreated()) // Esperamos un status 201 Created
                .andExpect(jsonPath("$.id").exists()) // Verificamos que la respuesta JSON tenga un ID
                .andExpect(jsonPath("$.customerName").value("Integration Test Customer"))
                .andExpect(jsonPath("$.status").value("Pending"));
    }

    @Test
    public void whenGetAllOrders_thenStatus200AndListReturned() throws Exception {
        // Arrange: Primero creamos una orden para que la lista no esté vacía
        Order order = new Order();
        order.setCustomerName("Another Customer");
        order.setTotalAmount(new BigDecimal("99.99"));

        mockMvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(order)));

        // Act & Assert
        mockMvc.perform(get("/api/orders")) // Simula una petición GET
                .andExpect(status().isOk()) // Esperamos un status 200 OK
                .andExpect(jsonPath("$").isArray()) // Verificamos que la respuesta sea una lista
                .andExpect(jsonPath("$[0].customerName").value("Another Customer"));
    }
}