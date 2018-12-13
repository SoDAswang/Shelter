package com.mycompany.shelter.dao.base;

import java.io.Serializable;  
import java.util.List;  
  
/** 
 * BaseDAO ����DAO��ͨ�ò��� 

 */  
public interface BaseDao<T> {  
  
    public void save(T entity);  
  
    public void update(T entity);  
  
    public void delete(Serializable id);   
  
    public T findById(Serializable id);  
  
    public List<T> findByHQL(String hql, Object... params);  
    
    public List<T> findAllByHQL(String hql);  
  
} 