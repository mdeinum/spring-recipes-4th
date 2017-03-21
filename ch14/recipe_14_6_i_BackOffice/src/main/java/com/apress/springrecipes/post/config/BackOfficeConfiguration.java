package com.apress.springrecipes.post.config;

import com.apress.springrecipes.post.BackOffice;
import com.apress.springrecipes.post.BackOfficeImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by marten on 02-06-14.
 */
@Configuration
public class BackOfficeConfiguration {

    @Bean
    public BackOffice backOffice() {
        return new BackOfficeImpl();
    }

}
