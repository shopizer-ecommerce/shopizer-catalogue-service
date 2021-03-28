package com.shopizer.services.catalogue.model.product.images;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.shopizer.db.audit.Auditable;
import com.shopizer.services.catalogue.model.product.variants.ProductVariant;

@Entity
@Table(name = "PRODUCT_IMAGE")
public class ProductImage extends Auditable<String> {


  @Id
  @Column(name = "PRODUCT_IMAGE_ID", unique = true, nullable = false)
  @TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME",
      valueColumnName = "SEQ_COUNT", pkColumnValue = "PRODUCT_IMG_SEQ_NEXT_VAL")
  @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
  private Long id;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "productImage", cascade = CascadeType.ALL)
  private List<ProductImageDescription> descriptions = new ArrayList<ProductImageDescription>();


  @Column(name = "PRODUCT_IMAGE")
  private String productImage;

  @Column(name = "DEFAULT_IMAGE")
  private boolean defaultImage = true;

  /**
   * default to 0 for images managed by the system
   */
  @Column(name = "IMAGE_TYPE")
  private int imageType;

  /**
   * Refers to images not accessible through the system. It may also be a video.
   */
  @Column(name = "PRODUCT_IMAGE_URL")
  private String productImageUrl;


  @ManyToOne(targetEntity = ProductVariant.class)
  @JoinColumn(name = "PRODUCT_VARIANT_ID", nullable = false)
  private ProductVariant productVariant;


  public ProductImage() {}

  public String getProductImage() {
    return productImage;
  }

  public void setProductImage(String productImage) {
    this.productImage = productImage;
  }

  public boolean isDefaultImage() {
    return defaultImage;
  }

  public void setDefaultImage(boolean defaultImage) {
    this.defaultImage = defaultImage;
  }

  public int getImageType() {
    return imageType;
  }

  public void setImageType(int imageType) {
    this.imageType = imageType;
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setDescriptions(List<ProductImageDescription> descriptions) {
    this.descriptions = descriptions;
  }

  public List<ProductImageDescription> getDescriptions() {
    return descriptions;
  }

  public String getProductImageUrl() {
    return productImageUrl;
  }

  public void setProductImageUrl(String productImageUrl) {
    this.productImageUrl = productImageUrl;
  }

  public ProductVariant getProductVariant() {
    return productVariant;
  }

  public void setProductVariant(ProductVariant productVariant) {
    this.productVariant = productVariant;
  }


}
