package com.com.springMQproducer.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerRabbitConfiguration {

	@Value("${spring.rabbitmq.routing-key.producer}")
	private String queue;

	@Value("${spring.rabbitmq.exchenge.producer}")
	private String exchange;

	@Value("${spring.rabbitmq.deadletter.producer}")
	private String deadLetter;

	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(exchange);
	}

	@Bean
	public Queue deadLetter() {
		return new Queue(deadLetter);
	}

	@Bean
	public Queue queue() {
		Map<String, Object> args = new HashMap<>();
		args.put("x-dead-letter-exchange", exchange);
		args.put("x-dead-letter-routing-key", deadLetter);
		return new Queue(queue, false, false, false, args);
	}

	@Bean
	public Binding bindingQueue() {
		return BindingBuilder.bind(queue()).to(directExchange()).with(queue);
	}

	@Bean
	public Binding bindingDeadLetter() {
		return BindingBuilder.bind(deadLetter()).to(directExchange()).with(deadLetter);
	}

}
