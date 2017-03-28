package com.apress.springrecipes.post;

import com.apress.springrecipes.post.config.BackOfficeConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BackOfficeMain {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(BackOfficeConfiguration.class);
    }
}
