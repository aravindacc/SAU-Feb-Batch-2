package com.example.kafka.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.kafka.model.Order;

@RestController
@RequestMapping("kafka")
public class UserController 
{	
	@Autowired
	private KafkaTemplate<String, Order> temp;
	private static final String TOPIC="TestTopic";
	
	@PostMapping("/publish/{id}/{qty}/{type}")
	public String messageToTopic(@PathVariable("id") final int id,@PathVariable("qty") final int qty,@PathVariable("type") final String type) 
	{
		temp.send(TOPIC,new Order(id,qty,type,new Date().toString()));
		return "publiched successfully";
	}
}