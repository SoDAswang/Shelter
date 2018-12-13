package com.mycompany.shelter.dao;

import java.util.List;

import com.mycompany.shelter.dao.base.BaseDao;
import com.mycompany.shelter.entity.Favorite;
import com.mycompany.shelter.entity.Material;

public interface FavoriteDao extends BaseDao<Favorite>{

	public int ifExisted(String customerId, String materialid);
	
	public int deleteByCustomerIdAndMaterialId(String customerId, String materialId);
	
	public List<Object[]> findMaterialsByCustomerId(String customerId);
}
