package com.apress.springrecipes.post;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class MailListener {

    public void displayMail(Mail mail) {
        System.out.println("Received: " + mail);
    }
}
