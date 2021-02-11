package com.shopizer.services.catalogue.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.reference.language.Language;
import com.salesmanager.shop.model.catalog.product.ReadableProduct;
import com.shopizer.services.catalogue.autoconfigure.TestCatalogueAutoConfiguration;
import com.shopizer.services.catalogue.facade.TestProductCatalogueFacade;

@SpringBootTest
@RunWith(org.springframework.test.context.junit4.SpringRunner.class)
@ContextConfiguration(classes = TestCatalogueAutoConfiguration.class)
//@Ignore
public class TestProductCatalogueServiceTest {
	
	@Autowired
	private TestProductCatalogueFacade testCatalogueProductFacade;





	/**
	 * Rigourous Test :-)
	 * @throws IntegrationException 
	 */
	@Test
	public void tesGetProduct() throws Exception {


		
		ReadableProduct product = testCatalogueProductFacade.getProduct(defaultStore(), 1L, defaultLaguage());
		assertTrue(product != null);




	}
	
	private MerchantStore defaultStore() {
		MerchantStore store = new MerchantStore();
		store.setId(1);
		store.setCode("DEFAULT");
		return store;
	}
	
	private Language defaultLaguage() {
		Language lang = new Language();
		lang.setCode("en");
		lang.setId(1);
		return lang;
	}

}
