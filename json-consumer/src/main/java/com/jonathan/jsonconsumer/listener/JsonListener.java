package com.jonathan.jsonconsumer.listener;

import com.jonathan.jsonconsumer.model.Payment;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class JsonListener {

    @SneakyThrows
    @KafkaListener(groupId = "create-group", topics = "payment-topic", containerFactory = "jsonContainerFactory")
    public void antiFraud(@Payload Payment payment) {
        log.info("ANTI-FRAUD ::: Message received {}", payment.toString());
        Thread.sleep(2000);

        log.info("Compra aprovada!");
        Thread.sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(groupId = "create-group", topics = "payment-topic", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) {
        log.info("GENERATING PDF ::: Message received {}", payment.getId());
        Thread.sleep(2000);

        log.info("PDF is generated!");
        Thread.sleep(3000);
    }

    @SneakyThrows
    @KafkaListener(groupId = "create-group", topics = "payment-topic", containerFactory = "jsonContainerFactory")
    public void sendEmail(@Payload Payment payment) {
        log.info("SENDING E-MAIL ::: Message received {}", payment.getCardNumber());
        Thread.sleep(2000);

        log.info("E-mail sent!");
        Thread.sleep(3000);
    }
}
