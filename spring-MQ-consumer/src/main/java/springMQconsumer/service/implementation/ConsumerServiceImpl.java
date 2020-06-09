package springMQconsumer.service.implementation;

import org.springframework.stereotype.Service;

import springMQconsumer.dto.Message;
import springMQconsumer.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Override
	public void action(Message message) throws Exception {
		System.out.println(message.getText());
	}

}
