package com.mycompany.shelter.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import com.mycompany.shelter.dao.MaterialDao;
import com.mycompany.shelter.entity.Material;

@Service
public class MaterialService {
	@Autowired
	MaterialDao materialDao;
	
	@Autowired
	FavoriteService favoriteService;
	
	public List<Material> findAll() {
		return materialDao.findAll();
	}
	
	public List<Object[]> findAllMaterials() {
		return materialDao.findAllMaterials();
	};

	
	public List<Object[]> findAllAndFavor(String customerId) {
		List<Object[]> list = this.findAllMaterials();
		if (customerId == null) {
			for (int i =0; i<list.size(); i++) {
				Object[] objects = list.get(i);
				objects = Arrays.copyOf(objects, objects.length+1); // Expand the original array by plus length 1, in order to add Class.
				objects[objects.length-1] = "glyphicon glyphicon-star-empty";
				list.set(i, objects);
			}
		} else {
			for (int i =0; i<list.size(); i++) {
				Object[] objects = list.get(i);
				objects = Arrays.copyOf(objects, objects.length+1); // Expand the original array by plus length 1, in order to add Class.
				String materialId = (String) objects[0]; 
				objects[objects.length-1] = 
						favoriteService.ifExisted(customerId, materialId) > 0 ? "glyphicon glyphicon-star" : "glyphicon glyphicon-star-empty";
				list.set(i, objects);
			}
		}
		return list;
	}
	
//	public List findDetails() {
//		return materialDao.findDetails();
//	}
	
    public List<Material> findByClass(String style, String texture, String fit, String price) {
		return materialDao.findByClass(style, texture, fit, price);
	}
	
	public List<Material> findByStyle(String style) {
		return materialDao.findByStyle(style);
	}
	
	public Material findByMaterialId(String materialId) {
		return materialDao.findById(materialId);
	}
	
	
}
