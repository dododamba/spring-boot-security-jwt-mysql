package com.dominiquedamba.baseapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.dominiquedamba.baseapp.config.FileStorageConfig;

import javax.annotation.PostConstruct;
import java.util.TimeZone;
 
/**
 * The main class 
 * 
 * @author DOMINIQUE DAMBA 
 * @version 1.0.0 
 * @since 2020 {@link http://bit.ly/dominic-linked-in }
 *
 */

@SpringBootApplication
@EntityScan(basePackageClasses = { BaseAppApplication.class, Jsr310JpaConverters.class })
@EnableConfigurationProperties({ FileStorageConfig.class })
public class BaseAppApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(BaseAppApplication.class, args);
	}
}
