package com.shopizer.services.catalogue.model.category;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.shopizer.db.audit.Auditable;
import com.shopizer.db.merchant.MerchantStore;


@Entity
@Table(name = "CATEGORY",uniqueConstraints=
    @UniqueConstraint(columnNames = {"MERCHANT_CODE", "CODE"}) )
public class Category extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "CATEGORY_ID", unique=true, nullable=false)
    @TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "CATEGORY_SEQ_NEXT_VAL")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @Valid
    @OneToMany(mappedBy="category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CategoryDescription> descriptions = new HashSet<CategoryDescription>();

    @JoinColumn(name="MERCHANT_CODE", nullable=false)
    private String merchantStore;
    
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;
    
    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE)
    private List<Category> categories = new ArrayList<Category>();
    
    @Column(name = "CATEGORY_IMAGE", length=100)
    private String categoryImage;

    @Column(name = "SORT_ORDER")
    private Integer sortOrder = 0;

    @Column(name = "CATEGORY_STATUS")
    private boolean categoryStatus;

    @Column(name = "VISIBLE")
    private boolean visible;

    @Column(name = "DEPTH")
    private Integer depth;

    @Column(name = "LINEAGE")
    private String lineage;
    
    @Column(name="FEATURED")
    private boolean featured;
    
    @NotEmpty
    @Column(name="CODE", length=100, nullable=false)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Category() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean isCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public String getLineage() {
        return lineage;
    }

    public void setLineage(String lineage) {
        this.lineage = lineage;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }


    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public Set<CategoryDescription> getDescriptions() {
      return descriptions;
    }

    public void setDescriptions(Set<CategoryDescription> descriptions) {
      this.descriptions = descriptions;
    }

}