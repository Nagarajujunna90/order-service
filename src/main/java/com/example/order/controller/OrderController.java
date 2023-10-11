package com.example.order.controller;

import com.example.order.dto.OrderRequest;
import com.example.order.model.Order;
import com.example.order.service.OrderService;
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
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
        String order = orderService.createOrder(orderRequest);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @PutMapping("/order/{orderId}")
    public ResponseEntity<?> updateOrder(@RequestBody Order orderRequest, @PathVariable("id") Integer orderId) {
        Order order = orderService.updateOrder(orderRequest,orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getOrderById( @PathVariable("orderId") Integer orderId) {
        Order order = orderService.getOrderById(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<?> > getAllOrders( ) {
        List<Order> orderList = orderService.getAllOrders();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<?> deleteOrderById( @PathVariable("id") Integer orderId) {
        orderService.deleteOrderById(orderId);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }
}
