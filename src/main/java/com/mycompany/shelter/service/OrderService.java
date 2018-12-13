package com.mycompany.shelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.shelter.dao.OrderGoodsDao;
import com.mycompany.shelter.entity.OrderGoods;

@Service
public class OrderService {
	@Autowired
	OrderGoodsDao orderGoodsDao;
	
	public void save (OrderGoods orderGoods) {
		orderGoodsDao.save(orderGoods);
	}
	
	// Materials in table(order_goods) comes from table(sample_material).
	public int saveOrderGoods (String wishId) {
		return orderGoodsDao.saveOrderGoods(wishId);
	}
	
	public List<Object[]> findMaterialByWishId (String wishId) {
		return orderGoodsDao.findMaterialByWishId(wishId);
	}
	
	public List<Object[]> findDistinctMaterialByWishIdAndLocation (String wishId, String location) {
		return orderGoodsDao.findDistinctMaterialByWishIdAndLocation(wishId, location);
	}
	
	public List<String> findColorByWishIdAndMaterialId (String wishId, String materialId) {
		return orderGoodsDao.findColorByWishIdAndMaterialId(wishId, materialId);
	}
	
	public String findOrderGoodsIdByWishIdAndMaterialIdAndColor (String wishId, String materialId, String color) {
		return orderGoodsDao.findOrderGoodsIdByWishIdAndMaterialIdAndColor(wishId, materialId, color);
	}
	
	public List<Object[]> findMaterialByWishIdAndLocation (String wishId, String location) {
		return orderGoodsDao.findMaterialByWishIdAndLocation(wishId, location);
	}
	
	public int deleteByWishId (String wishId) {
		return orderGoodsDao.deleteByWishId(wishId);
	}
	
	// Restore the materials in table(oreder_goods) to original as materials listed in table(sample_material).
	public int restoreOrderGoodsByWishId (String wishId) {
		orderGoodsDao.deleteByWishId(wishId);
		return orderGoodsDao.saveOrderGoods(wishId);
	}
	
	public void deleteByOrderGoodsId (String orderGoodsId) {
		int id = Integer.parseInt(orderGoodsId);
		orderGoodsDao.delete(id);
	}
	
	public OrderGoods findByOrderGoodsId(String orderGoodsId) {
		return orderGoodsDao.findById(Integer.parseInt(orderGoodsId));
	}
	
	public int updateColorByOrderGoodsId(String orderGoodsId, String color) {
		return orderGoodsDao.updateColorByOrderGoodsId(orderGoodsId, color);
	}

}
