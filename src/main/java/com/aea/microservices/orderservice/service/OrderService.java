package com.aea.microservices.orderservice.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aea.microservices.orderservice.config.MessageConfig;
import com.aea.microservices.orderservice.model.Order;
import com.aea.microservices.orderservice.proxy.OrderDetailsProxy;

@Service
public class OrderService
{
	
	private static Logger LOG = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderDetailsProxy orderDetailsProxy;
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
	
	public Order fetchOrder(final String username, final String productId, final int quantity)
	{
		final Order order = new Order();
		order.setOrderId(UUID.randomUUID().toString());
		order.setUsername(username);
		order.setQuantity(quantity);
		
		order.setOrderDetails(orderDetailsProxy.getOrderDetails(productId));	
		
		LOG.info("Pushing order to Queue => {}", order);
		
		rabbitTemplate.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, order);
		
		return order;
	}
}
