package com.mycompany.shelter.dao;

import java.util.List;

import com.mycompany.shelter.dao.base.BaseDao;
import com.mycompany.shelter.entity.Material;

public interface MaterialDao extends BaseDao<Material>{
	
	public List<Material> findAll();
	
	public List<Object[]> findAllMaterials();
	
//	public List findDetails();
	
	public List<Material> findByClass(String style, String texture, String fit, String price);
	
	public List<Material> findByStyle(String style);

}
