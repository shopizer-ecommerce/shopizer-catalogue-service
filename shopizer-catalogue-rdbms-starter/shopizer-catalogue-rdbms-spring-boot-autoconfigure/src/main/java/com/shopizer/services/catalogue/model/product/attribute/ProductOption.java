package com.shopizer.services.catalogue.model.product.attribute;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.shopizer.db.audit.Auditable;
import com.shopizer.db.merchant.MerchantStore;

@Entity
@Table(name = "PRODUCT_OPTION", indexes = {
		@Index(name = "PRD_OPTION_CODE_IDX", columnList = "PRODUCT_OPTION_CODE") }, uniqueConstraints = @UniqueConstraint(columnNames = {
				"MERCHANT_ID", "PRODUCT_OPTION_CODE" }))
public class ProductOption extends Auditable<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRODUCT_OPTION_ID")
	@TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "PRODUCT_OPTION_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id;

	@Column(name = "PRODUCT_OPTION_SORT_ORD")
	private Integer productOptionSortOrder;

	@Column(name = "PRODUCT_OPTION_TYPE", length = 10)
	private String productOptionType;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "productOption")
	private Set<ProductOptionDescription> descriptions = new HashSet<ProductOptionDescription>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MERCHANT_ID", nullable = false)
	private MerchantStore merchantStore;

	@Column(name = "PRODUCT_OPTION_READ")
	private boolean readOnly;

	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9_]*$")
	@Column(name = "PRODUCT_OPTION_CODE")
	private String code;

	public ProductOption() {
	}

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

	public Set<ProductOptionDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<ProductOptionDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MerchantStore getMerchantStore() {
		return merchantStore;
	}

	public void setMerchantStore(MerchantStore merchantStore) {
		this.merchantStore = merchantStore;
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
}
