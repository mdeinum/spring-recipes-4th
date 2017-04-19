package com.apress.springrecipes.springintegration;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
class JmsMessageProducer {

    private final JmsTemplate jms;

    JmsMessageProducer(JmsTemplate jms) {
        this.jms = jms;
    }

    @Scheduled(fixedDelay = 50)
    public void produceMessage() {
        Map<String, Object> customer = new HashMap<>();
        customer.put("id", 1234L);
        customer.put("firstName", "Marten");
        customer.put("lastName", "Deinum");

        jms.convertAndSend("recipe-15-2", customer);


    }
}
