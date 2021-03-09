package com.example.kafka.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.example.kafka.model.Order;

@Service
public class ProducerService 
{
	@Autowired
	private KafkaTemplate<String, Order> temp;
	private static final String TOPIC="TestTopic";
	public String sendMessage(int id, int quantity, String type) 
	{
		temp.send(TOPIC,new Order(id,quantity,type,new Date().toString()));
		return "Published successfully";
	}
}