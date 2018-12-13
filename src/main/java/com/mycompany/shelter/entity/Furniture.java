package com.mycompany.shelter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "furniture")
public class Furniture {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	@Column(name = "typeId")
	private String typeId;

	@Column(name = "type")
	private String type;

	@Column(name = "title")
	private String title;

	@Column(name = "price")
	private String price;

	@Column(name = "brand")
	private String brand;

	@Column(name = "classify")
	private String classify;

	@Column(name = "style")
	private String style;

	@Column(name = "inventory")
	private String inventory;

	@Column(name = "label")
	private String label;

	@Column(name = "coverAdd")
	private String coverAdd;

	@Column(name = "note")
	private String note;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCoverAdd() {
		return coverAdd;
	}

	public void setCoverAdd(String coverAdd) {
		this.coverAdd = coverAdd;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
