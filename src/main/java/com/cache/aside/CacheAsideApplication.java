package com.cache.aside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CacheAsideApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheAsideApplication.class, args);
	}

}
