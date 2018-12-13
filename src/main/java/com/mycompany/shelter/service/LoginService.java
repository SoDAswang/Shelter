package com.mycompany.shelter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.shelter.dao.LoginDao;
import com.mycompany.shelter.entity.Login;

@Service
public class LoginService {

	@Autowired
	LoginDao loginDao;
	
	public List<Login> findPasswordByUsername(String username) {
		return loginDao.findPasswordByUsername(username);
	}
	
	public void save(Login login) {
		loginDao.save(login);
	}
}
