package com.niit.shoppingcart.dao;

import java.util.List;

import javax.management.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.UserDetails;

@Repository(value = "userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO {

		@Autowired
	private SessionFactory sessionFactory;

	public UserDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;

	}

	@Transactional
	public boolean save(UserDetails userDetails) {
		try {
		//	sessionFactory.getCurrentSession().save(userDetails);
			Session s = sessionFactory.getCurrentSession();
			Transaction tx = s.beginTransaction();
			s.save(userDetails);
		tx.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean update(UserDetails userDetails) {
		try {
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public boolean delete(UserDetails userDetails) {
		try {
			sessionFactory.getCurrentSession().delete(userDetails);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	@Transactional
	public UserDetails get(String id) {

		String hql = "from product where id=" + " ' " + id + "'";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> list = query.list();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
	}

	@Transactional
	public  UserDetails isValidUser(String id,String password){
		
		//select * from UserDetails whre id='101' and Password 'niit'
		String hql= "From UserDetails whre id= '"+id+"'and password= '"+password+"'";
		
		Query query = (Query) sessionFactory.getCurrentSession().createQuery(hql);
   List<UserDetails> list=query.list();
		
	}
	
	
	
	
	
	@Transactional
	public List<UserDetails> list() {
		String hql = "from product";
		org.hibernate.Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();

	}
}
