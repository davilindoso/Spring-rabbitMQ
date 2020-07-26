package com.com.springMQproducer.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.springMQproducer.amqp.AmqpProducer;
import com.com.springMQproducer.service.AmqpService;

@Service
public class RabbitMQService<T> implements AmqpService<T> {

	@Autowired
	private AmqpProducer<T> amqp;

	@Override
	public void sendToConsumer(T message) {
		amqp.producer(message);
	}
}
