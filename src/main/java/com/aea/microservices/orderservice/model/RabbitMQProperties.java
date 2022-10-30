package com.aea.microservices.orderservice.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RabbitMQProperties 
{
	private int port;
	private String host;
	private String username;
	private String password;
}
