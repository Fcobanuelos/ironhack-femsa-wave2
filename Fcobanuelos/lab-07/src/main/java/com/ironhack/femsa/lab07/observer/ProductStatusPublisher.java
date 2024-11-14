package com.ironhack.femsa.lab07.observer;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * The type Product status publisher.
 */
@Component
public class ProductStatusPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    /**
     * Instantiates a new Product status publisher.
     *
     * @param applicationEventPublisher the application event publisher
     */
    public ProductStatusPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    /**
     * Publish status change.
     *
     * @param status the status
     */
    public void publishStatusChange(String status) {
        ProductStatusChangeEvent event = new ProductStatusChangeEvent(this, status);
        applicationEventPublisher.publishEvent(event);
    }
}
