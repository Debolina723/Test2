package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testbase.TestBase;

public class Finishpage extends TestBase {

	public Finishpage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	CheckoutOverviewpage overview= new CheckoutOverviewpage();
	
	@FindBy(css="#checkout_complete_container>h2")
	WebElement Finishpage;
	
	public String Finishpage() throws InterruptedException{
		
		overview.NaviagtetoFinishpage();
		String t1=Finishpage.getText();
		return t1;
		
	}
}
