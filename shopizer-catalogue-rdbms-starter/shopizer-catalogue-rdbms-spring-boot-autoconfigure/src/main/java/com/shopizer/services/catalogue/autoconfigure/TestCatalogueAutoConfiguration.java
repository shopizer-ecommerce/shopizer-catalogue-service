package com.shopizer.services.catalogue.autoconfigure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.shopizer.services.catalogue")
//@ConditionalOnClass(NuveiPaymentModule.class)
public class TestCatalogueAutoConfiguration {
	
	
	/**
	 * https://www.baeldung.com/transaction-configuration-with-jpa-and-spring
	 * 
	 * autoconfigure is the base class, it wires everything that can be used outside
	 * of this starter
	 */

}
