package com.apress.springrecipes.post;

import org.springframework.jms.annotation.JmsListener;

import java.util.Map;

public class MailListener {

    @JmsListener(destination = "mail.queue")
    public void displayMail(Map map) {
        Mail mail = new Mail();
        mail.setMailId((String) map.get("mailId"));
        mail.setCountry((String) map.get("country"));
        mail.setWeight((Double) map.get("weight"));
        System.out.println("Mail #" + mail.getMailId() + " received");
    }
}
