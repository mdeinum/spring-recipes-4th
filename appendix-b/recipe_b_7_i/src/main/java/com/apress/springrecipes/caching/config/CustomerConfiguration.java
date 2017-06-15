package com.apress.springrecipes.caching.config;

import com.apress.springrecipes.caching.Customer;
import com.apress.springrecipes.caching.CustomerRepository;
import com.apress.springrecipes.caching.MapBasedCustomerRepository;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
@EnableCaching
public class CustomerConfiguration {

    @Bean
    public RedisCacheManager cacheManager(RedisOperations<Long, Customer> template) {
        return new RedisCacheManager(template);
    }

    @Bean
    public RedisTemplate<Long, Customer> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Long, Customer> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    public CustomerRepository customerRepository() {
        return new MapBasedCustomerRepository();
    }

}
