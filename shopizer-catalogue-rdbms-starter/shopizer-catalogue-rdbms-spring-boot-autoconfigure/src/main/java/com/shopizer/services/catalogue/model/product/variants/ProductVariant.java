package com.shopizer.services.catalogue.model.product.variants;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PRODUCT_VATIANT", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "VARIANT_ID", "PRODUCT_ID" }) })
public class ProductVariant {
  
  private String sku;
  //todo productId
  private boolean defaultVariant;

}
