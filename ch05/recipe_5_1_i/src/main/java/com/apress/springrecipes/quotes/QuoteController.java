package com.apress.springrecipes.quotes;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_HTML_VALUE;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class QuoteController {

    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = new DelayingQuoteService(quoteService);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }

    @GetMapping(value = "/random", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Quote randomQuote() {
        return quoteService.getRandomQuote();
    }

    @GetMapping(value = "/random", produces = TEXT_HTML_VALUE)
    public String randomQuote(Model model) {
        model.addAttribute("quote", this.randomQuote());
        return "quote";
    }

    @GetMapping(produces = TEXT_HTML_VALUE)
    public String getAllQuotes(Model model) {
        model.addAttribute("quotes", this.getAllQuotes());
        return "quotes";
    }
}
