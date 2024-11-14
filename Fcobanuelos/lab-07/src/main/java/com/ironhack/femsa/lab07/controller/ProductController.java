package com.ironhack.femsa.lab07.controller;


import com.ironhack.femsa.lab07.async.AsyncService;
import com.ironhack.femsa.lab07.config.ConfigSingleton;
import com.ironhack.femsa.lab07.factory.Product;
import com.ironhack.femsa.lab07.factory.ProductFactory;
import com.ironhack.femsa.lab07.observer.ProductStatusPublisher;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Product controller.
 */
@RestController
@RequestMapping("/api/v1/patterns")
public class ProductController {

    private final ProductFactory productFactory;

    private final ConfigSingleton configSingleton;

    private final ProductStatusPublisher productStatusPublisher;

    private final AsyncService asyncService;

    /**
     * Instantiates a new Product controller.
     *
     * @param productFactory         the product factory
     * @param configSingleton        the config singleton
     * @param productStatusPublisher the product status publisher
     * @param asyncService           the async service
     */
    public ProductController(ProductFactory productFactory,
                             ConfigSingleton configSingleton,
                             ProductStatusPublisher productStatusPublisher,
                             AsyncService asyncService) {
        this.productFactory = productFactory;
        this.configSingleton = configSingleton;
        this.productStatusPublisher = productStatusPublisher;
        this.asyncService = asyncService;
    }


    /**
     * Gets store config.
     *
     * @return the store config
     */
    @GetMapping("/config")
    public String getStoreConfig() {
        return "Nombre de la tienda: " + configSingleton.getStoreName();
    }

    /**
     * Create product string.
     *
     * @param productType the product type
     * @return the string
     */
    @PostMapping("/products/{productType}")
    public String createProduct(
            @PathVariable String productType) {
        Product product = productFactory.createProduct(productType);
        product.displayInfo();
        return "Producto creado" + productType;
    }

    /**
     * Change product status string.
     *
     * @param status the status
     * @return the string
     */
    @PostMapping("/products/status")
    public String changeProductStatus(
            @RequestParam String status
    ) {
        productStatusPublisher.publishStatusChange(status);
        return "Estado del producto cambiado a:" + status;
    }

    /**
     * Update inventory string.
     *
     * @return the string
     */
    @PostMapping("/inventory")
    public String updateInventory() {
        asyncService.updateInventory();
        return "Inventario actualizado";
    }
}
