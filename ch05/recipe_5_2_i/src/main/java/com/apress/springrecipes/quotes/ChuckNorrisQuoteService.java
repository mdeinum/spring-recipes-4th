package com.apress.springrecipes.quotes;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

class ChuckNorrisQuoteService implements QuoteService {

    private static final String BASE_URL = "http://api.icndb.com/jokes";
    private final RestTemplate restTemplate;

    ChuckNorrisQuoteService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Flux<Quote> getAllQuotes() {
        MultiQuoteResponse response = restTemplate.getForObject(BASE_URL, MultiQuoteResponse.class);
        return Flux.fromIterable(response.getValue());
    }

    @Override
    public Mono<Quote> getRandomQuote() {
        SingleQuoteResponse response = restTemplate.getForObject(BASE_URL + "/random", SingleQuoteResponse.class);
        return Mono.fromSupplier(() -> response.getValue());
    }

    public static class MultiQuoteResponse {

        private String type;
        private List<Quote> value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Quote> getValue() {
            return value;
        }

        public void setValue(List<Quote> value) {
            this.value = value;
        }
    }

    public static class SingleQuoteResponse {

        private String type;
        private Quote value;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Quote getValue() {
            return value;
        }

        public void setValue(Quote value) {
            this.value = value;
        }
    }
}
