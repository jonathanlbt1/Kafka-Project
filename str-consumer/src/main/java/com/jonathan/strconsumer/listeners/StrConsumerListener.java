package com.jonathan.strconsumer.listeners;

import com.jonathan.strconsumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @SneakyThrows
    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message) {
        log.info("CREATE ::: Message received: {}", message);
        throw new IllegalArgumentException("EXCEPTION...");
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message) {
        log.info("LOG ::: Message received: {}", message);
    }

    @KafkaListener(groupId = "group-2", containerFactory = "validMessageContainerFactory", topics = "str-topic")
    public void history(String message) {
        log.info("HISTORY ::: Message received: {}", message);
    }
}
