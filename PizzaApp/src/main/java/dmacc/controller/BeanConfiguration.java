package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Pizza;
import dmacc.beans.Toppings;



@Configuration
public class BeanConfiguration {
	
	@Bean
	Pizza pizza() {
		Pizza bean = new Pizza();
		return bean;
	}

    @Bean
    Toppings toppings() {
		Toppings bean = new Toppings();
		return bean;
	}
}
