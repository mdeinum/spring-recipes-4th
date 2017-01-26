package com.apress.springrecipes.calculator;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

/**
 * Created by marten on 10-01-17.
 */
@Configuration
@EnableSpringConfigured
@ComponentScan
public class CalculatorConfiguration {
}
