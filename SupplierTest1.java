package com.niit.ShoopingcartBack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppinngcart.configuration.ApplicationContextConfig;

public class SupplierTest1 {

	static AnnotationConfigApplicationContext context;

	public SupplierTest1() {
		context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		context.scan("com.niit");
		context.refresh();
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
	context.refresh();
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier = (Supplier) context.getBean("supplier");

		supplier.setId("harika4");
		supplier.setName("Eswar");
		supplier.setAddress("Hderabad");

		if (supplierDAO.save(supplier) == true) {
			System.out.println("Supplier created Successefully");
		} else {
			System.out.println("Supplier not created ");
		}

	}

}
