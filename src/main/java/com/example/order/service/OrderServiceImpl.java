package com.example.order.service;

import com.example.order.dto.OrderRequest;
import com.example.order.model.Order;
import com.example.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private final OrderRepo orderRepo;

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Value("${spring.kafka.topics.create-order}")
    String createOrder;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public String createOrder(OrderRequest orderRequest) {
        Order order = new Order(orderRequest);
        Order responseOrder = orderRepo.save(order);
        kafkaTemplate.send(createOrder, responseOrder);
        return "Order created successfully";
    }

    @Override
    public Order updateOrder(Order orderRequest, Integer orderId) {
        orderRequest.setId(orderId);
        return orderRepo.save(orderRequest);

    }

    @Override
    public Order getOrderById(Integer orderId) {
        return orderRepo.findById(orderId).orElse(null);

    }

    @Override
    public List<Order> getAllOrders() {
        return (List<Order>) orderRepo.findAll().iterator();
    }

    @Override
    public void deleteOrderById(Integer orderId) {

    }
}
