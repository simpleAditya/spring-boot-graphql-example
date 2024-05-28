package com.graphql.spring_boot_graphql_example.services.impl;

import com.graphql.spring_boot_graphql_example.entities.User;
import com.graphql.spring_boot_graphql_example.repositories.UserRepo;
import com.graphql.spring_boot_graphql_example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(int userId) {
        return userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found !"));
    }

    @Override
    public Boolean deleteUser(int userId) {
        userRepo.delete(getUser(userId));
        return true;
    }
}
