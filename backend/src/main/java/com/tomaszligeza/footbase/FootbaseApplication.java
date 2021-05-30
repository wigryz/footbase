package com.tomaszligeza.footbase;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class FootbaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootbaseApplication.class, args);
	}

	@Configuration
	public class ApplicationConfig {
		@Bean
		public ModelMapper modelMapper() {
			ModelMapper modelMapper = new ModelMapper();
			return modelMapper;
		}
	}
}
