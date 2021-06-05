package com.tomaszligeza.footbase;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FootbaseApplication {
	public static void main(String[] args) {
		SpringApplication.run(FootbaseApplication.class, args);
	}

	@Configuration
	static public class ApplicationConfig {
		@Bean
		public ModelMapper modelMapper() {
			return new ModelMapper();
		}
	}



}
