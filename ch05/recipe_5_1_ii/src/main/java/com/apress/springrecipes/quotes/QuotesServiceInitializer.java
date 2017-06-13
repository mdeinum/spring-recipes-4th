package com.apress.springrecipes.quotes;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class QuotesServiceInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { QuoteServiceConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
