package com.shopizer.services.catalogue.model.product.group;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
import javax.validation.constraints.NotNull;
import com.shopizer.db.audit.Auditable;
import com.shopizer.services.catalogue.model.product.variant.ProductVariant;

/**
 * Allows grouping products and category
 * Catalog

 *      - product 1
 *      - product 2
 *      - product 3
 *      - product 4
 *      
 * @author carlsamson
 *
 */


@Entity
@Table(name = "CATALOG",
uniqueConstraints=@UniqueConstraint(columnNames = {"MERCHANT_CODE", "CODE"}))
public class ProductGroup extends Auditable<String> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "CATALOG_ID", unique = true, nullable = false)
    @TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME",
        valueColumnName = "SEQ_COUNT", pkColumnValue = "CATALOG_SEQ_NEXT_VAL")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
    private Long id;

    @NotNull
    @Column(name = "MERCHANT_CODE", nullable = false)
    private String merchantStore;


    @Column(name = "VISIBLE")
    private boolean visible;
    
    @Column(name="DEFAULT_CATALOG")
    private boolean defaultCatalog;
    
    @NotEmpty
    @Column(name="CODE", length=100, nullable=false)
    private String code;

    @Column(name = "SORT_ORDER")
    private Integer sortOrder = 0;
    
    @OneToMany(mappedBy="variant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProductVariant> entry = new HashSet<ProductVariant>();



}