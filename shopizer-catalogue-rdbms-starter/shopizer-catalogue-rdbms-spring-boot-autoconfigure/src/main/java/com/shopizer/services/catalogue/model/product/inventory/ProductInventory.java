package com.shopizer.services.catalogue.model.product.inventory;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import com.shopizer.services.catalogue.model.product.taxclass.ProductTaxClass;
import com.shopizer.services.catalogue.model.product.variant.ProductVariant;

@Entity
@Table(name = "PRODUCT_INVENTORY",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"INVENTORY_ID", "VARIANT_ID"})})
public class ProductInventory {

  @Id
  @Column(name = "PRODUCT_INVENTORY_ID", unique = true, nullable = false)
  @TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME",
      valueColumnName = "SEQ_COUNT", pkColumnValue = "PRODUCT_INVT_SEQ_NEXT_VAL")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "VARIANT_ID", nullable = false)
  private ProductVariant productVariant;

  @Column(name = "AVAILABLE", columnDefinition = "boolean default true", nullable = false)
  private Boolean available = true;

  @Column(name = "DATE_AVAILABLE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateAvailable = new Date();

  @Column(name = "PREORDER", columnDefinition = "boolean default false", nullable = false)
  private Boolean preOrder = false;

  @Column(name = "PRODUCT_SHIP", columnDefinition = "boolean default false", nullable = false)
  private Boolean productShipeable = false;

  @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
  @JoinColumn(name = "PRD_TAX_CLASS_ID", nullable = true)
  private ProductTaxClass taxClass;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ProductVariant getProductVariant() {
    return productVariant;
  }

  public void setProductVariant(ProductVariant productVariant) {
    this.productVariant = productVariant;
  }

  public Boolean getAvailable() {
    return available;
  }

  public void setAvailable(Boolean available) {
    this.available = available;
  }

  public Date getDateAvailable() {
    return dateAvailable;
  }

  public void setDateAvailable(Date dateAvailable) {
    this.dateAvailable = dateAvailable;
  }

  public Boolean getPreOrder() {
    return preOrder;
  }

  public void setPreOrder(Boolean preOrder) {
    this.preOrder = preOrder;
  }

  public Boolean getProductShipeable() {
    return productShipeable;
  }

  public void setProductShipeable(Boolean productShipeable) {
    this.productShipeable = productShipeable;
  }

  public ProductTaxClass getTaxClass() {
    return taxClass;
  }

  public void setTaxClass(ProductTaxClass taxClass) {
    this.taxClass = taxClass;
  }


}
