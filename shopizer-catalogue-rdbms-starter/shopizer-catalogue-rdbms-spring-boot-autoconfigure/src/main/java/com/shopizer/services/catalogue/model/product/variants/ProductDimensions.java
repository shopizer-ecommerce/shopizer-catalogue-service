package com.shopizer.services.catalogue.model.product.variants;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductDimensions {
  
  
  @Column(name = "LENGTH")
  private BigDecimal length;

  @Column(name = "WIDTH")
  private BigDecimal width;

  @Column(name = "HEIGHT")
  private BigDecimal height;

  @Column(name = "WEIGHT")
  private BigDecimal weight;

}
