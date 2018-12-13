package com.mycompany.shelter.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mycompany.shelter.dao.iUserDao;
import com.mycompany.shelter.dao.base.BaseDaoImpl;
import com.mycompany.shelter.entity.iUser;



@Repository("iUserDao")
public class iUserDaoImpl extends BaseDaoImpl<iUser> implements iUserDao{
	 @Override
	public List<iUser> findall(){
		 
		 String hql="from iUser";      	    
		 List<iUser> iuser=this.findAllByHQL(hql);		 
		 return iuser;
	 }
	 
	 @Override
		public List<iUser> getpwd(String username){
	    	StringBuffer sql=new StringBuffer();
	    	sql.append("from iUser where 1=? ");
	    	sql.append(" and username =? ");		
	    	 Query query = this.getSession().createQuery(sql.toString());
	    	 query.setString(0, "1");
	    	 query.setString(1,username);
	     	return query.list();
	    }
}
