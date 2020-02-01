package com.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.CheckInformationpage;
import com.pages.Loginpage;

import junit.framework.Assert;

public class CheckInformationtestcases extends CheckInformationpage {

	public CheckInformationtestcases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Loginpage login;
	CheckInformationpage chk;
	
@BeforeMethod
	
	public void setup() throws IOException{
		
		initialisation();
		login= new Loginpage();
		chk= new CheckInformationpage();
		
	}

@Test(dataProvider="getarray",priority=5)

public void VerifyCheckOutInformation(String user, String pass) throws InterruptedException{
	
	login.Loginpage(user, pass);
	String checkout=chk.Filltheform();
	Assert.assertEquals("Checkout: Overview", checkout);
}

@AfterMethod
public void teardown(){
	
	driver.quit();
}
}
