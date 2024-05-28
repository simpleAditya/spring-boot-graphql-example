package com.graphql.spring_boot_graphql_example.repositories;

import com.graphql.spring_boot_graphql_example.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo  extends JpaRepository<Order, Integer> {}