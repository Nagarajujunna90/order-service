package com.example.orderservice.service;

import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.Order;

import java.util.List;

public interface OrderService {
    String createOrder(OrderRequest orderRequest);

    Order updateOrder(Order orderRequest, Integer orderId);

    Order getOrderById(Integer orderId);

    List<Order> getAllOrders();

    void deleteOrderById(Integer orderId);
}
