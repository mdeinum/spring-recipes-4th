package com.apress.springrecipes.post;

import com.apress.springrecipes.post.config.BackOfficeConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BackOfficeMain {

    public static void main(String[] args) throws Exception {
            ApplicationContext context =
                    new AnnotationConfigApplicationContext(BackOfficeConfiguration.class);

            BackOffice backOffice = context.getBean(BackOffice.class);
            backOffice.receiveMail();

            System.in.read();
    }
}
