package com.apress.springrecipes.post;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.support.JmsUtils;


public class MailListener {

    @JmsListener(destination = "mail.queue")
    public void displayMail(Mail mail) {
        System.out.println("Mail #" + mail.getMailId() + " received");
    }
}
