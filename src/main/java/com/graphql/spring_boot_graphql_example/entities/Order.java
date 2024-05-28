package com.graphql.spring_boot_graphql_example.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String orderDetail;
    private String address;
    private int price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
