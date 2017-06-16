package com.apress.springrecipes.springbatch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

/**
 * This class writes the user registration by calling an RPC service (whose client interface is wired in using Spring
 */
public class UserRegistrationServiceItemWriter implements ItemWriter<UserRegistration> {
    private static final Logger logger = LoggerFactory.getLogger(UserRegistrationServiceItemWriter.class);

    // this is the client interface to an HTTP Invoker service.
    private final UserRegistrationService userRegistrationService;

    public UserRegistrationServiceItemWriter(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    /**
     * takes aggregated input from the reader and 'writes' them using a custom implementation.
     */
    public void write(List<?extends UserRegistration> items)
        throws Exception {
        for (final UserRegistration userRegistrationRegistration : items) {
            UserRegistration registeredUserRegistration = userRegistrationService.registerUser(
                    userRegistrationRegistration);
            logger.debug("Registered: {}", registeredUserRegistration);
        }
    }
}
