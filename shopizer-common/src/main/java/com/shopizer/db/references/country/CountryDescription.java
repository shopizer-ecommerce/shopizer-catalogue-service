package com.shopizer.db.references.country;

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


@Entity
@Table(name = "COUNTRY_DESCRIPTION", uniqueConstraints={
	@UniqueConstraint(columnNames={
			"COUNTRY_ID",
			"LANGUAGE_ID"
		})
	}
)
@TableGenerator(name = "description_gen", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "country_description_seq", allocationSize = com.shopizer.db.SchemaConstants.DESCRIPTION_ID_ALLOCATION_SIZE, initialValue = com.shopizer.db.SchemaConstants.DESCRIPTION_ID_START_VALUE)
public class CountryDescription extends com.shopizer.db.description.Description {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "COUNTRY_DESCRIPTION_ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "country_description_gen")
	private Long id;
	
	@ManyToOne(targetEntity = Country.class)
	@JoinColumn(name = "COUNTRY_ID", nullable = false)
	private Country country;
	
	public CountryDescription() {
	}

	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
}
