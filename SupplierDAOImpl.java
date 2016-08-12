package com.niit.shoppingcart.dao;
import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Supplier;

@Repository(value="SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO {
	private static org.hibernate.SessionFactory SessionFactory = null;
	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory){
		this.SessionFactory=sessionFactory;
	}

	@Transactional
	public boolean save(Supplier supplier)
	{
		try {
			SessionFactory.getCurrentSession().save(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	@Transactional
	public boolean update(Supplier supplier)
	{
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public boolean delete(Supplier supplier)
	{
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public Supplier get(String id)
	{
		String hql = "from Supplier where id=" + " ' " + id + "'";
		org.hibernate.Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
		
		
	}
	public List<Supplier> list()
	{
		String hql = "from Supplier";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
	}
}



	
	
	
	
	


