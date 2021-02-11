package com.shopizer.services.catalogue.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.salesmanager.core.model.catalog.category.Category;
import com.salesmanager.core.model.catalog.product.Product;
import com.salesmanager.core.model.catalog.product.ProductCriteria;
import com.salesmanager.core.model.catalog.product.review.ProductReview;
import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.reference.language.Language;
import com.salesmanager.shop.model.catalog.product.LightPersistableProduct;
import com.salesmanager.shop.model.catalog.product.PersistableProduct;
import com.salesmanager.shop.model.catalog.product.PersistableProductReview;
import com.salesmanager.shop.model.catalog.product.ProductPriceEntity;
import com.salesmanager.shop.model.catalog.product.ProductPriceRequest;
import com.salesmanager.shop.model.catalog.product.ReadableProduct;
import com.salesmanager.shop.model.catalog.product.ReadableProductList;
import com.salesmanager.shop.model.catalog.product.ReadableProductPrice;
import com.salesmanager.shop.model.catalog.product.ReadableProductReview;
import com.salesmanager.shop.store.controller.product.facade.ProductFacade;
import com.shopizer.services.catalogue.services.ProductService;

@Component("testCatalogueProductFacade")
public class TestProductCatalogueFacade implements ProductFacade {
	
	@Autowired
	private ProductService productService;

	@Override
	public PersistableProduct saveProduct(MerchantStore store, PersistableProduct product, Language language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Long productId, LightPersistableProduct product, MerchantStore merchant, Language language) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Get product by id
	 */
	@Override
	public ReadableProduct getProduct(MerchantStore store, Long id, Language language) throws Exception {
		// TODO Auto-generated method stub
		
		//query the database
		
		//populate the product
		ReadableProduct readable = new ReadableProduct();
		
		return readable;
	}

	@Override
	public Product getProduct(String sku, MerchantStore store) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadableProduct getProductByCode(MerchantStore store, String uniqueCode, Language language)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadableProduct getProduct(MerchantStore store, String sku, Language language) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get product by search engine url
	 */
	@Override
	public ReadableProduct getProductBySeUrl(MerchantStore store, String friendlyUrl, Language language)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadableProduct updateProductPrice(ReadableProduct product, ProductPriceEntity price, Language language)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadableProduct updateProductQuantity(ReadableProduct product, int quantity, Language language)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(Long id, MerchantStore store) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * List products
	 */
	@Override
	public ReadableProductList getProductListsByCriterias(MerchantStore store, Language language,
			ProductCriteria criterias) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadableProduct addProductToCategory(Category category, Product product, Language language)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadableProduct removeProductFromCategory(Category category, Product product, Language language)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdateReview(PersistableProductReview review, MerchantStore store, Language language)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReview(ProductReview review, MerchantStore store, Language language) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReadableProductReview> getProductReviews(Product product, MerchantStore store, Language language)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String sku, MerchantStore store) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ReadableProduct> relatedItems(MerchantStore store, Product product, Language language)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadableProductPrice getProductPrice(Long id, ProductPriceRequest priceRequest, MerchantStore store,
			Language language) {
		// TODO Auto-generated method stub
		return null;
	}

}
