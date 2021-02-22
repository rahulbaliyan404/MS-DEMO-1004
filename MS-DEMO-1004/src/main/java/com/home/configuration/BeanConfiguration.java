package com.home.configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.home.utils.DbConnection;

@Configuration
public class BeanConfiguration {
	private static final Logger LOGGER = LoggerFactory.getLogger(BeanConfiguration.class);
	
	@Bean
	public DbConnection dbConection() {
		LOGGER.info("DbConnection bean configuration.");
		return new DbConnection();
	}
}
