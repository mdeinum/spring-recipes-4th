package com.apress.springrecipes.post;

import com.apress.springrecipes.post.config.BackOfficeConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BackOfficeMain {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(BackOfficeConfiguration.class);
    }
}
