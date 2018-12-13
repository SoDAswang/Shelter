package com.mycompany.shelter.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.shelter.dao.MaterialDao;
import com.mycompany.shelter.dao.base.BaseDaoImpl;
import com.mycompany.shelter.entity.Material;

@Repository("materialDao")
public class MaterialDaoImpl extends BaseDaoImpl<Material> implements MaterialDao{
    @Resource  
    private SessionFactory sessionFactory;  
    
	@Override
	public List<Material> findAll() {
		String hql = "from Material";
		List<Material> materials = this.findAllByHQL(hql);
		return materials;
	}
	
//	@Override
//	public List findDetails() {
//    	Session session = sessionFactory.openSession();
//		String hql = "select title, price, brand, texture, fit, style, address from Material";
//	    Query query = session.createQuery(hql);  
//		List details = query.list();
//		return details;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Material> findByStyle(String style) {
		StringBuffer hql = new StringBuffer();
		hql.append("from Material where 1 = ? ");
		hql.append("and style = ?");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, style);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Material> findByClass(String style, String texture, String fit, String price) {
		int i = 1;
		StringBuffer hql = new StringBuffer();
		hql.append("from Material where 1 = ? ");
		if (style != null) {
			hql.append("and style = ? ");
		}
		if (texture != null) {
			hql.append("and texture = ? ");
		}
		if (fit != null) {
			hql.append("and fit = ? ");
		}
		if (price != null) {
			hql.append("and price = ?");
		}
		
		Query query = this.getSession().createQuery(hql.toString());
		
		query.setString(0, "1");
		if (style != null) {
			query.setString(i++, style);
		}
		if (texture != null) {
			query.setString(i++, texture);
		}
		if (fit != null) {
			query.setString(i++, fit);
		}
		if (price != null) {
			query.setString(i++, price);
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findAllMaterials() {
		String hql = "select id, typeId, type, title, price, brand, texture, style, fit, inventory, label, "
//				             0   1       2     3      4      5      6        7      8    9          10
				+ "coverAdd, note, classify, location, length, width, weight, areaPerWeight, use from Material";
//		           11        12    13        14        15      16     17      18             19
		Query query = this.getSession().createQuery(hql);
		
		return query.list();
	}
	
}
