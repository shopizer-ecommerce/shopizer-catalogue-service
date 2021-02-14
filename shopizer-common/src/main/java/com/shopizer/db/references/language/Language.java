package com.shopizer.db.references.language;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.shopizer.db.SchemaConstants;
import com.shopizer.db.audit.Auditable;
import com.shopizer.db.merchant.MerchantStore;


@Entity
@Table(name = "LANGUAGE", indexes = { @Index(name="CODE_IDX2", columnList = "CODE")})
@Cacheable
public class Language extends Auditable<String> implements Serializable {
  private static final long serialVersionUID = 1L;



  @Id
  @Column(name = "LANGUAGE_ID")
  @TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME",
      valueColumnName = "SEQ_COUNT", pkColumnValue = "LANG_SEQ_NEXT_VAL")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
  private Integer id;

  @Column(name = "CODE", nullable = false)
  private String code;

  @Column(name = "SORT_ORDER")
  private Integer sortOrder;

  @OneToMany(mappedBy = "defaultLanguage", targetEntity = MerchantStore.class)
  private List<MerchantStore> storesDefaultLanguage;

  @ManyToMany(mappedBy = "languages", targetEntity = MerchantStore.class, fetch = FetchType.LAZY)
  private List<MerchantStore> stores = new ArrayList<MerchantStore>();

  public Language() {}

  public Language(String code) {
    this.setCode(code);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Integer getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(Integer sortOrder) {
    this.sortOrder = sortOrder;
  }

}
