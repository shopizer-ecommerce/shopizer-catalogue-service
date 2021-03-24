package com.shopizer.services.catalogue.model.product.options;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PRODUCT_OPTION", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "OPTION_ID", "OPTION_VALUE_ID", "PRODUCT_ID" }) })
public class ProductOption {

}
