package com.shopizer.services.catalogue.model.product.variants;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import com.shopizer.services.catalogue.model.product.Product;
import com.shopizer.services.catalogue.model.product.options.ProductOption;

@Entity
@Table(name = "PRODUCT_VARIANT", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "VARIANT_ID", "PRODUCT_ID" }) })
public class ProductVariant {

  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="PRODUCT_ID", nullable=false)
  private Product product;
  
  @Column(name = "DEFAULT")
  private boolean defaultVariant;
  
  @ManyToOne(targetEntity = ProductOption.class)
  @JoinColumn(name = "PRODUCT_OPTION_ID", nullable = false)
  private Set<ProductOption> options;

  @NotEmpty
  @Pattern(regexp = "^[a-zA-Z0-9_]*$")
  @Column(name = "SKU")
  private String sku;

  /**
   * External system reference SKU/ID
   */
  @Column(name = "REF_SKU")
  private String refSku;
  
  
  @Embedded
  private ProductDimensions dimensions;


  public String getSku() {
    return sku;
  }


  public void setSku(String sku) {
    this.sku = sku;
  }


  public Product getProduct() {
    return product;
  }


  public void setProduct(Product product) {
    this.product = product;
  }


  public boolean isDefaultVariant() {
    return defaultVariant;
  }


  public void setDefaultVariant(boolean defaultVariant) {
    this.defaultVariant = defaultVariant;
  }


  public Set<ProductOption> getOptions() {
    return options;
  }


  public void setOptions(Set<ProductOption> options) {
    this.options = options;
  }


  public ProductDimensions getDimensions() {
    return dimensions;
  }


  public void setDimensions(ProductDimensions dimensions) {
    this.dimensions = dimensions;
  }

}
