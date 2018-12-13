package com.mycompany.shelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.shelter.dao.FavoriteDao;
import com.mycompany.shelter.entity.Favorite;
import com.mycompany.shelter.entity.Material;

@Service
public class FavoriteService {
	@Autowired
	FavoriteDao favoriteDao;
	
	public void save(Favorite favorite) {
		favoriteDao.save(favorite);
	}
	
	public void deleteById(String favoriteId) {
		favoriteDao.delete(favoriteId);
	}
	
	public int deleteByCustomerIdAndMaterialId(String customerId, String materialId) {
		return favoriteDao.deleteByCustomerIdAndMaterialId(customerId, materialId);
	}

	public int ifExisted(String customerId, String materialid) {
		return favoriteDao.ifExisted(customerId, materialid);
	}
	
	public List<Object[]> findMaterialsByCustomerId(String customerId) {
		return favoriteDao.findMaterialsByCustomerId(customerId);
	}
	
}
