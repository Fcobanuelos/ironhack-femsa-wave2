package com.ironhack.femsa.lab07.factory;

import lombok.extern.slf4j.Slf4j;

/**
 * The type Clothing product.
 */
@Slf4j
public class ClothingProduct implements Product {
    @Override
    public void displayInfo() {
        log.info("Producto de ropa");
    }
}
