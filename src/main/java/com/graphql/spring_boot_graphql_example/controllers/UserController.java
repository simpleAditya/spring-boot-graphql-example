package com.graphql.spring_boot_graphql_example.controllers;

import com.graphql.spring_boot_graphql_example.entities.Order;
import com.graphql.spring_boot_graphql_example.entities.User;
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
public class UserController {
    @Autowired
    private UserService userService;

    @MutationMapping
    public User createUser(@Argument UserInput user) {
        User u = new User();

        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPhone(user.getPhone());
        u.setPassword(user.getPassword());
        u.setOrders(user.getOrders());

        return userService.createUser(u);
    }

    @QueryMapping(name = "getUsers")
    public List<User> getAllUsers() {
        return this.userService.getAllUser();
    }

    @QueryMapping
    public User getUser(@Argument int userId) {
        return this.userService.getUser(userId);
    }

    @SchemaMapping(typeName = "Mutation", field = "deleteUser")
    public Boolean delete(@Argument int userId) {
        return this.userService.deleteUser(userId);
    }
}

@Getter
@Setter
class UserInput {
    private String name;
    private String email;
    private String phone;
    private String password;
    private List<Order> orders;
}
