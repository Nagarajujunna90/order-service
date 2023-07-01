package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order createOrder(Order orderRequest) {
        return orderRepo.save(orderRequest);
    }

    @Override
    public Order updateOrder(Order orderRequest, Integer orderId) {
        orderRequest.setId(orderId);
        return orderRepo.save(orderRequest)
                ;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderRepo.findById(orderId).orElse(null);

    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public void deleteOrderById(Integer orderId) {
        
    }
}
