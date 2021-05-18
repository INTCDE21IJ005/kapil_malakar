package com.example.demo;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringRestHandson1Application {
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(SpringRestHandson1Application.class);
	public static void main(String[] args) {
		LOGGER.info("Start");

		SpringApplication.run(SpringRestHandson1Application.class, args);
		
		displayCountry();
		
			
		LOGGER.info("End");
	
		SpringApplication.run(SpringRestHandson1Application.class, args);
	}



	


private static void displayCountry() {
	LOGGER.info("Start displayCountry");
	
	;
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("country.xml");
	
	Country country = applicationContext.getBean("country", Country.class);
	
	LOGGER.info("End");
}

}