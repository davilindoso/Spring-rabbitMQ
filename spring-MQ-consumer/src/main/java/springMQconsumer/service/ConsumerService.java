package springMQconsumer.service;

import springMQconsumer.dto.Message;

public interface ConsumerService {
	void action(Message message) throws Exception;
}
