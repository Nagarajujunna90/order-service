package com.example.orderservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@OpenAPIDefinition(info = @Info(title = "order-service"))
@SpringBootApplication
@RestController
//@EnableEurekaClient
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}


	@RequestMapping(value = "/recommended")
	public Mono<String> readingList(){
		return Mono.just("Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)");
	}

}
