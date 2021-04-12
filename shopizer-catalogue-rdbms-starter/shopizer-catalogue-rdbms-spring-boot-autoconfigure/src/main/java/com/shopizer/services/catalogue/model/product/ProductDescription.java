package com.shopizer.services.catalogue.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

import com.shopizer.db.description.Description;

@Entity
@Table(name = "PRODUCT_DESCRIPTION", 
		uniqueConstraints = {@UniqueConstraint(columnNames = { "PRODUCT_ID", "LANGUAGE_ID" })},
		indexes = {@Index(name = "PRODUCT_DESCRIPTION_SEF_URL", columnList = "SEF_URL")})

@TableGenerator(name = "description_gen", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "product_description_seq", allocationSize = com.shopizer.db.SchemaConstants.DESCRIPTION_ID_ALLOCATION_SIZE, initialValue = com.shopizer.db.SchemaConstants.DESCRIPTION_ID_START_VALUE)
public class ProductDescription extends Description {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRODUCT_DESCRIPTION_ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "product_description_gen")
	private Long id;
	
	@ManyToOne(targetEntity = Product.class)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;

	@Column(name = "PRODUCT_HIGHLIGHT")
	private String productHighlight;

	@Column(name = "DOWNLOAD_LNK")
	private String productExternalDl;

	@Column(name = "SEF_URL")
	private String seUrl;

	@Column(name = "META_TITLE")
	private String metatagTitle;

	@Column(name = "META_KEYWORDS")
	private String metatagKeywords;

	@Column(name = "META_DESCRIPTION")
	private String metatagDescription;

	public ProductDescription() {
	}

	public String getProductHighlight() {
		return productHighlight;
	}

	public void setProductHighlight(String productHighlight) {
		this.productHighlight = productHighlight;
	}

	public String getProductExternalDl() {
		return productExternalDl;
	}

	public void setProductExternalDl(String productExternalDl) {
		this.productExternalDl = productExternalDl;
	}

	public String getSeUrl() {
		return seUrl;
	}

	public void setSeUrl(String seUrl) {
		this.seUrl = seUrl;
	}

	public String getMetatagTitle() {
		return metatagTitle;
	}

	public void setMetatagTitle(String metatagTitle) {
		this.metatagTitle = metatagTitle;
	}

	public String getMetatagKeywords() {
		return metatagKeywords;
	}

	public void setMetatagKeywords(String metatagKeywords) {
		this.metatagKeywords = metatagKeywords;
	}

	public String getMetatagDescription() {
		return metatagDescription;
	}

	public void setMetatagDescription(String metatagDescription) {
		this.metatagDescription = metatagDescription;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
