package com.apress.springrecipes.websocket;

import org.springframework.web.reactive.support.AbstractAnnotationConfigDispatcherHandlerInitializer;

public class WebFluxInitializer extends AbstractAnnotationConfigDispatcherHandlerInitializer {

    @Override
    protected Class<?>[] getConfigClasses() {
        return new Class<?>[] {WebFluxConfiguration.class};
    }
}
