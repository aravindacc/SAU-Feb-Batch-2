package org.example.Services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaConsumerService {

    // Creating 2 events for producer and consumer
    @KafkaListener(topics = "placeorder")
    public void consumeCreatedOrder(String order) {
        log.info("Consumer Consumed Placed Order = {}", order);
    }

    @KafkaListener(topics = "deliverorder")
    public void consumeShippedOrder(String order) {
        log.info("Consumer Consumed Delivered Order = {}", order);
    }
}