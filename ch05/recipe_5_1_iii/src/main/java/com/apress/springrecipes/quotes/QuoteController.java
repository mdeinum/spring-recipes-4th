package com.apress.springrecipes.quotes;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
@RequestMapping("/")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = new DelayingQuoteService(quoteService);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public DeferredResult<List<Quote>> getAllQuotes() {
        DeferredResult<List<Quote>> result = new DeferredResult<>();
        CompletableFuture.runAsync(() -> result.setResult(quoteService.getAllQuotes()));
        return result;
    }

    @GetMapping(value = "/random", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public CompletableFuture<Quote> randomQuote() {
        return CompletableFuture.supplyAsync(() -> quoteService.getRandomQuote());
    }

    @GetMapping(value = "/random", produces = TEXT_HTML_VALUE)
    public CompletableFuture<String> randomQuote(Model model) {
        return CompletableFuture.supplyAsync(() -> {
            model.addAttribute("quote", quoteService.getRandomQuote());
            return "quote";
        });
    }

    @GetMapping(produces = TEXT_HTML_VALUE)
    public CompletableFuture<String> getAllQuotes(Model model) {
        return CompletableFuture.supplyAsync(() -> {
            model.addAttribute("quotes", quoteService.getAllQuotes());
            return "quotes";
        });
    }
}
