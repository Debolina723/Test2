package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Cartpage;
import com.pages.Loginpage;
import com.pages.SwagLabPage;

import junit.framework.Assert;

public class CartpageTestcases extends Cartpage {

	public CartpageTestcases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Loginpage login;
	Cartpage cartpage;
	
@BeforeMethod
	
	public void setup() throws IOException{
		
		initialisation();
		login= new Loginpage();
		 cartpage=new Cartpage();
		
		
	}
 
@Test(dataProvider="getarray",priority=4)
public void NextpageinCartpage(String user, String pass) throws InterruptedException{
	
	login.Loginpage(user, pass);
	String title=cartpage.cartpagenavigate();
	Assert.assertEquals("Checkout: Your Information", title);
}

@AfterMethod
public void teardown(){
	driver.quit();
}
}
