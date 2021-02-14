package com.shopizer.db.references.geozone;

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
@Table(name="GEOZONE_DESCRIPTION", uniqueConstraints={
		@UniqueConstraint(columnNames={
			"GEOZONE_ID",
			"LANGUAGE_ID"
		})
	}
)

@TableGenerator(name = "description_gen", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "geozone_description_seq", allocationSize = com.shopizer.db.SchemaConstants.DESCRIPTION_ID_ALLOCATION_SIZE, initialValue = com.shopizer.db.SchemaConstants.DESCRIPTION_ID_START_VALUE)
public class GeoZoneDescription extends Description {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "GEOZONE_DESCRIPTION_ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "geozone_description_gen")
	private Long id;
	
	@ManyToOne(targetEntity = GeoZone.class)
	@JoinColumn(name = "GEOZONE_ID")
	private GeoZone geoZone;
	
	public GeoZoneDescription() {
	}

	public GeoZone getGeoZone() {
		return geoZone;
	}

	public void setGeoZone(GeoZone geoZone) {
		this.geoZone = geoZone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
