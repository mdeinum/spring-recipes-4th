package com.apress.springrecipes.post.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.apress.springrecipes.post.FrontDeskImpl;
import com.apress.springrecipes.post.Mail;

/**
 * Created by marten on 03-06-14.
 */
@Configuration
public class FrontOfficeConfiguration {


    @Bean
    public KafkaTemplate<Integer, Mail> kafkaTemplate() {
        KafkaTemplate<Integer, Mail> kafkaTemplate = new KafkaTemplate<>(producerFactory());
        kafkaTemplate.setDefaultTopic("mails");
        return kafkaTemplate;
    }

    @Bean
    public ProducerFactory<Integer, Mail> producerFactory() {
        DefaultKafkaProducerFactory factory = new DefaultKafkaProducerFactory<>(producerFactoryProperties());
        factory.setValueSerializer(new JsonSerializer());
        return factory;
    }

    @Bean
    public Map<String, Object> producerFactoryProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
        return properties;
    }

    @Bean
    public FrontDeskImpl frontDesk() {
        return new FrontDeskImpl(kafkaTemplate());
    }

}
