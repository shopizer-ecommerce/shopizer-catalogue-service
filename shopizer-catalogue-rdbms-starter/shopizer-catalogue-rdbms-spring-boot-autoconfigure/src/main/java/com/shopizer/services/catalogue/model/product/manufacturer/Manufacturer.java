package com.shopizer.services.catalogue.model.product.manufacturer;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.shopizer.db.audit.Auditable;

@Entity
@Table(name = "MANUFACTURER",
    uniqueConstraints = @UniqueConstraint(columnNames = {"MERCHANT_CODE", "CODE"}))
public class Manufacturer extends Auditable<String> implements Serializable {
  private static final long serialVersionUID = 1L;

  public static final String DEFAULT_MANUFACTURER = "DEFAULT";

  @Id
  @Column(name = "MANUFACTURER_ID", unique = true, nullable = false)
  @TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME",
      valueColumnName = "SEQ_COUNT", pkColumnValue = "MANUFACT_SEQ_NEXT_VAL")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
  private Long id;

  @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Set<ManufacturerDescription> descriptions = new HashSet<ManufacturerDescription>();

  @Column(name = "MANUFACTURER_IMAGE")
  private String image;

  @Column(name = "SORT_ORDER")
  private int order = 0;

  @NotNull
  @Column(name = "MERCHANT_CODE", nullable = false)
  private String merchantStore;

  @NotEmpty
  @Column(name = "CODE", length = 100, nullable = false)
  private String code;

  public Manufacturer() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Set<ManufacturerDescription> getDescriptions() {
    return descriptions;
  }

  public void setDescriptions(Set<ManufacturerDescription> descriptions) {
    this.descriptions = descriptions;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public int getOrder() {
    return order;
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


}
