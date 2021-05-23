package com.alore.bookhotel;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class BookhotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookhotelApplication.class, args);
	}

	@Bean(name = "modelMapper")
	@Scope("prototype")
	ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
