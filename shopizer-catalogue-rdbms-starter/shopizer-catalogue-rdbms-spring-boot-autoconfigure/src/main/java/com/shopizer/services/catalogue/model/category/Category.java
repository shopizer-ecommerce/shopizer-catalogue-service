package com.shopizer.services.catalogue.model.category;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.shopizer.db.audit.Auditable;


@Entity
@Table(name = "CATEGORY")
public class Category extends Auditable<String> implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "CATEGORY_ID", unique = true, nullable = false)
  @TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME",
      valueColumnName = "SEQ_COUNT", pkColumnValue = "CATEGORY_SEQ_NEXT_VAL")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
  private Long id;

  @NotNull
  @Column(name = "MERCHANT_CODE", nullable = false)
  private String merchantStore;


  public String getMerchantStore() {
    return merchantStore;
  }

  public void setMerchantStore(String merchantStore) {
    this.merchantStore = merchantStore;
  }

  @Column(name = "CATEGORY_IMAGE", length = 100)
  private String categoryImage;

  @Column(name = "SORT_ORDER")
  private Integer sortOrder = 0;

  @Column(name = "CATEGORY_STATUS")
  private boolean categoryStatus;

  @Column(name = "VISIBLE")
  private boolean visible;

  @Column(name = "DEPTH")
  private Integer depth;

  @Column(name = "LINEAGE")
  private String lineage;

  @Column(name = "FEATURED")
  private boolean featured;

  @NotEmpty
  @Column(name = "CODE", length = 100, nullable = false)
  private String code;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Category() {}

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCategoryImage() {
    return categoryImage;
  }

  public void setCategoryImage(String categoryImage) {
    this.categoryImage = categoryImage;
  }

  public Integer getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
  }

  public boolean isCategoryStatus() {
    return categoryStatus;
  }

  public void setCategoryStatus(boolean categoryStatus) {
    this.categoryStatus = categoryStatus;
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public Integer getDepth() {
    return depth;
  }

  public void setDepth(Integer depth) {
    this.depth = depth;
  }

  public String getLineage() {
    return lineage;
  }

  public void setLineage(String lineage) {
    this.lineage = lineage;
  }

  boolean isFeatured() {
    return featured;
  }

  public void setFeatured(boolean featured) {
    this.featured = featured;
  }

}
