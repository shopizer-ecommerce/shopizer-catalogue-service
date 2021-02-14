package com.shopizer.services.catalogue.model.product.manufacturer;

import java.util.Date;

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
@Table(name = "MANUFACTURER_DESCRIPTION", uniqueConstraints={
	@UniqueConstraint(columnNames={
			"MANUFACTURER_ID",
			"LANGUAGE_ID"
		})
	}
)

@TableGenerator(name = "description_gen", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "manufacturer_description_seq", allocationSize = com.shopizer.db.SchemaConstants.DESCRIPTION_ID_ALLOCATION_SIZE, initialValue = com.shopizer.db.SchemaConstants.DESCRIPTION_ID_START_VALUE)
public class ManufacturerDescription extends Description {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "MANUFACTURER_DESCRIPTION_ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "manufacturer_description_gen")
	private Long id;

	@ManyToOne(targetEntity = Manufacturer.class)
	@JoinColumn(name = "MANUFACTURER_ID", nullable = false)
	private Manufacturer manufacturer;
	
	@Column(name = "MANUFACTURERS_URL")
	private String url;
	
	@Column(name = "URL_CLICKED")
	private Integer urlClicked;
	
	@Column(name = "DATE_LAST_CLICK")
	private Date dateLastClick;
	
	public ManufacturerDescription() {
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getUrlClicked() {
		return urlClicked;
	}

	public void setUrlClicked(Integer urlClicked) {
		this.urlClicked = urlClicked;
	}

	public Date getDateLastClick() {
		return dateLastClick;
	}

	public void setDateLastClick(Date dateLastClick) {
		this.dateLastClick = dateLastClick;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
