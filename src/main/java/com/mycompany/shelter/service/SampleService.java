package com.mycompany.shelter.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicInterface2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.mycompany.shelter.dao.SampleDao;
import com.mycompany.shelter.dao.SampleDetailDao;
import com.mycompany.shelter.entity.Material;
import com.mycompany.shelter.entity.Sample;
import com.mycompany.shelter.entity.SampleMaterial;

@Service
public class SampleService {
	@Autowired
	SampleDao sampleDao;

	@Autowired
	SampleDetailDao sampleDetailDao;

	public List<Sample> findAll() {
		return sampleDao.findAll();
	}

	public List<Sample> findTop4() {
		return sampleDao.findTop4();
	}

	public Sample findById(String id) {
		return sampleDao.findById(id);
	}

	public List<String> findAllSubjects(String id) {
		List<String> subjectsUseMaterial = sampleDetailDao.findAllSubjectsUseMaterial(id);
		List<String> subjectsUseFurniture = sampleDetailDao.findAllSubjectsUseFurniture(id);
		List<String> list = subjectsUseMaterial;
		
		for (String subUseFurniture : subjectsUseFurniture) {
			if (list.contains(subUseFurniture)) {
				break;
			} else {
				list.add(subUseFurniture);
			}
		}
		return list;
	}
	
	public List<Object[]> findMaterilBySampleIdAndSubject(String id, String subject) {
		List<Object[]> list = sampleDetailDao.findMaterilBySampleIdAndSubject(id, subject);
		for (Object[] material : list) {
			// type 是地板
			if (material[1].equals("1")) {
				material[12] = "长：" + material[13] + "米   宽：" + material[14] + "米   销售单位：平方米";
			}
			// type 是瓷砖
			if (material[1].equals("2")) {
				material[12] = "长：" + material[13] + "米   宽：" + material[14] + "米   销售单位：块";
			}
			// type 是涂料
			if (material[1].equals("3")) {
				material[12] = "净重：" + material[18] + "千克   每千克可粉刷墙面：" + material[19] + "  销售单位：桶";
			}
		}
		return list;
	}
	
	public List<Object[]> findFurnitureBySampleIdAndSubject(String id, String subject) {
		List<Object[]> list = sampleDetailDao.findFurnitureBySampleIdAndSubject(id, subject);
		return list;
	}
	
	public List<Object[]> findDistinctMaterialBySampleIdAndSubjectAndLocation(String sampleId, String subject, String location) {
		return sampleDetailDao.findDistinctMaterialBySampleIdAndSubjectAndLocation(sampleId, subject, location);
	}

	public List<Object[]> findMaterialBySampleIdAndSubjectAndLocation (String sampleId, String subject, String location) {
		return sampleDetailDao.findMaterialBySampleIdAndSubjectAndLocation(sampleId, subject, location);
	}
			
	public String findSampleMaterialIdBySampleIdAndSubjectAndMaterialIdAndColor (String sampleId, String subject,
			String materialId, String color) {
		return sampleDetailDao.findSampleMaterialIdBySampleIdAndSubjectAndMaterialIdAndColor(sampleId, subject, materialId, color);
	}
	
	public List<String> findColorByMaterialIdFromSampleMaterial(String materialId) {
		return sampleDetailDao.findColorByMaterialIdFromSampleMaterial(materialId);
	}

}
