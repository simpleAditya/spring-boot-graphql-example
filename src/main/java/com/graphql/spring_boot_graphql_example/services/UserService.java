package com.graphql.spring_boot_graphql_example.services;

import com.graphql.spring_boot_graphql_example.entities.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAllUser();
    User getUser(int userId);
    Boolean deleteUser(int userId);
}
