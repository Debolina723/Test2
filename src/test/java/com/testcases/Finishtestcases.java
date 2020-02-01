package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.CheckoutOverviewpage;
import com.pages.Finishpage;
import com.pages.Loginpage;

import junit.framework.Assert;

public class Finishtestcases extends Finishpage{

	public Finishtestcases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Loginpage login;
	Finishpage finishpage;
	
@BeforeMethod
	
	public void setup() throws IOException{
		
		initialisation();
		login= new Loginpage();
		finishpage= new Finishpage();
		
	}

@Test(dataProvider="getarray",priority=7)
public void VerifytheFinishpage(String user, String pass) throws InterruptedException{
	
	 login.Loginpage(user, pass);
	 String finish=finishpage.Finishpage();
	 Assert.assertEquals("THANK YOU FOR YOUR ORDER", finish);
}

@AfterMethod

public void teardown(){
	
	driver.quit();
}
}
