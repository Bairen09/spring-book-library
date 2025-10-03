package com.bairen.Books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bairen.Books")
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

}