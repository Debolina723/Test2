package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Loginpage;
import com.pages.SwagLabPage;

import junit.framework.Assert;

public class SwagLabPagetestcases extends SwagLabPage{

	public SwagLabPagetestcases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
    
	Loginpage login;
	SwagLabPage swg;
	
@BeforeMethod
	
	public void setup() throws IOException{
		
		initialisation();
		login= new Loginpage();
		swg=new SwagLabPage();
		
		
	}

@Test(dataProvider="getarray",priority=3)
public void SwagLabpagetestcases(String user, String pass) throws InterruptedException{
	
	login.Loginpage(user, pass);
	String title=swg.puttheitemsincart();
	Assert.assertEquals("Your Cart", title);
}

@AfterMethod

public void teardown(){
	
	driver.quit();
}
}
