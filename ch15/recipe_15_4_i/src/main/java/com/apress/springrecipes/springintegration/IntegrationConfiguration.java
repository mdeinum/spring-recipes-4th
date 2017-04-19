package com.apress.springrecipes.springintegration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.file.dsl.Files;

import java.io.File;

@Configuration
@EnableIntegration
@ComponentScan
public class IntegrationConfiguration {


    @Bean
    public InboundHelloWorldFileMessageProcessor messageProcessor() {
        return new InboundHelloWorldFileMessageProcessor();
    }

    @Bean
    public IntegrationFlow inboundFileFlow(@Value("${user.home}/inboundFiles/new/") File directory) {
        return IntegrationFlows
                .from(Files.inboundAdapter(directory).regexFilter("^new.*csv").useWatchService(true))
                .handle(messageProcessor())
                .get();
    }
}
