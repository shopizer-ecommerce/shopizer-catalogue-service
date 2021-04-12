package com.shopizer.services.catalogue.service;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.hibernate.cfg.beanvalidation.IntegrationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.shopizer.services.catalogue.CatalogueRDBMSSpringBootApplication;
import com.shopizer.services.catalogue.model.category.Category;
import com.shopizer.services.catalogue.services.CategoryService;


//@SpringBootTest
//@RunWith(org.springframework.test.context.junit4.SpringRunner.class)
//@ContextConfiguration(classes = CatalogueRDBMSAutoConfiguration.class)
//@Ignore


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
  classes = CatalogueRDBMSSpringBootApplication.class)
@EnableJpaRepositories(
  basePackages = { "com.shopizer.services.catalogue.repository" })
public class CatalogueCategoryTest {
  
  
    @Autowired
    private CategoryService categoryService;


	/**
	 * Rigourous Test :-)
	 * @throws IntegrationException 
	 */
	@Test
	public void testCategory() throws Exception {
	  
	  
	    Category c = new Category();
	    c.setCode("test");
	    c.setMerchantStore("DEFAULT");
	    
	    categoryService.save(c);
	    
	    List<Category> categoryList = categoryService.findAll();
	
		assertTrue(!categoryList.isEmpty());
		
		//with test environment
		
		//init
		
		//payment
		
		//refund



	}

}
