package com.apress.springrecipes.springintegration;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(IntegrationConfiguration.class);

        System.out.println("Press [Enter] to stop...");
        System.in.read();

        applicationContext.close();

    }
}
