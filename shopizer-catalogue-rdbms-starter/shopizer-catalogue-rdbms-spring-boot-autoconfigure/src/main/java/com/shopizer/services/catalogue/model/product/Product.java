package com.shopizer.services.catalogue.model.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import org.hibernate.annotations.Cascade;
import com.salesmanager.core.model.catalog.category.Category;
import com.salesmanager.core.model.catalog.product.manufacturer.Manufacturer;
import com.salesmanager.core.model.catalog.product.type.ProductType;
import com.shopizer.db.audit.Auditable;
import com.shopizer.db.merchant.MerchantStore;


@Entity
@Table(name = "PRODUCT", uniqueConstraints=
@UniqueConstraint(columnNames = {"MERCHANT_CODE", "SKU"}))
public class Product extends Auditable<String> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PRODUCT_ID", unique=true, nullable=false)
	@TableGenerator(
		 name = "TABLE_GEN", 
		 table = "SM_SEQUENCER", 
		 pkColumnName = "SEQ_NAME", 
		 valueColumnName = "SEQ_COUNT", 
		 pkColumnValue = "PRODUCT_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "product")
	private Set<ProductDescription> descriptions = new HashSet<ProductDescription>();
	

	/*
	 * @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
	 * mappedBy="product") private Set<ProductAvailability> availabilities = new
	 * HashSet<ProductAvailability>();
	 * 
	 * @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy =
	 * "product") private Set<ProductAttribute> attributes = new
	 * HashSet<ProductAttribute>();
	 * 
	 * @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy =
	 * "product")//cascade is set to remove because product save requires logic to
	 * create physical image first and then save the image id in the database,
	 * cannot be done in cascade private Set<ProductImage> images = new
	 * HashSet<ProductImage>();
	 * 
	 * @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy =
	 * "product") private Set<ProductRelationship> relationships = new
	 * HashSet<ProductRelationship>();
	 */

	@JoinColumn(name="MERCHANT_CODE", nullable=false)
	private String merchantStore;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.REFRESH})
	@JoinTable(name = "PRODUCT_CATEGORY", joinColumns = { 
			@JoinColumn(name = "PRODUCT_ID", nullable = false, updatable = false) }
			, 
			inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID", 
					nullable = false, updatable = false) }
	)
	@Cascade({
		org.hibernate.annotations.CascadeType.DETACH,
		org.hibernate.annotations.CascadeType.LOCK,
		org.hibernate.annotations.CascadeType.REFRESH,
		org.hibernate.annotations.CascadeType.REPLICATE
		
	})
	private Set<Category> categories = new HashSet<Category>();
	
	@Column(name="DATE_AVAILABLE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAvailable = new Date();
	
	
	@Column(name = "AVAILABLE", columnDefinition = "boolean default true", nullable = false)
	private Boolean available = true;
	

	@Column(name = "PREORDER", columnDefinition = "boolean default false", nullable = false)
	private Boolean preOrder = false;

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
	@JoinColumn(name="MANUFACTURER_ID", nullable=true) 
	private Manufacturer manufacturer;
	

	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name="PRODUCT_TYPE_ID", nullable=true) 
	private ProductType type;
	
	/** 
	 * @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
	 * 
	 * @JoinColumn(name="TAX_CLASS_ID", nullable=true) private TaxClass taxClass;
	 */

	@Column(name = "PRODUCT_VIRTUAL", columnDefinition = "boolean default false", nullable = false)
	private boolean productVirtual = false;
	
	@Column(name = "PRODUCT_SHIP", columnDefinition = "boolean default false", nullable = false)
	private Boolean productShipeable = false;


	@Column(name = "PRODUCT_FREE", columnDefinition = "boolean default false", nullable = false)
	private boolean productIsFree;

	@Column(name = "PRODUCT_LENGTH")
	private BigDecimal productLength;

	@Column(name = "PRODUCT_WIDTH")
	private BigDecimal productWidth;

	@Column(name = "PRODUCT_HEIGHT")
	private BigDecimal productHeight;

	@Column(name = "PRODUCT_WEIGHT")
	private BigDecimal productWeight;

	@Column(name = "REVIEW_AVG")
	private BigDecimal productReviewAvg;

	@Column(name = "REVIEW_COUNT")
	private Integer productReviewCount;

	@Column(name = "QUANTITY_ORDERED")
	private Integer productOrdered;
	
	@Column(name = "SORT_ORDER")
	private int sortOrder = 0;

	@NotEmpty
	@Pattern(regexp="^[a-zA-Z0-9_]*$")
	@Column(name = "SKU")
	private String sku;
	
	/**
	 * External system reference SKU/ID
	 */
	@Column(name = "REF_SKU")
	private String refSku;

	public Product() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isProductVirtual() {
		return productVirtual;
	}

	public BigDecimal getProductLength() {
		return productLength;
	}

	public void setProductLength(BigDecimal productLength) {
		this.productLength = productLength;
	}

	public BigDecimal getProductWidth() {
		return productWidth;
	}

	public void setProductWidth(BigDecimal productWidth) {
		this.productWidth = productWidth;
	}

	public BigDecimal getProductHeight() {
		return productHeight;
	}

	public void setProductHeight(BigDecimal productHeight) {
		this.productHeight = productHeight;
	}

	public BigDecimal getProductWeight() {
		return productWeight;
	}

	public void setProductWeight(BigDecimal productWeight) {
		this.productWeight = productWeight;
	}

	public BigDecimal getProductReviewAvg() {
		return productReviewAvg;
	}

	public void setProductReviewAvg(BigDecimal productReviewAvg) {
		this.productReviewAvg = productReviewAvg;
	}

	public Integer getProductReviewCount() {
		return productReviewCount;
	}

	public void setProductReviewCount(Integer productReviewCount) {
		this.productReviewCount = productReviewCount;
	}

	public Integer getProductOrdered() {
		return productOrdered;
	}

	public void setProductOrdered(Integer productOrdered) {
		this.productOrdered = productOrdered;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public Set<ProductDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Set<ProductDescription> descriptions) {
		this.descriptions = descriptions;
	}

	public boolean getProductVirtual() {
		return productVirtual;
	}

	public void setProductVirtual(boolean productVirtual) {
		this.productVirtual = productVirtual;
	}

	public boolean getProductIsFree() {
		return productIsFree;
	}

	public void setProductIsFree(boolean productIsFree) {
		this.productIsFree = productIsFree;
	}



	/*
	 * public Set<ProductAttribute> getAttributes() { return attributes; }
	 * 
	 * public void setAttributes(Set<ProductAttribute> attributes) { this.attributes
	 * = attributes; }
	 */


	 public Manufacturer getManufacturer() { return manufacturer; }

	 public void setManufacturer(Manufacturer manufacturer) { this.manufacturer = manufacturer; }

	 public ProductType getType() { return type; }

	 public void setType(ProductType type) { this.type = type; }
	 /* 
	 * 
	 * 
	 * public Set<ProductAvailability> getAvailabilities() { return availabilities;
	 * }
	 * 
	 * public void setAvailabilities(Set<ProductAvailability> availabilities) {
	 * this.availabilities = availabilities; }
	 * 
	 * public TaxClass getTaxClass() { return taxClass; }
	 * 
	 * public void setTaxClass(TaxClass taxClass) { this.taxClass = taxClass; }
	 * 
	 * public Set<ProductImage> getImages() { return images; }
	 * 
	 * public void setImages(Set<ProductImage> images) { this.images = images; }
	 */

	/*
	 * public Set<ProductRelationship> getRelationships() { return relationships; }
	 * 
	 * public void setRelationships(Set<ProductRelationship> relationships) {
	 * this.relationships = relationships; }
	 */


	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public String getMerchantStore() {
		return merchantStore;
	}

	public void setMerchantStore(String merchantStore) {
		this.merchantStore = merchantStore;
	}

	public Date getDateAvailable() {
		return dateAvailable;
	}

	public void setDateAvailable(Date dateAvailable) {
		this.dateAvailable = dateAvailable;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public boolean isAvailable() {
		return available != null ? available.booleanValue():false;
	}
	
	public boolean isProductShipeable() {
		return productShipeable != null ? productShipeable.booleanValue():false;
	}

	public void setProductShipeable(Boolean productShipeable) {
		this.productShipeable = productShipeable;
	}

	
	/*
	 * public ProductDescription getProductDescription() {
	 * if(this.getDescriptions()!=null && this.getDescriptions().size()>0) { return
	 * this.getDescriptions().iterator().next(); } return null; }
	 */
	
	/*
	 * public ProductImage getProductImage() { ProductImage productImage = null;
	 * if(this.getImages()!=null && this.getImages().size()>0) { for(ProductImage
	 * image : this.getImages()) { productImage = image;
	 * if(productImage.isDefaultImage()) { break; } } } return productImage; }
	 */
	
	public boolean isPreOrder() {
		return preOrder;
	}

	public void setPreOrder(boolean preOrder) {
		this.preOrder = preOrder;
	}

	public String getRefSku() {
		return refSku;
	}

	public void setRefSku(String refSku) {
		this.refSku = refSku;
	}




}
