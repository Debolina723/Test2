package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testbase.TestBase;

public class Cartpage extends TestBase {

	public Cartpage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	SwagLabPage swg1= new SwagLabPage();
	
	@FindBy(css=".btn_action.checkout_button")
	WebElement checkbtn;
	
	@FindBy(css=".subheader")
	WebElement checkyourinf;
	
	
	public String cartpagenavigate() throws InterruptedException{
		
		swg1.puttheitemsincart();
		checkbtn.click();
		WebDriverWait wait= new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.textToBePresentInElement(checkyourinf, "Checkout: Your Information"));
		return checkyourinf.getText();
		
		
	}
}
