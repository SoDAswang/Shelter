package com.mycompany.shelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.shelter.entity.iUser;
import com.mycompany.shelter.dao.iUserDao;;


@Service
public class iUserService {
	@Autowired
	iUserDao iUserDao;
	public List<iUser> findall(){
        return iUserDao.findall();
    }
	public List<iUser> getpwd(String username){
        return iUserDao.getpwd(username);
    }
	
	public void save(iUser iuser) {
		iUserDao.save(iuser);
	}
	
//	public String findPhoneByCustomer(String username) {
//		List<iUser> list=getpwd(username);
//		String phone=list.get(0).get
//	}
}
