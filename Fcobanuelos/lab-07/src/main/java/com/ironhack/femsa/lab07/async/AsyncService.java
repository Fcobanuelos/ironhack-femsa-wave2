package com.ironhack.femsa.lab07.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * The type Async service.
 */
@Service
@Slf4j
public class AsyncService {

    /**
     * Update inventory.
     */
    @Async
    public void updateInventory() {
        try {
            log.info("Actualizando inventario");
            Thread.sleep(5000);
            log.info("Inventario actualizado");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Error al actualizar el inventario: " + e.getMessage());
        }


    }
}
