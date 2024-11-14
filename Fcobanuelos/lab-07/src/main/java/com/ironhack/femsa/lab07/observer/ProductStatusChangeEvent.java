package com.ironhack.femsa.lab07.observer;

import org.springframework.context.ApplicationEvent;

/**
 * The type Product status change event.
 */
public class ProductStatusChangeEvent extends ApplicationEvent {
    private final String status;

    /**
     * Instantiates a new Product status change event.
     *
     * @param source the source
     * @param status the status
     */
    public ProductStatusChangeEvent(Object source, String status) {
        super(source);
        this.status = status;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }
}
