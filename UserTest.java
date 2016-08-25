package com.niit.ShoopingcartBack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;
import com.niit.shoppinngcart.configuration.ApplicationContextConfig;

public class UserTest {
	
	
	
public static void main (String[] args){
		
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.niit.*");
		context.refresh();
	
		
		UserDetailsDAO userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		UserDetails userDetails  = (UserDetails) context.getBean("userDetails");
		
		   userDetails.setName("Eswar");
		   userDetails.setId("s1");
		   userDetails.setContact("9640318026");
		   userDetails.setEmailid("eswar.kakinada@gmail.com");
		   userDetails.setAddress("Hyderabad");
	       userDetails.setPassword("niitstudent");
	       userDetailsDAO.save(userDetails);
	     if ( userDetailsDAO.save(userDetails)==true)
			{
				System.out.println("Userdetails created Successefully");
			}
			else
			{
				System.out.println("Userdetials not created");
			}
	       
	       
	
  }	

}
