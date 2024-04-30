package com.jonathan.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("Sending message: {}", message);
        kafkaTemplate.send("str-topic", message);
//                .addCallback(
//                success -> {
//                    log.info("Message {} sent with success!", message);
//                    assert success != null;
//                    log.info("Partition {}, Offset {}",
//                            success.getRecordMetadata().partition(),
//                            success.getRecordMetadata().offset());
//                },
//                error -> log.error("Error sending message")
//        );
    }
}
