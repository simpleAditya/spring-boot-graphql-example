package com.graphql.spring_boot_graphql_example.repositories;

import com.graphql.spring_boot_graphql_example.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {}