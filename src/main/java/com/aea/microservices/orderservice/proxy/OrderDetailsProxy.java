package com.aea.microservices.orderservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.aea.microservices.orderservice.model.OrderDetails;

@FeignClient(name="order-details-processor")
public interface OrderDetailsProxy
{
	
	@GetMapping("/order-details/{productId}")
	public OrderDetails getOrderDetails(@PathVariable final String productId);

}
