package com.apress.springrecipes.quotes;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QuoteService {

    Flux<Quote> getAllQuotes();

    Mono<Quote> getRandomQuote();

}
