package com.apress.springrecipes.quotes;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = new DelayingQuoteService(quoteService);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Flux<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }

    @GetMapping(value = "/random", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Mono<Quote> randomQuote() {
        return quoteService.getRandomQuote();
    }

    @GetMapping(value = "/random", produces = TEXT_HTML_VALUE)
    public Mono<String> randomQuote(Model model) {
        return CompletableFuture.supplyAsync(() -> {
            model.addAttribute("quote", quoteService.getRandomQuote());
            return "quote";
        });
    }

    @GetMapping(produces = TEXT_HTML_VALUE)
    public Mono<String> getAllQuotes(Model model) {
        return CompletableFuture.supplyAsync(() -> {
            model.addAttribute("quotes", quoteService.getAllQuotes());
            return "quotes";
        });
    }
}
