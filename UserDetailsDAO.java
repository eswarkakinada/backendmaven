package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.UserDetails;

@Repository
public interface UserDetailsDAO {

	//Declare all CRUD Operation 
	
	
	public boolean save (UserDetails UserDetails);
	
	
	public boolean update (UserDetails UserDetails);
	
	public boolean delete (UserDetails UserDetails);
	
	public  UserDetails       get(String id);
	
	public List<UserDetails>       list();
	
}
