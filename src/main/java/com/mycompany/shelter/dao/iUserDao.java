package com.mycompany.shelter.dao;

import java.util.List;

import com.mycompany.shelter.dao.base.BaseDao;
import com.mycompany.shelter.entity.iUser;



public interface iUserDao extends BaseDao<iUser>{
	
	 public List<iUser> findall();
	 
	 public List<iUser> getpwd(String username);
	 
//	 public 



}
