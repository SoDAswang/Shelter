package com.mycompany.shelter.dao;

import java.util.List;


import com.mycompany.shelter.entity.Material;
import com.mycompany.shelter.entity.SampleMaterial;

public interface SampleDetailDao {
		
//	public List<SampleMaterial> findBySampleIdAndSubject(String sampleId, String subject);
	
//	@SuppressWarnings("rawtypes")
//	public List findSampleDetailBySampleIdAndSubject(String sampleId, String subject);
//	
//	public List<String> findAllSubjects(String sampleId);
	
	// Find all kind of subjects with the same sampleId.
	public List<String> findAllSubjectsUseMaterial(String sampleId);
	
	public List<String> findAllSubjectsUseFurniture(String sampleId);
	
	// Find materials used in defined subject by sampleId and subject name.
	public List<Object[]> findMaterilBySampleIdAndSubject(String sampleId, String subject);
	
	public List<Object[]> findFurnitureBySampleIdAndSubject(String sampleId, String subject);

	public List<Object[]> findMaterialBySampleIdAndSubjectAndLocation(String sampleId, String subject, String location);
    
	public List<Object[]> findDistinctMaterialBySampleIdAndSubjectAndLocation(String sampleId, String subject, String location);

	public List<String> findColorByMaterialIdFromSampleMaterial(String MaterialId);
	
	public List<String> findColorBySampleIdAndSubjectAndMaterialId(String sampleId, String subject, String materialId);
	
	public String findSampleMaterialIdBySampleIdAndSubjectAndMaterialIdAndColor(String sampleId, String subject, String materialId, String color);;
}
