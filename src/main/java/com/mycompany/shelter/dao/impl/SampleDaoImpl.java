package com.mycompany.shelter.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.mycompany.shelter.dao.SampleDao;
import com.mycompany.shelter.dao.base.BaseDaoImpl;
import com.mycompany.shelter.entity.Sample;

import net.sf.ehcache.search.expression.And;

@Repository("SampleDao")
public class SampleDaoImpl extends BaseDaoImpl<Sample> implements SampleDao {
	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public List<Sample> findAll() {
		String hql = "from Sample";
        List<Sample> samples = this.findAllByHQL(hql);
        
		return samples;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sample> findTop4() {
		Session session = sessionFactory.openSession();
		String hql = "from Sample order by id desc";
        Query query = session.createQuery(hql);
        query.setMaxResults(4); 
		List<Sample> samples = query.list();
		
		return samples;
	}

//	@Override
//	public Sample findById(String id) {
//		Sample sample = this.findById(id);
//		return sample;
//	}

}
