package com.shopizer.services.catalogue.model.product.options;

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
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.shopizer.db.audit.Auditable;

@Entity
@Table(name = "PRODUCT_OPTION_DESCRIPTOR",
    indexes = {@Index(name = "PRD_OPT_DESC_CODE_IDX", columnList = "PRODUCT_OPT_DESC_CODE")},
    uniqueConstraints = @UniqueConstraint(columnNames = {"MERCHANT_CODE", "PRODUCT_OPT_DESC_CODE"}))
public class ProductOptionDescriptor extends Auditable<String> implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "PRODUCT_OPT_DESC_ID")
  @TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME",
      valueColumnName = "SEQ_COUNT", pkColumnValue = "PRODUCT_OPTION_SEQ_NEXT_VAL")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
  private Long id;

  @Column(name = "PRODUCT_OPT_DESC_SORT_ORD")
  private Integer productOptionSortOrder;

  @Column(name = "PRODUCT_OPT_DESC_TYPE", length = 10)
  private String productOptionType;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productOption")
  private Set<ProductOptionDescriptorDescription> descriptions = new HashSet<ProductOptionDescriptorDescription>();

  @NotNull
  @Column(name = "MERCHANT_CODE", nullable = false)
  private String merchantStore;

  @Column(name = "PRODUCT_OPT_DESC_READ")
  private boolean readOnly;

  @NotEmpty
  @Pattern(regexp = "^[a-zA-Z0-9_]*$")
  @Column(name = "PRODUCT_OPT_DESC_CODE")
  private String code;

  public ProductOptionDescriptor() {}

  public Integer getProductOptionSortOrder() {
    return productOptionSortOrder;
  }

  public void setProductOptionSortOrder(Integer productOptionSortOrder) {
    this.productOptionSortOrder = productOptionSortOrder;
  }

  public String getProductOptionType() {
    return productOptionType;
  }

  public void setProductOptionType(String productOptionType) {
    this.productOptionType = productOptionType;
  }

  public Set<ProductOptionDescriptorDescription> getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(Set<ProductOptionDescriptorDescription> descriptions) {
    this.descriptions = descriptions;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public void setReadOnly(boolean readOnly) {
    this.readOnly = readOnly;
  }

  public boolean isReadOnly() {
    return readOnly;
  }

  public String getMerchantStore() {
    return merchantStore;
  }

  public void setMerchantStore(String merchantStore) {
    this.merchantStore = merchantStore;
  }
}
