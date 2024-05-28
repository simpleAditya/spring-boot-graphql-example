package com.graphql.spring_boot_graphql_example.services;

import com.graphql.spring_boot_graphql_example.entities.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);
    List<Order> getAllOrders();
    Order getOrder(int orderId);
    Boolean deleteOrder(int orderId);
}
