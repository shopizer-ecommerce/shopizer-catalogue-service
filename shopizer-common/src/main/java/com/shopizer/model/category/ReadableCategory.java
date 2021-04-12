package com.shopizer.model.category;

import java.util.ArrayList;
import java.util.List;

public class ReadableCategory extends CategoryModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	//private CategoryDescription description;//one category based on language
	private int productCount;
	private String store;
	private List<ReadableCategory> children = new ArrayList<ReadableCategory>();
	private ReadableCategory parent = null;

	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public List<ReadableCategory> getChildren() {
		return children;
	}
	public void setChildren(List<ReadableCategory> children) {
		this.children = children;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public ReadableCategory getParent() {
		return parent;
	}
	public void setParent(ReadableCategory parent) {
		this.parent = parent;
	}


}
