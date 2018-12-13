package com.mycompany.shelter.dao;

import java.util.List;

import com.mycompany.shelter.dao.base.BaseDao;
import com.mycompany.shelter.entity.Login;

public interface LoginDao extends BaseDao<Login> {

	public List<Login> findPasswordByUsername(String username);
	
}
