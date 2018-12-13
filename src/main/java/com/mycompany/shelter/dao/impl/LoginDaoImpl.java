package com.mycompany.shelter.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mycompany.shelter.dao.LoginDao;
import com.mycompany.shelter.dao.base.BaseDaoImpl;
import com.mycompany.shelter.entity.Login;

@Repository("loginDao")
public class LoginDaoImpl extends BaseDaoImpl<Login> implements LoginDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Login> findPasswordByUsername(String username) {
		StringBuffer hql = new StringBuffer();
		hql.append("from Login where 1 = ? ");
		hql.append("and username = ?");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, username);

		return query.list();
	}

	
}
