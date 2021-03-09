package org.example.Services;



import org.example.Models.KafkaOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j

public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, String> createOrShipKafkaTemplate;

    public void createOrder(KafkaOrder order) {
        String topicName = "placeorder";
        createOrShipKafkaTemplate.send(topicName, order.toString());
        log.info("Kafka Order Produced(Created) by Producer, msg = {}", order.toString());
    }

    public void shipOrder(KafkaOrder order) {
        String topicName = "deliverorder";
        createOrShipKafkaTemplate.send(topicName, order.toString());
        log.info("#Kafka Order Shipped by Producer , msg = {}", order.toString());
    }
}