package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testbase.TestBase;

public class CheckInformationpage extends TestBase {

	public CheckInformationpage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	Cartpage cartpage= new Cartpage();
	
	@FindBy(id="first-name")
	WebElement FirstName;
	
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(id="postal-code")
	WebElement postalcode;
	
	@FindBy(css=".btn_primary.cart_button")
	WebElement continuebtn;
	
	@FindBy(css=".subheader")
	WebElement subheader1;
	
	
	public String Filltheform() throws InterruptedException{
		
		cartpage.cartpagenavigate();
		FirstName.sendKeys("Debolina");
		lastname.sendKeys("123444");
		postalcode.sendKeys("100001");
		continuebtn.click();
		WebDriverWait wait= new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.textToBePresentInElement(subheader1, "Checkout: Overview"));
		return subheader1.getText();
		
	}
	
	
}
