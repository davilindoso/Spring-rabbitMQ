package com.com.springMQproducer.amqp;

public interface AmqpProducer<T> {
	void producer(T t);
}
