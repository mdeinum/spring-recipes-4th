package com.apress.springrecipes.springintegration;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import java.util.HashMap;
import java.util.Map;


public class ClientMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ClientConfiguration.class);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        Map<String, Object> customer = new HashMap<String, Object>();
        customer.put("id", 1234L);
        customer.put("firstName", "Marten");
        customer.put("lastName", "Deinum");

        jmsTemplate.convertAndSend("recipe-15-6", customer);

        Map<String, Object> customer2 = new HashMap<String, Object>();
        customer2.put("id", "1234L");
        customer2.put("firstName", "Marten");
        customer2.put("lastName", "Deinum");

        jmsTemplate.convertAndSend("recipe-15-6", customer2);

        context.close();

    }
}
