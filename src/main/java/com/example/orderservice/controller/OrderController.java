package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order/v1")
public class OrderController {
    @Autowired
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order orderRequest) {
        Order order = orderService.createOrder(orderRequest);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @PutMapping("/order/{orderId}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order orderRequest, @PathVariable("id") Integer orderId) {
        Order order = orderService.updateOrder(orderRequest,orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Order> getOrderById( @PathVariable("id") Integer orderId) {
        Order order = orderService.getOrderById(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order> > getAllOrders( ) {
        List<Order> orderList = orderService.getAllOrders();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<String> deleteOrderById( @PathVariable("id") Integer orderId) {
        orderService.deleteOrderById(orderId);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
