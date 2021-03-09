package com.example.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.kafka.model.Order;

@Service
public class ConsumerService 
{
	@KafkaListener(topics = "TestTopic", groupId = "group_json",containerFactory = "kafkaListenerContainerFactory")
	public void consumeJson(Order order) 
	{
		System.out.println("consumed message"+order);
	}
}