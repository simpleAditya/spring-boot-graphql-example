package com.graphql.spring_boot_graphql_example.services.impl;

import com.graphql.spring_boot_graphql_example.entities.Order;
import com.graphql.spring_boot_graphql_example.repositories.OrderRepo;
import com.graphql.spring_boot_graphql_example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Order getOrder(int orderId) {
        return orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found !"));
    }

    @Override
    public Boolean deleteOrder(int orderId) {
        orderRepo.delete(getOrder(orderId));
        return true;
    }
}
