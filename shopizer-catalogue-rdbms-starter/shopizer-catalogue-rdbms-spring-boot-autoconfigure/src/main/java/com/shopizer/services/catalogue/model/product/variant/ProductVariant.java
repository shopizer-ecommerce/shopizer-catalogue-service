package com.shopizer.services.catalogue.model.product.variant;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import com.shopizer.db.audit.Auditable;
import com.shopizer.services.catalogue.model.product.Product;
import com.shopizer.services.catalogue.model.product.image.ProductImage;
import com.shopizer.services.catalogue.model.product.option.ProductOption;

@Entity
@Table(name = "PRODUCT_VARIANT", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "VARIANT_ID", "PRODUCT_ID" }) })
public class ProductVariant extends Auditable<String> implements Serializable {

  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="PRODUCT_ID", nullable=false)
  private Product product;
  
  @Column(name = "DEFAULT")
  private boolean defaultVariant;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "PRODUCT_OPTION_ID", nullable = true)
  private ProductOption option;
  
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "product_variant")
  private Set<ProductImage> images = new HashSet<ProductImage>();


  @NotEmpty
  @Pattern(regexp = "^[a-zA-Z0-9_]*$")
  @Column(name = "SKU")
  private String sku;

  /**
   * External system reference SKU/ID
   */
  @Column(name = "REF_SKU")
  private String refSku;
  
  @Column(name = "SORT_ORDER")
  private int sortOrder;;
  
  
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


  public ProductDimensions getDimensions() {
    return dimensions;
  }


  public void setDimensions(ProductDimensions dimensions) {
    this.dimensions = dimensions;
  }


  public ProductOption getOption() {
    return option;
  }


  public void setOption(ProductOption option) {
    this.option = option;
  }


  public String getRefSku() {
    return refSku;
  }


  public void setRefSku(String refSku) {
    this.refSku = refSku;
  }


  public int getSortOrder() {
    return sortOrder;
  }


  public void setSortOrder(int sortOrder) {
    this.sortOrder = sortOrder;
  }

}
