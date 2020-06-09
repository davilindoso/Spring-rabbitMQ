package com.com.springMQproducer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.com.springMQproducer.dto.Message;
import com.com.springMQproducer.service.AmqpService;

@RestController
public class AmqpApi {

	@Autowired
	private AmqpService amqpService;

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/send")
	public void sendToConsumer(@RequestBody Message message) {
		amqpService.sendToConsumer(message);
	}

}
