package com.mycompany.shelter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sample_furniture")
public class SampleFurniture {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "sampleId")
	private String sampleId;

	@Column(name = "subject")
	private String subject;
	
	@Column(name = "furnitureId")
	private String furnitureId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSampleId() {
		return sampleId;
	}

	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFurnitureId() {
		return furnitureId;
	}

	public void setFurnitureId(String furnitureId) {
		this.furnitureId = furnitureId;
	}
	
}
