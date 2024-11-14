package com.ironhack.femsa.lab07.config;


/**
 * The type Config singleton.
 */
public class ConfigSingleton {
    private static ConfigSingleton instance;
    private String storeName;


    private ConfigSingleton() {
        storeName = "Ironhack Store";
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static synchronized ConfigSingleton getInstance() {
        if (instance == null) {
            instance = new ConfigSingleton();
        }
        return instance;
    }

    /**
     * Gets store name.
     *
     * @return the store name
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Sets store name.
     *
     * @param storeName the store name
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

}
