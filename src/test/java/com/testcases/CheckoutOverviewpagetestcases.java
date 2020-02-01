package com.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.CheckInformationpage;
import com.pages.CheckoutOverviewpage;
import com.pages.Loginpage;

import junit.framework.Assert;

public class CheckoutOverviewpagetestcases extends CheckoutOverviewpage {

	public CheckoutOverviewpagetestcases() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	Loginpage login;
	CheckoutOverviewpage chk;
	
@BeforeMethod
	
	public void setup() throws IOException{
		
		initialisation();
		login= new Loginpage();
		chk= new CheckoutOverviewpage();
		
	}

@Test(dataProvider="getarray",priority=6)
public  void CheckoutOverviewcases(String user, String pass) throws InterruptedException{
	
	   login.Loginpage(user, pass);
	   String title=chk.NaviagtetoFinishpage();
	   Assert.assertEquals("Finish", title);
	   
}
}
