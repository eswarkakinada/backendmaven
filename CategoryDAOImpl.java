package com.niit.shoppingcart.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionfactory;

	public CategoryDAOImpl(SessionFactory sessionfactory) {

		this.sessionfactory = sessionfactory;
	}

	public boolean save(Category category) {

		try {
			sessionfactory.getCurrentSession().save(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			;
		}

	}

	public boolean update(Category category) {

		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Category category) {

		try {
			
			sessionFactory.getCurrrentSession().delete(category);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Category get(String id){
	//select *from Category where id ='101'
	String hql ="from Category ere id ="+"'"+id+"'";
	Query query.sessionfactory.getCurrentSession().createQuery(hql);
	query.list();
	if(list==null){
		return null;
	}
	else {
		return list.get(0);
	}
	
}

	public List<Category> list() {

	}

}
