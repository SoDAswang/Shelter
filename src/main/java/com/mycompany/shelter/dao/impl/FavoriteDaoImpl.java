package com.mycompany.shelter.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mycompany.shelter.dao.FavoriteDao;
import com.mycompany.shelter.dao.base.BaseDaoImpl;
import com.mycompany.shelter.entity.Favorite;
import com.mycompany.shelter.entity.Material;

@Repository("FavoriteDao")
public class FavoriteDaoImpl extends BaseDaoImpl<Favorite> implements FavoriteDao{

	@SuppressWarnings("unchecked")
	@Override
	public int ifExisted(String customerId, String materialId) {
		StringBuffer hql = new StringBuffer();
		hql.append("from Favorite where 1 = ? ");
		hql.append("and customerId = ? ");
		hql.append("and materialId = ?");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, customerId);
		query.setString(2, materialId);
		List<Favorite> list = query.list();
		
		return list.size();
	}

	@Override
	public int deleteByCustomerIdAndMaterialId(String customerId, String materialId) {
		StringBuffer hql = new StringBuffer();
		hql.append("delete from Favorite where 1 = ? ");
		hql.append("and customerId = ? ");
		hql.append("and materialId = ?");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, customerId);
		query.setString(2, materialId);
		
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findMaterialsByCustomerId(String customerId) {
		StringBuffer hql = new StringBuffer();
		hql.append("select m.id, m.typeId, m.type, m.title, m.price, m.brand, m.texture, m.style, m.fit, m.inventory, m.label, ");
//                           0     1         2       3        4        5        6          7        8      9		    10
		hql.append("m.coverAdd, m.note, m.classify, m.location, m.length, m.width, m.weight, m.areaPerWeight, m.use ");
//	                  11          12      13          14          15        16       17        18               19
		hql.append("from Material m, Favorite f where 1 = ? ");
		hql.append("and f.customerId = ? ");
		hql.append("and m.id = f.materialId");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, customerId);
		
		return query.list();
	}
	
	

}
