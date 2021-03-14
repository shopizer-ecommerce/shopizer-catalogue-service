package com.shopizer.services.catalogue.model.product.options;

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
import org.hibernate.annotations.Type;
import com.shopizer.db.description.Description;

@Entity
@Table(name = "PRODUCT_OPTION_DESC", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "PRODUCT_OPTION_ID", "LANGUAGE_ID" }) })
@TableGenerator(name = "description_gen", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "product_option_description_seq", allocationSize = com.shopizer.db.SchemaConstants.DESCRIPTION_ID_ALLOCATION_SIZE, initialValue = com.shopizer.db.SchemaConstants.DESCRIPTION_ID_START_VALUE)
public class ProductOptionDescription extends Description {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRODUCT_OPTION_DESCRIPTION_ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "product_option_value_description_gen")
	private Long id;

	@ManyToOne(targetEntity = ProductOption.class)
	@JoinColumn(name = "PRODUCT_OPTION_ID", nullable = false)
	private ProductOption productOption;

	@Column(name = "PRODUCT_OPTION_COMMENT")
	@Type(type = "org.hibernate.type.TextType")
	private String productOptionComment;

	public ProductOptionDescription() {
	}

	public String getProductOptionComment() {
		return productOptionComment;
	}

	public void setProductOptionComment(String productOptionComment) {
		this.productOptionComment = productOptionComment;
	}

	public ProductOption getProductOption() {
		return productOption;
	}

	public void setProductOption(ProductOption productOption) {
		this.productOption = productOption;
	}
}
