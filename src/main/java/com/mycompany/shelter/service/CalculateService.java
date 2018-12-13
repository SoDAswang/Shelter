package com.mycompany.shelter.service;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.shelter.dao.SampleDetailDao;
import com.mycompany.shelter.entity.Material;

@Service
public class CalculateService {
	
	@Autowired
	SampleDetailDao sampleDetailDao;
	
	@Autowired
	WishService wishService;
	
	@Autowired
	MaterialService materialService;
	
	@Autowired
	SampleService sampleService;
	
	@Autowired
	OrderService orderService;
	
	// 计算瓷砖（单位：片）
	public int calculateTile(String square, String length, String width) {
		double s = Double.parseDouble(square);
		double w = Double.parseDouble(width);
		double l = Double.parseDouble(length);
		int result = (int) (s/(w*l));
		if (s-(w*l*result) > 0) {
			result ++;
		}
		return result;
	}
	
	// 计算（木）地板（单位：平方米）
	public int calculateWood(String square) {
		double s_double = Double.parseDouble(square);
		int s_int = (int)(Double.parseDouble(square));
		int result = s_int;
		if (s_double > s_int) {
			result ++;
		}
		return result;		
	}
	
	public int calculateFloorAmount(String square, String wishId) {
		int result = 1;
		List<Object[]> materials = wishService.findMaterialByWishId(Integer.parseInt(wishId));
		for (Object[] m : materials) {
			String typeId = (String) m[1];
			String length = (String) m[13];
			String width = (String) m[14];
			// "1"(（木）地板)
			if (typeId.equals("1")) {
				result =  calculateWood(square);
			}
			// "2"(瓷砖)
			if (typeId.equals("2")) {
				result = calculateTile(square, length, width);
			}
		}
		return result;
	}
	
    public String[][] calculateWallAmount(String[][] wallInfo, String wishId) {
    	String[][] wallAmouts = new String[wallInfo.length][2];
    	for (int i=0; i<wallInfo.length; i++) {
    		String materialId = wallInfo[i][0];
    		Material material = materialService.findByMaterialId(materialId);
    		Double weight = Double.parseDouble(material.getWeight());
    		Double areaPerWeight = Double.parseDouble(material.getAreaPerWeight());
    		Double maxUasge = weight * areaPerWeight;
    		String color = wallInfo[i][1];
    		Double square = Double.parseDouble(wallInfo[i][2]);
    		int amount = (int)(square / maxUasge);
    		if (square % maxUasge > 0) {
    			amount ++;
    		}
    		wallAmouts[i][0] = "amount_" + orderService.findOrderGoodsIdByWishIdAndMaterialIdAndColor(wishId, materialId, color);
    		wallAmouts[i][1] = amount + "";
    	}
    	return wallAmouts;
    }

}
