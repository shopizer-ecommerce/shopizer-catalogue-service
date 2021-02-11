package com.shopizer.services.catalogue.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.salesmanager.core.model.catalog.category.Category;
import com.salesmanager.core.model.merchant.MerchantStore;
import com.salesmanager.core.model.reference.language.Language;
import com.salesmanager.shop.model.catalog.category.PersistableCategory;
import com.salesmanager.shop.model.catalog.category.ReadableCategory;
import com.salesmanager.shop.model.catalog.category.ReadableCategoryList;
import com.salesmanager.shop.model.catalog.product.attribute.ReadableProductVariant;
import com.salesmanager.shop.model.entity.ListCriteria;
import com.salesmanager.shop.store.controller.category.facade.CategoryFacade;

@Component("testCatalogueCategoryFacade")
public class TestCategoryCatalogueFacade implements CategoryFacade {

	/**
	 * Category structure
	 */
	@Override
	public ReadableCategoryList getCategoryHierarchy(MerchantStore store, ListCriteria criteria, int depth,
			Language language, List<String> filter, int page, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistableCategory saveCategory(MerchantStore store, PersistableCategory category) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Category details
	 */
	@Override
	public ReadableCategory getById(MerchantStore store, Long id, Language language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReadableCategory getByCode(MerchantStore store, String code, Language language) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * When clicking on a category
	 */
	@Override
	public ReadableCategory getCategoryByFriendlyUrl(MerchantStore merchantStore, String friendlyUrl, Language language)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getByCode(String code, MerchantStore store) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(Long categoryId, MerchantStore store) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReadableProductVariant> categoryProductVariants(Long categoryId, MerchantStore store,
			Language language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existByCode(MerchantStore store, String code) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void move(Long child, Long parent, MerchantStore store) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVisible(PersistableCategory category, MerchantStore store) {
		// TODO Auto-generated method stub
		
	}


}
