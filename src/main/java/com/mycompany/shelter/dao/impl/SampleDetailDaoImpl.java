package com.mycompany.shelter.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.shelter.dao.SampleDetailDao;
import com.mycompany.shelter.dao.base.BaseDaoImpl;
import com.mycompany.shelter.entity.SampleMaterial;

@Repository("SampleDetailDao")
public class SampleDetailDaoImpl extends BaseDaoImpl<SampleMaterial> implements SampleDetailDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllSubjectsUseMaterial(String sampleId) {
		StringBuffer hql = new StringBuffer();
		hql.append("select subject from SampleMaterial where 1= ? ");
		hql.append("and sampleId = ? ");
		hql.append("group by subject having count(*)>=1");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, sampleId);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllSubjectsUseFurniture(String sampleId) {
		StringBuffer hql = new StringBuffer();
		hql.append("select subject from SampleFurniture where 1= ? ");
		hql.append("and sampleId = ? ");
		hql.append("group by subject having count(*)>=1");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, sampleId);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findMaterilBySampleIdAndSubject(String sampleId, String subject) {
		StringBuffer hql = new StringBuffer();
		hql.append("select m.id, m.typeId, m.type, m.title, m.price, m.brand, m.texture, m.style, m.fit, m.inventory, m.label, m.coverAdd, m.note, m.length, m.width, m.location, CONCAT('颜色：', sm.color), sm.id , m.weight, m.areaPerWeight from SampleMaterial sm, Material m where 1 = ? ");
		//                   0     1         2       3        4        5        6          7        8      9            10       11          12      13        14       15               16                    17     18        19
		hql.append("and sm.sampleId = ? ");
		hql.append("and sm.subject = ? ");
		hql.append("and sm.materialId = m.id");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, sampleId);
		query.setString(2, subject);
		
        return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findFurnitureBySampleIdAndSubject(String sampleId, String subject) {
		StringBuffer hql = new StringBuffer();
		hql.append("select f.id, f.typeId, f.type, f.title, f.price, f.brand, f.classify, f.style, f.inventory, f.label, f.coverAdd, f.note from SampleFurniture sf, Furniture f where 1 = ? ");
		hql.append("and sf.sampleId = ? ");
		hql.append("and sf.subject = ? ");
		hql.append("and sf.furnitureId = f.id");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, sampleId);
		query.setString(2, subject);
		
        return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findMaterialBySampleIdAndSubjectAndLocation(String sampleId, String subject,
			String location) {
		StringBuffer hql = new StringBuffer();
		hql.append("select m.id, m.typeId, m.type, m.title, m.price, m.brand, m.texture,"
		//                   0     1         2       3        4        5        6          
				+ " m.style, m.fit, m.inventory, m.label, m.coverAdd, m.note, m.length, "
        //            7        8      9            10       11          12      13        
				+ "m.width , m.location , sm.color , sm.id from SampleMaterial sm, Material m where 1 = ?");
		//           14       15             16         17
		hql.append("and sm.id = ? ");
		hql.append("and sm.subject = ? ");
		hql.append("and m.location = ? ");
		hql.append("and sm.materialId = m.id");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, sampleId);
		query.setString(2, subject);
		query.setString(3, location);
		
        return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findDistinctMaterialBySampleIdAndSubjectAndLocation(String sampleId, String subject,
			String location) {
        StringBuffer hql = new StringBuffer();
//        SELECT distinct m.id, m.coverAdd FROM shelterdb.sample_material sm, shelterdb.material m where sm.sampleId = '1' and sm.subject = '客厅' and sm.materialId = m.id;
        hql.append("select distinct m.id, m.coverAdd, m.title from SampleMaterial sm, Material m where 1 = ? ");
        //                            0     1           2
        hql.append("and sm.sampleId = ? ");
        hql.append("and sm.subject = ? ");
        hql.append("and m.location = ? ");
        hql.append("and sm.materialId = m.id");
        Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, sampleId);
		query.setString(2, subject);
		query.setString(3, location);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findColorBySampleIdAndSubjectAndMaterialId(String sampleId, String subject, String materialId) {
        StringBuffer hql = new StringBuffer();
        hql.append("select color from SampleMaterial where 1 = ? ");
        hql.append("and sampleId = ? ");
        hql.append("and subject = ? ");
        hql.append("and materialId = ?");
        Query query = this.getSession().createQuery(hql.toString());
        query.setString(0, "1");
		query.setString(1, sampleId);
		query.setString(2, subject);
		query.setString(3, materialId);
		
		return query.list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String findSampleMaterialIdBySampleIdAndSubjectAndMaterialIdAndColor(String sampleId, String subject,
			String materialId, String color) {
		StringBuffer hql = new StringBuffer();
		hql.append("select id from SampleMaterial where 1= ? ");
		hql.append("and sampleId = ? ");
		hql.append("and subject = ? ");
		hql.append("and materialId = ? ");
		hql.append("and color = ?");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, sampleId);
		query.setString(2, subject);
		query.setString(3, materialId);
		query.setString(4, color);

		List list = query.list();
		return list.get(0).toString();
	}

	@Override
	public List<String> findColorByMaterialIdFromSampleMaterial(String materialId) {
		StringBuffer hql = new StringBuffer();
		hql.append("select distinct color from SampleMaterial where 1 = ? ");
		hql.append("and materialId = ?");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, materialId);
		
		return query.list();
	}
	
}
