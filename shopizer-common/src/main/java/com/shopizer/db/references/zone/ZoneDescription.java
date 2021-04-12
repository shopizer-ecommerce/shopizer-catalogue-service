package com.shopizer.db.references.zone;

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
@Table(name="ZONE_DESCRIPTION", uniqueConstraints={
		@UniqueConstraint(columnNames={
			"ZONE_ID",
			"LANGUAGE_ID"
		})
	}
)
@TableGenerator(name = "description_gen", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT", pkColumnValue = "zone_description_seq", allocationSize = com.shopizer.db.SchemaConstants.DESCRIPTION_ID_ALLOCATION_SIZE, initialValue = com.shopizer.db.SchemaConstants.DESCRIPTION_ID_START_VALUE)
public class ZoneDescription extends Description {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ZONE_DESCRIPTION_ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "zone_description_gen")
	private Long id;
	

	@ManyToOne(targetEntity = Zone.class)
	@JoinColumn(name = "ZONE_ID", nullable = false)
	private Zone zone;
	
	public ZoneDescription() {
	}

	
	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
}
