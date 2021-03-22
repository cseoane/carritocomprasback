package com.example.carritocomprasback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.carritocomprasback.configuration.SwaggerConfiguration;

@SpringBootApplication()
@EnableAsync
@Import(SwaggerConfiguration.class)
public class CarritocomprasbackApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CarritocomprasbackApplication.class, args);
	}


}
