package com.example.order.service;

import com.example.order.dto.OrderRequest;
import com.example.order.model.Order;

import java.util.List;

public interface OrderService {
    String createOrder(OrderRequest orderRequest);

    Order updateOrder(Order orderRequest, Integer orderId);

    Order getOrderById(Integer orderId);

    List<Order> getAllOrders();

    void deleteOrderById(Integer orderId);
}
