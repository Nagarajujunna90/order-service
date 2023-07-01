package com.example.orderservice.service;

import com.example.orderservice.model.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order orderRequest);

    Order updateOrder(Order orderRequest, Integer orderId);

    Order getOrderById(Integer orderId);

    List<Order> getAllOrders();

    void deleteOrderById(Integer orderId);
}
