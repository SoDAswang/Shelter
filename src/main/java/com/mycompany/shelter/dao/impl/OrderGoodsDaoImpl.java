package com.mycompany.shelter.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.aspectj.weaver.ast.Var;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.mycompany.shelter.dao.OrderGoodsDao;
import com.mycompany.shelter.dao.base.BaseDaoImpl;
import com.mycompany.shelter.entity.OrderGoods;

@Repository("OrderGoodsDao")
public class OrderGoodsDaoImpl extends BaseDaoImpl<OrderGoods> implements OrderGoodsDao{
	
	@Override
	public int saveOrderGoods(String wishId) {
		StringBuffer hql = new StringBuffer();
		hql.append("insert into order_goods(wishId, materialId, color) ");
		hql.append("select w.id, sm.materialId, sm.color from sample_material sm, wish w ");
		hql.append("where 1 = ? ");
		hql.append("and w.id = ? ");
		hql.append("and sm.subject in (select w.subject from wish where w.id = ?) ");
		hql.append("and w.sampleId = sm.sampleId");
		// execute sql, not hql
		Query query = this.getSession().createSQLQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, wishId);
		query.setString(2, wishId);
		
		return query.executeUpdate();
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findMaterialByWishId(String wishId) {
		StringBuffer hql = new StringBuffer();
		hql.append("select m.id, m.typeId, m.type, m.title, m.price, m.brand, m.texture, m.style, m.fit, m.inventory, m.label, m.coverAdd, m.note, m.length, m.width, m.location, CONCAT('颜色：', og.color), og.id , m.weight, m.areaPerWeight from OrderGoods og, Material m where 1= ? ");
		//                   0     1         2       3        4        5        6          7        8      9            10       11          12      13        14       15               16                    17     18        19
		hql.append("and og.wishId = ? ");
		hql.append("and og.materialId = m.id");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, wishId);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findDistinctMaterialByWishIdAndLocation(String wishId, String location) {
		StringBuffer hql = new StringBuffer();
		hql.append("select distinct m.id, m.coverAdd, m.title from OrderGoods og, Material m where 1 = ? ");
        //                            0     1           2
		hql.append("and og.wishId = ? ");
		hql.append("and m.location = ? ");
		hql.append("and og.materialId = m.id");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, wishId);
		query.setString(2, location);
		
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findColorByWishIdAndMaterialId(String wishId, String materialId) {
		StringBuffer hql = new StringBuffer();
		hql.append("select color from OrderGoods where 1 = ? ");
		hql.append("and wishId = ? ");
		hql.append("and materialId = ?");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, wishId);
		query.setString(2, materialId);
		
		return query.list();
	}

	@Override
	public String findOrderGoodsIdByWishIdAndMaterialIdAndColor(String wishId, String materialId, String color) {
		StringBuffer hql = new StringBuffer();
		hql.append("select id from OrderGoods where 1 = ? ");
		hql.append("and wishId = ? ");
		hql.append("and materialId = ? ");
		hql.append("and color = ?");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, wishId);
		query.setString(2, materialId);
		query.setString(3, color);
		
		String result = "";
		if (query.list().size() > 0) {
			result = query.list().get(0).toString();
		} else {
			result = "0";
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findMaterialByWishIdAndLocation(String wishId, String location) {
		StringBuffer hql = new StringBuffer();
		hql.append("select m.id, m.typeId, m.type, m.title, m.price, m.brand, m.texture, m.style, m.fit, m.inventory, m.label, m.coverAdd, m.note, m.length, m.width, m.location, CONCAT('颜色：', og.color), og.id , m.weight, m.areaPerWeight from OrderGoods og, Material m where 1= ? ");
		//                   0     1         2       3        4        5        6          7        8      9            10       11          12      13        14       15               16                    17     18        19
		hql.append("and og.wishId = ? ");
		hql.append("and m.location = ? ");
		hql.append("and og.materialId = m.id");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, wishId);
		query.setString(2, location);
		
		return query.list();
	}

	@Override
	public int deleteByWishId(String wishId) {
		StringBuffer hql = new StringBuffer();
		hql.append("delete from OrderGoods where 1 = ? ");
		hql.append("and wishId = ? ");
		Query query = this.getSession().createQuery(hql.toString());
		query.setString(0, "1");
		query.setString(1, wishId);
		
		return query.executeUpdate();
	}

	@Override
	public int updateColorByOrderGoodsId(String orderGoodsId, String color) {
		StringBuffer sql = new StringBuffer();
		sql.append("update order_goods set color = ? ");
		sql.append("where 1 = ? ");
		sql.append("and id = ?");
		Query query = this.getSession().createSQLQuery(sql.toString());
		query.setString(0, color);
		query.setString(1, "1");
		query.setString(2, orderGoodsId);
		
		return query.executeUpdate();
	}

//	@Override
//	public int deleteOrderGoodsBySampleMaterialId(String SampleMaterialId) {
//		StringBuffer hql = new StringBuffer();
//		hql.append("delete from order_goods where 1 = ? ");
//		hql.append("and wishId in (select id from wish where customerId = ? and sampleId = ? and subject in (select subject from sample_material where id = ?)) ");
//		hql.append("and materialId in (select materialId from sample_material where id = ? ) ");
//		hql.append("and color in (select color from sample_material where id = ?)");
//		return 0;
//	}

}
