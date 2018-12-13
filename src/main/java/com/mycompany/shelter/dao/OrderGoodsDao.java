package com.mycompany.shelter.dao;

import java.util.List;

import com.mycompany.shelter.dao.base.BaseDao;
import com.mycompany.shelter.entity.OrderGoods;

public interface OrderGoodsDao extends BaseDao<OrderGoods>{
	public int saveOrderGoods(String wishId);
	
	public List<Object[]> findMaterialByWishId(String wishId);
	
	public List<Object[]> findDistinctMaterialByWishIdAndLocation (String wishId, String location);
	
	public List<String> findColorByWishIdAndMaterialId (String wishId, String materialId);
	
	public String findOrderGoodsIdByWishIdAndMaterialIdAndColor(String wishId, String materialId, String color);
	
	public List<Object[]> findMaterialByWishIdAndLocation(String wishId, String location);
	
	public int deleteByWishId(String wishId);
		
	public int updateColorByOrderGoodsId(String orderGoodsId, String color);
}
