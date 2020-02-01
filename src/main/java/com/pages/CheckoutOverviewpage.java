package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testbase.TestBase;

public class CheckoutOverviewpage extends TestBase {

	public CheckoutOverviewpage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	CheckInformationpage check = new CheckInformationpage();
	
	@FindBy(css=".btn_action.cart_button")
	WebElement finish;
	
	@FindBy(css=".subheader")
	WebElement subheader2;
	
	public String NaviagtetoFinishpage() throws InterruptedException{
		check.Filltheform();
		finish.click();
		WebDriverWait wait= new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.textToBePresentInElement(subheader2, "Finish"));
		return subheader2.getText();
		
	}
}
