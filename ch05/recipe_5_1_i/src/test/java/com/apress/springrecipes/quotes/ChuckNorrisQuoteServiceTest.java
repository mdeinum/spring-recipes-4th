package com.apress.springrecipes.quotes;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

/**
 * Created by marten on 30-05-17.
 */
public class ChuckNorrisQuoteServiceTest {

    private ChuckNorrisQuoteService service = new ChuckNorrisQuoteService(new RestTemplate());

    @Test
    public void shouldGetSingelRandomQuote() throws Exception {

        Quote quote = service.getRandomQuote();
        assertNotNull(quote);
    }

}