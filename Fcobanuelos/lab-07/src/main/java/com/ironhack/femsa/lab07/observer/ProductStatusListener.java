package com.ironhack.femsa.lab07.observer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The type Product status listener.
 */
@Component
@Slf4j
public class ProductStatusListener {

    /**
     * On product status change.
     *
     * @param event the event
     */
    public void onProductStatusChange(ProductStatusChangeEvent event) {
        log.info("Estado del producto cambiado a: " + event.getStatus());
    }

}
