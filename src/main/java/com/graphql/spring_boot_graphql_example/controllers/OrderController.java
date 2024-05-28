package com.graphql.spring_boot_graphql_example.controllers;

import com.graphql.spring_boot_graphql_example.entities.Order;
import com.graphql.spring_boot_graphql_example.services.OrderService;
import com.graphql.spring_boot_graphql_example.services.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @MutationMapping
    public Order createOrder(@Argument OrderInput order) {
        Order o = new Order();

        o.setOrderDetail(order.getOrderDetail());
        o.setAddress(order.getAddress());
        o.setPrice(order.getPrice());
        o.setUser(userService.getUser(order.getUserId()));

        return orderService.createOrder(o);
    }

    @QueryMapping(name = "getOrders")
    public List<Order> getAllOrders() {
        return this.orderService.getAllOrders();
    }

    @QueryMapping
    public Order getOrder(@Argument int orderId) {
        return this.orderService.getOrder(orderId);
    }

    @SchemaMapping(typeName = "Mutation", field = "deleteOrder")
    public Boolean delete(@Argument int orderId) {
        return this.orderService.deleteOrder(orderId);
    }
}

@Getter
@Setter
class OrderInput {
    private String orderDetail;
    private String address;
    private int price;
    private int userId;
}
