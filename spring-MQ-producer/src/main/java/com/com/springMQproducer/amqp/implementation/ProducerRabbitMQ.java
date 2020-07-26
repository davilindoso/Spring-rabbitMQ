package com.com.springMQproducer.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.com.springMQproducer.amqp.AmqpProducer;

@Component
public class ProducerRabbitMQ<T> implements AmqpProducer<T> {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${spring.rabbitmq.routing-key.producer}")
	private String queue;

	@Value("${spring.rabbitmq.exchenge.producer}")
	private String exchange;

	@Override
	public void producer(T message) {
		try {
			rabbitTemplate.convertAndSend(exchange, queue, message);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}

}
