package com.shopizer.services.catalogue.model.product.type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;
import com.shopizer.db.description.Description;

@Entity
@Table(name = "PRODUCT_TYPE_DESCRIPTION", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "PRODUCT_TYPE_ID", "LANGUAGE_ID" }) })

@TableGenerator(name = "description_gen", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "product_type_description_seq", allocationSize = com.shopizer.db.SchemaConstants.DESCRIPTION_ID_ALLOCATION_SIZE, initialValue = com.shopizer.db.SchemaConstants.DESCRIPTION_ID_START_VALUE)
public class ProductTypeDescription extends Description {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRODUCT_TYPE_DESCRIPTION_ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "product_type_description_gen")
	private Long id;

	@ManyToOne(targetEntity = ProductType.class)
	@JoinColumn(name = "PRODUCT_TYPE_ID", nullable = false)
	private ProductType productType;

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
