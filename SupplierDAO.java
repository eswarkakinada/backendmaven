package com.niit.shoppingcart.dao;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.niit.shoppingcart.model.Supplier;


public interface SupplierDAO {
	
	
	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier get(String id);
	public List<Supplier> list();
}



	