package com.shopizer.services.catalogue.model.product.type;

import java.io.Serializable;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.shopizer.db.audit.Auditable;

@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType extends Auditable<String> implements Serializable {
  private static final long serialVersionUID = 1L;

  public final static String GENERAL_TYPE = "GENERAL";

  @Id
  @Column(name = "PRODUCT_TYPE_ID", unique = true, nullable = false)
  @TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME",
      valueColumnName = "SEQ_COUNT", pkColumnValue = "PRD_TYPE_SEQ_NEXT_VAL")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
  private Long id;
  
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productType")
  private Set<ProductTypeDescription> descriptions = new HashSet<ProductTypeDescription>();

  @Column(name = "PRD_TYPE_CODE")
  private String code;

  @Column(name = "PRD_TYPE_ADD_TO_CART")
  private Boolean allowAddToCart;

  @JoinColumn(name = "MERCHANT_CODE", nullable = true)
  private String merchantStore;

  public ProductType() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isAllowAddToCart() {
    return allowAddToCart;
  }

  public void setAllowAddToCart(boolean allowAddToCart) {
    this.allowAddToCart = allowAddToCart;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Boolean getAllowAddToCart() {
    return allowAddToCart;
  }

  public void setAllowAddToCart(Boolean allowAddToCart) {
    this.allowAddToCart = allowAddToCart;
  }

  public String getMerchantStore() {
    return merchantStore;
  }

  public void setMerchantStore(String merchantStore) {
    this.merchantStore = merchantStore;
  }


}
