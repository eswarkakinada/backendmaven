package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;

@Repository
public interface ProductDAO {

	//Declare all CRUD Operation 
	
	
	public boolean save (Product product);
	
	
	public boolean update (Product product);
	
	public boolean delete (Product product);
	
	public  Product       get(String id);
	
	public List<Product>       list();
	
}
