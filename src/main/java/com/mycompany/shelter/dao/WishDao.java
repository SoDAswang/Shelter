package com.mycompany.shelter.dao;

import java.util.List;

import com.mycompany.shelter.dao.base.BaseDao;
import com.mycompany.shelter.entity.Wish;

public interface WishDao extends BaseDao<Wish> {
	
	public List<Wish> findByCustomerId(String customerId);
	
	public List<Object[]> findWishByCustomerId(String customerId);
	
	public int ifExisted(String customerId, String sampleId, String subject);
	
	public int saveWish(Wish wish);
				
}
