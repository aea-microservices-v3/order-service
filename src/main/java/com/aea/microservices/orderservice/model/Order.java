package com.aea.microservices.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order
{
	private String orderId;
	private String username;
	private OrderDetails orderDetails;
	private int quantity;
}
