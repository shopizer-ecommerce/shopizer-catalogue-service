package com.shopizer.db.references.geozone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.shopizer.db.references.country.Country;

@Entity
@Table(name = "GEOZONE")
public class GeoZone implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "GEOZONE_ID")
	@TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "GEOZONE_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id;
	
	@OneToMany(mappedBy = "geoZone", cascade = CascadeType.ALL)
	private List<GeoZoneDescription> descriptions = new ArrayList<GeoZoneDescription>();

	@OneToMany(mappedBy = "geoZone", targetEntity = Country.class)
	private List<Country> countries = new ArrayList<Country>();

	
	@Column(name = "GEOZONE_NAME")
	private String name;
	
	@Column(name = "GEOZONE_CODE")
	private String code;
	
	public GeoZone() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public List<GeoZoneDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<GeoZoneDescription> descriptions) {
		this.descriptions = descriptions;
	}


}
