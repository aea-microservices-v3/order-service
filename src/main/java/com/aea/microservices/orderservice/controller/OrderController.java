package com.aea.microservices.orderservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aea.microservices.orderservice.model.Order;
import com.aea.microservices.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController
{
	private static Logger LOG = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("")
	public Order getOrder(@RequestParam final String username, @RequestParam final String productId, @RequestParam final int quantity)
	{
		LOG.info("Create and fetch order : username -> {}, productId -> {}, quantity -> {}", username, productId, quantity);
		return orderService.fetchOrder(username, productId, quantity);
	}
}
