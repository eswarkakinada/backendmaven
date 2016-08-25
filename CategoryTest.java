package com.niit.ShoopingcartBack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppinngcart.configuration.ApplicationContextConfig;

public class CategoryTest {
	static AnnotationConfigApplicationContext context;
	public   CategoryTest(){
		context =new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
		context.scan("com.niit");
		context.refresh();
	}
	
	public static void main (String[] args){
		
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.*");
		context.refresh();
		
		
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		Category category  = (Category) context.getBean("category");
		
		category.setId("CG123");
		category.setName("CG0015");
		category.setDescription("Hyderabad");
		
		if ( categoryDAO.save(category)==true)
		{
			System.out.println("Category created Successefully");
		}
		else
		{
			System.out.println("Category not created  Successefully");
		}
	}	
		
	}
	
