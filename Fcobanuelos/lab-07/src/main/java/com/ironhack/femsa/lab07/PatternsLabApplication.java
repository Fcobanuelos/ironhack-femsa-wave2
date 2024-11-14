package com.ironhack.femsa.lab07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * The type Patterns lab application.
 */
@SpringBootApplication
@EnableAsync
public class PatternsLabApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(PatternsLabApplication.class, args);
	}

}
