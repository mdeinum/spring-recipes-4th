package com.apress.springrecipes.quotes;

import java.util.List;
import java.util.Random;

class DelayingQuoteService implements QuoteService {

    private final Random rnd = new Random();
    private final QuoteService delegate;

    DelayingQuoteService(QuoteService delegate) {
        this.delegate = delegate;
    }

    @Override
    public List<Quote> getAllQuotes() {
        this.randomDelay();
        return delegate.getAllQuotes();
    }

    @Override
    public Quote getRandomQuote() {
        this.randomDelay();
        return delegate.getRandomQuote();
    }

    private void randomDelay() {
        int delay = rnd.nextInt(5500);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        }
    }
}
