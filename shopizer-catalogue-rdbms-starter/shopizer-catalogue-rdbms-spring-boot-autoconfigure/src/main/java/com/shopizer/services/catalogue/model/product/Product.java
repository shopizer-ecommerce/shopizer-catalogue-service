package com.shopizer.services.catalogue.model.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;
import com.shopizer.db.audit.Auditable;
import com.shopizer.services.catalogue.model.category.Category;
import com.shopizer.services.catalogue.model.product.manufacturer.Manufacturer;
import com.shopizer.services.catalogue.model.product.type.ProductType;


@Entity
@Table(name = "PRODUCT",
    uniqueConstraints = @UniqueConstraint(columnNames = {"MERCHANT_CODE", "SKU"}))
@Deprecated
public class Product extends Auditable<String> implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "PRODUCT_ID", unique = true, nullable = false)
  @TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME",
      valueColumnName = "SEQ_COUNT", pkColumnValue = "PRODUCT_SEQ_NEXT_VAL")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
  private Long id;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
  private Set<ProductDescription> descriptions = new HashSet<ProductDescription>();



  /*
   * 
   * @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product") private
   * Set<ProductRelationship> relationships = new HashSet<ProductRelationship>();
   */

  @NotNull
  @Column(name = "MERCHANT_CODE", nullable = false)
  private String merchantStore;

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
  @JoinTable(name = "PRODUCT_CATEGORY",
      joinColumns = {@JoinColumn(name = "PRODUCT_ID", nullable = false, updatable = false)},
      inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID", nullable = false, updatable = false)})
  @Cascade({org.hibernate.annotations.CascadeType.DETACH,
      org.hibernate.annotations.CascadeType.LOCK, org.hibernate.annotations.CascadeType.REFRESH,
      org.hibernate.annotations.CascadeType.REPLICATE

  })
  private Set<Category> categories = new HashSet<Category>();



  @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
  @JoinColumn(name = "MANUFACTURER_ID", nullable = true)
  private Manufacturer manufacturer;


  @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
  @JoinColumn(name = "PRODUCT_TYPE_ID", nullable = true)
  private ProductType type;

  @Column(name = "PRODUCT_VIRTUAL", columnDefinition = "boolean default false", nullable = false)
  private boolean productVirtual = false;

  @Column(name = "PRODUCT_FREE", columnDefinition = "boolean default false", nullable = false)
  private boolean productIsFree;

  @Column(name = "REVIEW_AVG")
  private BigDecimal productReviewAvg;

  @Column(name = "REVIEW_COUNT")
  private Integer productReviewCount;

  @Column(name = "QUANTITY_ORDERED")
  private Integer productOrdered;

  public Product() {}

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isProductVirtual() {
    return productVirtual;
  }

  public BigDecimal getProductReviewAvg() {
    return productReviewAvg;
  }

  public void setProductReviewAvg(BigDecimal productReviewAvg) {
    this.productReviewAvg = productReviewAvg;
  }

  public Integer getProductReviewCount() {
    return productReviewCount;
  }

  public void setProductReviewCount(Integer productReviewCount) {
    this.productReviewCount = productReviewCount;
  }

  public Integer getProductOrdered() {
    return productOrdered;
  }

  public void setProductOrdered(Integer productOrdered) {
    this.productOrdered = productOrdered;
  }

  public Set<ProductDescription> getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(Set<ProductDescription> descriptions) {
    this.descriptions = descriptions;
  }

  public boolean getProductVirtual() {
    return productVirtual;
  }

  public void setProductVirtual(boolean productVirtual) {
    this.productVirtual = productVirtual;
  }

  public boolean getProductIsFree() {
    return productIsFree;
  }

  public void setProductIsFree(boolean productIsFree) {
    this.productIsFree = productIsFree;
  }

  public Manufacturer getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(Manufacturer manufacturer) {
    this.manufacturer = manufacturer;
  }

  public ProductType getType() {
    return type;
  }

  public void setType(ProductType type) {
    this.type = type;
  }

  /*
   * public Set<ProductRelationship> getRelationships() { return relationships; }
   * 
   * public void setRelationships(Set<ProductRelationship> relationships) { this.relationships =
   * relationships; }
   */


  public Set<Category> getCategories() {
    return categories;
  }

  public void setCategories(Set<Category> categories) {
    this.categories = categories;
  }

  public String getMerchantStore() {
    return merchantStore;
  }

  public void setMerchantStore(String merchantStore) {
    this.merchantStore = merchantStore;
  }





}
