package com.mycompany.shelter.dao.base;

import java.io.Serializable;  
import java.lang.reflect.ParameterizedType;
import java.util.List;  
  
import javax.annotation.Resource;  
  
import org.hibernate.Query;  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
  
/** 
 * BaseDaoImpl ����DAO��ͨ�ò�����ʵ�� 
 */  
@SuppressWarnings("unchecked")  
public class BaseDaoImpl<T> implements BaseDao<T> {  
  
    private Class<T> clazz;  
  
    /** 
     * ͨ�����췽��ָ��DAO�ľ���ʵ���� 
     */  
    public BaseDaoImpl() {  
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();  
        clazz = (Class<T>) type.getActualTypeArguments()[0];   
    }  
  
    /** 
     * ��DAO��ע��SessionFactory 
     */  
    @Resource  
    private SessionFactory sessionFactory;  
  
    /** 
     * ��ȡ��ǰ������Session 
     */  
    protected Session getSession() {  
        return this.sessionFactory.getCurrentSession();  
    }  
  
    @Override
	public void save(T entity) { 
    	Session session = sessionFactory.openSession();
    	session.save(entity);
    }  
  
    @Override
	public void update(T entity) { 
    	/* Transaction tran = this.getSession().beginTransaction() ;  */   
        this.getSession().update(entity);  
     /*   tran.commit();*/
        this.getSession().flush();
    
    }  
  
    @Override
	public void delete(Serializable id) {  
        this.getSession().delete(this.findById(id)); 
        this.getSession().flush();
    }  
    
 /*public void deletebyId(String table,String id){
    	  Transaction tran = this.getSession().beginTransaction() ;     
          StringBuffer hql =new StringBuffer(); 
          List<Object> parameter = new ArrayList<Object>();
          hql.append("Delete FROM ");
          hql.append( table );
          hql.append(" where id=");
          hql.append(id);
          System.out.println(hql.toString());
          Query q = this.getSession().createQuery(hql.toString()) ;          
          q.executeUpdate() ;     
          tran.commit() ; 
    	
    }*/
  
    @Override
	public T findById(Serializable id) {  
        return (T) this.getSession().get(this.clazz, id);  
    }  
  
    @Override
	public List<T> findByHQL(String hql, Object... params) {  
        Query query = this.getSession().createQuery(hql);  
        for (int i = 0; params != null && i < params.length; i++) {  
            query.setParameter(i, params);  
        }  
        return query.list();  
    }  
    
//    @Override
//    public List<T> findColsByHQL(String hql, Object...objects params) {
//        Query query = this.getSession().createQuery(hql);  
//
//    }
    
    @Override
	public List<T> findAllByHQL(String hql) {  
    	Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        return query.list();  
    } 
}  
