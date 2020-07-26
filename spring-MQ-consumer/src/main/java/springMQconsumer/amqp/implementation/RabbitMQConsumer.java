package springMQconsumer.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springMQconsumer.amqp.AmqpConsumer;
import springMQconsumer.dto.Message;
import springMQconsumer.service.ConsumerService;

@Component
public class RabbitMQConsumer implements AmqpConsumer<Message> {

	@Autowired
	private ConsumerService consumerService;

	@Override
	@RabbitListener(queues = "$spring.rabbitmq.routing-key.producer")
	public void consumer(Message message) {
		try {
			consumerService.action(message);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}

}
