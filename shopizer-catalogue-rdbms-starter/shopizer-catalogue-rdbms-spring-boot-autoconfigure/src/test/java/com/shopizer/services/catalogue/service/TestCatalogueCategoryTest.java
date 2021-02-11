package com.shopizer.services.catalogue.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.shopizer.services.catalogue.autoconfigure.TestCatalogueAutoConfiguration;
import com.shopizer.services.catalogue.facade.TestCategoryCatalogueFacade;

@SpringBootTest
@RunWith(org.springframework.test.context.junit4.SpringRunner.class)
@ContextConfiguration(classes = TestCatalogueAutoConfiguration.class)
//@Ignore
public class TestCatalogueCategoryTest {
	
	@Autowired
	private TestCategoryCatalogueFacade testCatalogueCategoryFacade;




	/**
	 * Rigourous Test :-)
	 * @throws IntegrationException 
	 */
	@Test
	public void testCategory() throws Exception {
		assertTrue(true);
		
		//with test environment
		
		//init
		
		//payment
		
		//refund



	}

}
