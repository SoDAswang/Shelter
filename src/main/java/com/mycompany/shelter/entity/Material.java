package com.mycompany.shelter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "material")
public class Material {
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
	
	@Column(name = "texture")
	private String texture;
		
	@Column(name = "style")
	private String style;
	
	@Column(name = "fit")
	private String fit;
	
	@Column(name = "inventory")
	private String inventory;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "coverAdd")
	private String coverAdd;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "classify")
	private String classify;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "length")
	private String length;
	
	@Column(name = "width")
	private String width;
	
	@Column(name = "weight")
	private String weight;
	
	@Column(name = "areaPerWeight")
	private String areaPerWeight;
	
	@Column(name = "use")
	private String use;

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

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getFit() {
		return fit;
	}

	public void setFit(String fit) {
		this.fit = fit;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	public String getMaterialLabel() {
		return label;
	}

	public void setMaterialLabel(String label) {
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
	
	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getAreaPerWeight() {
		return areaPerWeight;
	}

	public void setAreaPerWeight(String areaPerWeight) {
		this.areaPerWeight = areaPerWeight;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}
	
	
}
