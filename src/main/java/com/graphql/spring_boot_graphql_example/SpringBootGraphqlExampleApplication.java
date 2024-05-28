package com.graphql.spring_boot_graphql_example;

import com.graphql.spring_boot_graphql_example.entities.User;
import com.graphql.spring_boot_graphql_example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootGraphqlExampleApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphqlExampleApplication.class, args);
	}

	@Override
	public void run(String... args) {

		User u1 = new User();
		u1.setName("Aditya");
		u1.setEmail("aditya@gmail.com");
		u1.setPhone("12345");
		u1.setPassword("12345");

		User u2 = new User();
		u2.setName("Ashish");
		u2.setEmail("ashish@gmail.com");
		u2.setPhone("54321");
		u2.setPassword("54321");


		User u3 = new User();
		u3.setName("Umang");
		u3.setEmail("umang@gmail.com");
		u3.setPhone("13579");
		u3.setPassword("97531");

		this.userService.createUser(u1);
		this.userService.createUser(u2);
		this.userService.createUser(u3);
	}
}
