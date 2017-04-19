package com.apress.springrecipes.springintegration;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(IntegrationConfiguration.class);
        System.out.println("Press [Enter] to close.");
        System.in.read();
        applicationContext.close();
    }
}
