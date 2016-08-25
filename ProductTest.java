package com.niit.ShoopingcartBack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppinngcart.configuration.ApplicationContextConfig;

public class ProductTest {
	
	static AnnotationConfigApplicationContext context;
	public   ProductTest(){
		context =new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		context.scan("com.niit");
		context.refresh();
		}
		public static void main (String[] args){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
			context.refresh();
		 
			ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
			Product product  = (Product) context.getBean("product");
			
		
			product.setId("p22");
			product.setName("i phone");
			product.setPrice(65000);
			product.setDescription("the best phone in world");
			
		if ( productDAO.save(product)==true)
		{
			System.out.println("Product created Successefully");
		}
		else
		{
			System.out.println("Product not created ");
		}
	}
}




