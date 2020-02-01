package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.Loginpage;

import junit.framework.Assert;



public class LoginpageTestcase extends Loginpage{

	public LoginpageTestcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Loginpage login;
	
@BeforeMethod
	
	public void setup() throws IOException{
		
		initialisation();
		login= new Loginpage();
		
		
	}

  @Test(priority=1)
 public void GetpageTitle(){

	  String title2=login.GetTitle();
	  Assert.assertEquals("Swag Labs", title2);
}
  
  @Test(dataProvider="getarray",priority=2)
  public void logintestcases(String user, String pass){
	  
	  String title2=login.Loginpage(user, pass);
	  Assert.assertEquals("Swag Labs", title2);
  }
  
  @AfterMethod
  public void teardown(){
	  
	  driver.quit();
  }
}
