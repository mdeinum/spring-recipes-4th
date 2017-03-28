package com.apress.springrecipes.post;

import org.springframework.jms.core.support.JmsGatewaySupport;

import javax.jms.MapMessage;

public class FrontDeskImpl extends JmsGatewaySupport implements FrontDesk {

    public void sendMail(final Mail mail) {
	getJmsTemplate().send(session -> {
        MapMessage message = session.createMapMessage();
        message.setString("mailId", mail.getMailId());
        message.setString("country", mail.getCountry());
        message.setDouble("weight", mail.getWeight());
        return message;
    });
    }
}
