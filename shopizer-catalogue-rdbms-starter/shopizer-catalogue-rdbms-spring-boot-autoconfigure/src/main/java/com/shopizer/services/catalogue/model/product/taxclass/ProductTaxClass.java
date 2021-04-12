package com.shopizer.services.catalogue.model.product.taxclass;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.shopizer.db.audit.Auditable;

@Entity
@Table(name = "PRODUCT_TAX_CLASS",
    indexes = {@Index(name = "PRD_TAX_CLASS_CODE_IDX", columnList = "PRD_TAX_CLASS_CODE")},
    uniqueConstraints = @UniqueConstraint(columnNames = {"MERCHANT_CODE", "PRD_TAX_CLASS_CODE"}))


public class ProductTaxClass extends Auditable<String> implements Serializable {
  private static final long serialVersionUID = 1L;

  public final static String DEFAULT_TAX_CLASS = "DEFAULT";

  public ProductTaxClass(String store, String code) {
    this.code = code;
    this.title = code;
    this.merchantStore = store;
  }

  @Id
  @Column(name = "PRD_TAX_CLASS_ID", unique = true, nullable = false)
  @TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME",
      valueColumnName = "SEQ_COUNT", pkColumnValue = "PRD_TX_CLASS_SEQ_NEXT_VAL")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
  private Long id;

  @NotEmpty
  @Column(name = "PRD_TAX_CLASS_CODE", nullable = false, length = 10)
  private String code;

  @NotEmpty
  @Column(name = "PRD_TAX_CLASS_TITLE", nullable = false, length = 32)
  private String title;

  @NotNull
  @Column(name = "MERCHANT_CODE", nullable = false)
  private String merchantStore;

  @Column(name = "PRD_TAXEABLE", columnDefinition = "boolean default true", nullable = false)
  private boolean taxeable = true;


  public ProductTaxClass() {
    super();
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMerchantStore() {
    return merchantStore;
  }

  public void setMerchantStore(String merchantStore) {
    this.merchantStore = merchantStore;
  }

  public boolean isTaxeable() {
    return taxeable;
  }

  public void setTaxeable(boolean taxeable) {
    this.taxeable = taxeable;
  }


}
