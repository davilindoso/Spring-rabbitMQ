package com.com.springMQproducer.service;

import com.com.springMQproducer.dto.Message;

public interface AmqpService {

	void sendToConsumer(Message message);

}
