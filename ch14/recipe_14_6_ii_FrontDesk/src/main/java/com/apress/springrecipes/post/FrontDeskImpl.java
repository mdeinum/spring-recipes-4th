package com.apress.springrecipes.post;

import org.springframework.amqp.rabbit.core.RabbitGatewaySupport;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Locale;
import java.util.Random;

public class FrontDeskImpl extends RabbitGatewaySupport implements FrontDesk {

    public void sendMail(final Mail mail) {
        getRabbitOperations().convertAndSend(mail);
    }

    @Scheduled(initialDelay = 175, fixedDelay = 225)
    public void sendMailTrigger() {
        Random rnd = new Random();
        int countries = Locale.getISOCountries().length;
        String country = Locale.getISOCountries()[rnd.nextInt(countries)];

        sendMail(new Mail(String.valueOf(System.currentTimeMillis()), country, rnd.nextDouble()));
    }
}
