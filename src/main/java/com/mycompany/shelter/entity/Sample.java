package com.mycompany.shelter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author LENOVO-PC
 *
 */

@Entity
@Table(name = "sample")
public class Sample {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "label")
	private String label;
	
	@Column(name = "coverAdd")
	private String coverAdd;
	
	@Column(name = "layoutAdd")
	private String layoutAdd;
	
	@Column(name = "livingAdd1")
	private String livingAdd1;
	
	@Column(name = "livingNote1")
	private String livingNote1;
	
	@Column(name = "livingAdd2")
	private String livingAdd2;
	
	@Column(name = "livingNote2")
	private String livingNote2;
	
	@Column(name = "livingAdd3")
	private String livingAdd3;
	
	@Column(name = "livingNote3")
	private String livingNote3;
	
	@Column(name = "bedroomAdd1")
	private String bedroomAdd1;
	
	@Column(name = "bedroomNote1")
	private String bedroomNote1;
	
	@Column(name = "bedroomAdd2")
	private String bedroomAdd2;
	
	@Column(name = "bedroomNote2")
	private String bedroomNote2;
	
	@Column(name = "bedroomAdd3")
	private String bedroomAdd3;
	
	@Column(name = "bedroomNote3")
	private String bedroomNote3;
	
	@Column(name = "kitchenAdd1")
	private String kitchenAdd1;
	
	@Column(name = "kitchenNote1")
	private String kitchenNote1;
	
	@Column(name = "kitchenAdd2")
	private String kitchenAdd2;
	
	@Column(name = "kitchenNote2")
	private String kitchenNote2;
	
	@Column(name = "kitchenAdd3")
	private String kitchenAdd3;
	
	@Column(name = "kitchenNote3")
	private String kitchenNote3;
	
	@Column(name = "tioletAdd1")
	private String tioletAdd1;
	
	@Column(name = "tioletNote1")
	private String tioletNote1;
	
	@Column(name = "tioletAdd2")
	private String tioletAdd2;
	
	@Column(name = "tioletNote2")
	private String tioletNote2;
	
	@Column(name = "tioletAdd3")
	private String tioletAdd3;
	
	@Column(name = "tioletNote3")
	private String tioletNote3;
	
	@Column(name = "dinningAdd1")
	private String dinningAdd1;
	
	@Column(name = "dinningNote1")
	private String dinningNote1;
	
	@Column(name = "dinningAdd2")
	private String dinningAdd2;
	
	@Column(name = "dinningNote2")
	private String dinningNote2;
	
	@Column(name = "dinningAdd3")
	private String dinningAdd3;
	
	@Column(name = "dinningNote3")
	private String dinningNote3;
	
	@Column(name = "childAdd1")
	private String childAdd1;
	
	@Column(name = "childNote1")
	private String childNote1;
	
	@Column(name = "childAdd2")
	private String childAdd2;
	
	@Column(name = "childNote2")
	private String childNote2;
	
	@Column(name = "childAdd3")
	private String childAdd3;
	
	@Column(name = "childNote3")
	private String childNote3;
	
	@Column(name = "studyAdd1")
	private String studyAdd1;
	
	@Column(name = "studyNote1")
	private String studyNote1;
    
	@Column(name = "studyAdd2")
	private String studyAdd2;
	
	@Column(name = "studyNote2")
	private String studyNote2;
	
	@Column(name = "studyAdd3")
	private String studyAdd3;
	
	@Column(name = "studyNote3")
	private String studyNote3;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public String getLayoutAdd() {
		return layoutAdd;
	}

	public void setLayoutAdd(String layoutAdd) {
		this.layoutAdd = layoutAdd;
	}

	public String getLivingAdd1() {
		return livingAdd1;
	}

	public void setLivingAdd1(String livingAdd1) {
		this.livingAdd1 = livingAdd1;
	}

	public String getLivingNote1() {
		return livingNote1;
	}

	public void setLivingNote1(String livingNote1) {
		this.livingNote1 = livingNote1;
	}

	public String getLivingAdd2() {
		return livingAdd2;
	}

	public void setLivingAdd2(String livingAdd2) {
		this.livingAdd2 = livingAdd2;
	}

	public String getLivingNote2() {
		return livingNote2;
	}

	public void setLivingNote2(String livingNote2) {
		this.livingNote2 = livingNote2;
	}

	public String getLivingAdd3() {
		return livingAdd3;
	}

	public void setLivingAdd3(String livingAdd3) {
		this.livingAdd3 = livingAdd3;
	}

	public String getLivingNote3() {
		return livingNote3;
	}

	public void setLivingNote3(String livingNote3) {
		this.livingNote3 = livingNote3;
	}

	public String getBedroomAdd1() {
		return bedroomAdd1;
	}

	public void setBedroomAdd1(String bedroomAdd1) {
		this.bedroomAdd1 = bedroomAdd1;
	}

	public String getBedroomNote1() {
		return bedroomNote1;
	}

	public void setBedroomNote1(String bedroomNote1) {
		this.bedroomNote1 = bedroomNote1;
	}

	public String getBedroomAdd2() {
		return bedroomAdd2;
	}

	public void setBedroomAdd2(String bedroomAdd2) {
		this.bedroomAdd2 = bedroomAdd2;
	}

	public String getBedroomNote2() {
		return bedroomNote2;
	}

	public void setBedroomNote2(String bedroomNote2) {
		this.bedroomNote2 = bedroomNote2;
	}

	public String getBedroomAdd3() {
		return bedroomAdd3;
	}

	public void setBedroomAdd3(String bedroomAdd3) {
		this.bedroomAdd3 = bedroomAdd3;
	}

	public String getBedroomNote3() {
		return bedroomNote3;
	}

	public void setBedroomNote3(String bedroomNote3) {
		this.bedroomNote3 = bedroomNote3;
	}

	public String getKitchenAdd1() {
		return kitchenAdd1;
	}

	public void setKitchenAdd1(String kitchenAdd1) {
		this.kitchenAdd1 = kitchenAdd1;
	}

	public String getKitchenNote1() {
		return kitchenNote1;
	}

	public void setKitchenNote1(String kitchenNote1) {
		this.kitchenNote1 = kitchenNote1;
	}

	public String getKitchenAdd2() {
		return kitchenAdd2;
	}

	public void setKitchenAdd2(String kitchenAdd2) {
		this.kitchenAdd2 = kitchenAdd2;
	}

	public String getKitchenNote2() {
		return kitchenNote2;
	}

	public void setKitchenNote2(String kitchenNote2) {
		this.kitchenNote2 = kitchenNote2;
	}

	public String getKitchenAdd3() {
		return kitchenAdd3;
	}

	public void setKitchenAdd3(String kitchenAdd3) {
		this.kitchenAdd3 = kitchenAdd3;
	}

	public String getKitchenNote3() {
		return kitchenNote3;
	}

	public void setKitchenNote3(String kitchenNote3) {
		this.kitchenNote3 = kitchenNote3;
	}

	public String getTioletAdd1() {
		return tioletAdd1;
	}

	public void setTioletAdd1(String tioletAdd1) {
		this.tioletAdd1 = tioletAdd1;
	}

	public String getTioletNote1() {
		return tioletNote1;
	}

	public void setTioletNote1(String tioletNote1) {
		this.tioletNote1 = tioletNote1;
	}

	public String getTioletAdd2() {
		return tioletAdd2;
	}

	public void setTioletAdd2(String tioletAdd2) {
		this.tioletAdd2 = tioletAdd2;
	}

	public String getTioletNote2() {
		return tioletNote2;
	}

	public void setTioletNote2(String tioletNote2) {
		this.tioletNote2 = tioletNote2;
	}

	public String getTioletAdd3() {
		return tioletAdd3;
	}

	public void setTioletAdd3(String tioletAdd3) {
		this.tioletAdd3 = tioletAdd3;
	}

	public String getTioletNote3() {
		return tioletNote3;
	}

	public void setTioletNote3(String tioletNote3) {
		this.tioletNote3 = tioletNote3;
	}

	public String getDinningAdd1() {
		return dinningAdd1;
	}

	public void setDinningAdd1(String dinningAdd1) {
		this.dinningAdd1 = dinningAdd1;
	}

	public String getDinningNote1() {
		return dinningNote1;
	}

	public void setDinningNote1(String dinningNote1) {
		this.dinningNote1 = dinningNote1;
	}

	public String getDinningAdd2() {
		return dinningAdd2;
	}

	public void setDinningAdd2(String dinningAdd2) {
		this.dinningAdd2 = dinningAdd2;
	}

	public String getDinningNote2() {
		return dinningNote2;
	}

	public void setDinningNote2(String dinningNote2) {
		this.dinningNote2 = dinningNote2;
	}

	public String getDinningAdd3() {
		return dinningAdd3;
	}

	public void setDinningAdd3(String dinningAdd3) {
		this.dinningAdd3 = dinningAdd3;
	}

	public String getDinningNote3() {
		return dinningNote3;
	}

	public void setDinningNote3(String dinningNote3) {
		this.dinningNote3 = dinningNote3;
	}

	public String getChildAdd1() {
		return childAdd1;
	}

	public void setChildAdd1(String childAdd1) {
		this.childAdd1 = childAdd1;
	}

	public String getChildNote1() {
		return childNote1;
	}

	public void setChildNote1(String childNote1) {
		this.childNote1 = childNote1;
	}

	public String getChildAdd2() {
		return childAdd2;
	}

	public void setChildAdd2(String childAdd2) {
		this.childAdd2 = childAdd2;
	}

	public String getChildNote2() {
		return childNote2;
	}

	public void setChildNote2(String childNote2) {
		this.childNote2 = childNote2;
	}

	public String getChildAdd3() {
		return childAdd3;
	}

	public void setChildAdd3(String childAdd3) {
		this.childAdd3 = childAdd3;
	}

	public String getChildNote3() {
		return childNote3;
	}

	public void setChildNote3(String childNote3) {
		this.childNote3 = childNote3;
	}

	public String getStudyAdd1() {
		return studyAdd1;
	}

	public void setStudyAdd1(String studyAdd1) {
		this.studyAdd1 = studyAdd1;
	}

	public String getStudyNote1() {
		return studyNote1;
	}

	public void setStudyNote1(String studyNote1) {
		this.studyNote1 = studyNote1;
	}

	public String getStudyAdd2() {
		return studyAdd2;
	}

	public void setStudyAdd2(String studyAdd2) {
		this.studyAdd2 = studyAdd2;
	}

	public String getStudyNote2() {
		return studyNote2;
	}

	public void setStudyNote2(String studyNote2) {
		this.studyNote2 = studyNote2;
	}

	public String getStudyAdd3() {
		return studyAdd3;
	}

	public void setStudyAdd3(String studyAdd3) {
		this.studyAdd3 = studyAdd3;
	}

	public String getStudyNote3() {
		return studyNote3;
	}

	public void setStudyNote3(String studyNote3) {
		this.studyNote3 = studyNote3;
	}
	
}
