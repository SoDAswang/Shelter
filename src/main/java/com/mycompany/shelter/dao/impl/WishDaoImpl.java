package com.mycompany.shelter.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.objectweb.asm.Handle;
import org.springframework.stereotype.Repository;

import com.mycompany.shelter.dao.WishDao;
import com.mycompany.shelter.dao.base.BaseDao;
import com.mycompany.shelter.dao.base.BaseDaoImpl;
import com.mycompany.shelter.entity.Wish;

@Repository("WishDao")
public class WishDaoImpl extends BaseDaoImpl<Wish> implements WishDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Wish> findByCustomerId(String customerId) {
		StringBuffer hql = new StringBuffer();
		hql.append("from Wish where 1 = ? ");
		hql.append("and customerId = ?");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, customerId);
		
		return query.list();
	}

	@Override
	public List<Object[]> findWishByCustomerId(String customerId) {
		StringBuffer hql = new StringBuffer();
		hql.append("select s.coverAdd, s.id, s.title, w.subject, w.id from Sample s, Wish w where 1= ? ");
		//                   0           1     2        3          4  
		hql.append("and w.customerId = ? ");
		hql.append("and w.sampleId = s.id");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, customerId);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public int ifExisted(String customerId, String sampleId, String subject) {
		StringBuffer hql = new StringBuffer();
		hql.append("from Wish where 1 = ? ");
		hql.append("and customerId = ? ");
		hql.append("and sampleId = ? ");
		hql.append("and subject = ?");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, customerId);
		query.setString(2, sampleId);
		query.setString(3, subject);
		List<Wish> list = query.list();
				
		return list.size();
	}
	
	@Override
	public int saveWish(Wish wish) {
		this.save(wish);
		String customerId = wish.getCustomerId();
		String sampleId = wish.getSampleId();
		String subject = wish.getSubject();
		StringBuffer hql = new StringBuffer();
		hql.append("from Wish where 1 = ? ");
		hql.append("and customerId = ? ");
		hql.append("and sampleId = ? ");
		hql.append("and subject = ?");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, customerId);
		query.setString(2, sampleId);
		query.setString(3, subject);
		
		List<Wish> list =query.list();
		
		return list.get(0).getId();
	}
	
}
