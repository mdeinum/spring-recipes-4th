package com.apress.springrecipes.court.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.apress.springrecipes.court.domain.SportTypeConverter;

/**
 * Created by marten on 07-03-17.
 */
@Configuration
public class BindingConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private SportTypeConverter sportTypeConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        System.out.println("Registring SportTypeConverter");
        registry.addConverter(sportTypeConverter);
    }

}
