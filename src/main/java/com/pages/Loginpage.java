package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class Loginpage extends TestBase {

	public Loginpage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(css=".btn_action")
	WebElement Login;
	
	public String GetTitle(){
		
		String title1= driver.getTitle();
		return title1;
	}
	
	public String Loginpage(String user, String pass){
		
		username.sendKeys(user);
		password.sendKeys(pass);
		Login.click();
		return driver.getTitle();
	}
}
