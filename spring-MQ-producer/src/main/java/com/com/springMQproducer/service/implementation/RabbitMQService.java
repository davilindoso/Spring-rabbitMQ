package com.com.springMQproducer.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.com.springMQproducer.amqp.AmqpProducer;
import com.com.springMQproducer.dto.Message;
import com.com.springMQproducer.service.AmqpService;

@Service
public class RabbitMQService implements AmqpService {

	@Autowired
	private AmqpProducer<Message> amqp;

	@Override
	public void sendToConsumer(Message message) {
		amqp.producer(message);
	}
}
