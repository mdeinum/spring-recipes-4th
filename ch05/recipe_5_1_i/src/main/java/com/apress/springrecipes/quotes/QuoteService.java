package com.apress.springrecipes.quotes;

import java.util.List;

public interface QuoteService {

    List<Quote> getAllQuotes();

    Quote getRandomQuote();

}
