package com.ironhack.femsa.ecomerce_lab08.controller;

import com.ironhack.femsa.ecomerce_lab08.dto.CreateOrderRequest;
import com.ironhack.femsa.ecomerce_lab08.model.Order;
import com.ironhack.femsa.ecomerce_lab08.model.OrderItem;
import com.ironhack.femsa.ecomerce_lab08.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Order controller.
 */
@RestController
@RequestMapping("/api/v1")
@Tag(name = "API para Comercio Electrónico - Orders",
        description = "Endpoints para gestionar ordenes")
public class OrderController {

    private final OrderService orderService;

    /**
     * Instantiates a new Order controller.
     *
     * @param orderService the order service
     */
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Create order response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping("/orders")
    @Operation(summary = "Crear pedido", description = "Permite a un usuario crear un nuevo pedido")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest request) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setProducts(request.getProducts().stream()
                .map(p -> {
                    OrderItem item = new OrderItem();
                    item.setProductId(p.getProductId());
                    item.setQuantity(p.getQuantity());
                    return item;
                }).toList());
        return ResponseEntity.ok(orderService.createOrder(order));
    }
}
