package com.com.springMQproducer.service;

public interface AmqpService<T> {

	void sendToConsumer(T message);
	

}
