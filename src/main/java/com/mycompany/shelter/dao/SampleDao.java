package com.mycompany.shelter.dao;

import java.util.List;

import com.mycompany.shelter.dao.base.BaseDao;
import com.mycompany.shelter.entity.Sample;

public interface SampleDao extends BaseDao<Sample>{
	
	public List<Sample> findAll();
	
	public List<Sample> findTop4();
	
//	public Sample findById(String id);

}
