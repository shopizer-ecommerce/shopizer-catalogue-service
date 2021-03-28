package com.shopizer.services.catalogue.model.product.options;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PRODUCT_OPTION", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "PRODUCT_OPTION_DESC_ID", "PRODUCT_OPTION_VALUE_ID"}) })
public class ProductOption {
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="PRODUCT_OPTION_DESC_ID", nullable=false)
  private ProductOptionDescriptor productOptionDescriptor;
  

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="PRODUCT_OPTION_VALUE_ID", nullable=false)
  private ProductOptionValue productOptionValue;


  public ProductOptionDescriptor getProductOptionDescriptor() {
    return productOptionDescriptor;
  }


  public void setProductOptionDescriptor(ProductOptionDescriptor productOptionDescriptor) {
    this.productOptionDescriptor = productOptionDescriptor;
  }


  public ProductOptionValue getProductOptionValue() {
    return productOptionValue;
  }


  public void setProductOptionValue(ProductOptionValue productOptionValue) {
    this.productOptionValue = productOptionValue;
  }

}
