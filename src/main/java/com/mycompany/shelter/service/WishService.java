package com.mycompany.shelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.shelter.dao.SampleDetailDao;
import com.mycompany.shelter.dao.WishDao;
import com.mycompany.shelter.entity.Wish;

@Service
public class WishService {
	
	@Autowired
	WishDao wishDao;
	
	@Autowired
	SampleDetailDao sampleDetailDao;
	
	public List<Wish> findByCustomerId(String customerId) {
		return wishDao.findByCustomerId(customerId);
	}
	
	public void save(Wish wish) {
		wishDao.save(wish);
	}
	
	public int saveWish(Wish wish) {
		return wishDao.saveWish(wish);
	}
	
	public List<Object[]> findMaterialByCustomerId(String customerId) {
		List<Wish> wishes = wishDao.findByCustomerId(customerId);
		String sampleId = wishes.get(0).getSampleId();
		String subject = wishes.get(0).getSubject();
		
		return sampleDetailDao.findMaterilBySampleIdAndSubject(sampleId, subject);
	}
	
	public List<Object[]> findFurnitureByCustomerId(String customerId) {
		List<Wish> wishes = wishDao.findByCustomerId(customerId);
		String sampleId = wishes.get(0).getSampleId();
		String subject = wishes.get(0).getSubject();
		
		return sampleDetailDao.findFurnitureBySampleIdAndSubject(sampleId, subject);
	}
	
	public List<Object[]> findWishByCustomerId(String customerId) {
		return wishDao.findWishByCustomerId(customerId);
	}
	
	// find wish by wishId
	public Wish findByWishId(Integer wishId) {
		return wishDao.findById(wishId);
	}
	
	public List<Object[]> findMaterialByWishId(Integer wishId) {
		String sampleId = findByWishId(wishId).getSampleId();
		String subject = findByWishId(wishId).getSubject();
		return sampleDetailDao.findMaterilBySampleIdAndSubject(sampleId, subject);
	}
		
	public List<Object[]> findMaterialByWishIdAndLocation(Integer wishId, String location) {
		String sampleId = findByWishId(wishId).getSampleId();
		String subject = findByWishId(wishId).getSubject();
		return sampleDetailDao.findMaterialBySampleIdAndSubjectAndLocation(sampleId, subject, location);
	}
	
	public List<String> findColorByWishIdAndMaterialId(Integer wishId, String materialId) {
		String sampleId = findByWishId(wishId).getSampleId();
		String subject = findByWishId(wishId).getSubject();
		return sampleDetailDao.findColorBySampleIdAndSubjectAndMaterialId(sampleId, subject, materialId);
	}
	
	public List<Object[]> findDistinctMaterialByWishIdAndLocation(Integer wishId, String location) {
		String sampleId = findByWishId(wishId).getSampleId();
		String subject = findByWishId(wishId).getSubject();
		return sampleDetailDao.findDistinctMaterialBySampleIdAndSubjectAndLocation(sampleId, subject, "墙面");
	}
	
	public int ifExistsWish(String customerId, String sampleId, String subject) {
		return wishDao.ifExisted(customerId, sampleId, subject);
	}
	
	public void deleteById(int id) {
		wishDao.delete(id);
	}
		
	public String findSampleMaterialIdByWishIdAndMaterialIdAndColor (Integer wishId, String materialId, String color) {
		String sampleId = findByWishId(wishId).getSampleId();
		String subject = findByWishId(wishId).getSubject();
		return sampleDetailDao.findSampleMaterialIdBySampleIdAndSubjectAndMaterialIdAndColor(sampleId, subject, materialId, color);
	}
}
