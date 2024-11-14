package com.ironhack.femsa.lab07.factory;

import org.springframework.stereotype.Component;

/**
 * The type Product factory.
 */
@Component
public class ProductFactory {

    /**
     * Create product product.
     *
     * @param type the type
     * @return the product
     */
    public Product createProduct(String type) {
            return switch (type.toLowerCase()) {
                case "electronics" -> new ElectronicsProduct();
                case "clothing" -> new ClothingProduct();
                default -> throw new IllegalArgumentException("Tipo de producto desconocido: " + type);
            };
        }
}
