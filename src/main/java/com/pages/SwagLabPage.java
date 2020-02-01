package com.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testbase.TestBase;

public class SwagLabPage extends TestBase {

	public SwagLabPage() throws IOException {
		super();
		
	// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".product_sort_container")
	WebElement sorting;
	
	@FindBys(@FindBy(css=".inventory_item_label"))
	 List<WebElement> label;
	
	@FindBys(@FindBy(css=".inventory_item_price"))
	List<WebElement> price;
	
	@FindBys(@FindBy(css=".btn_primary.btn_inventory"))
	List<WebElement> btn;
	
	@FindBy(css=".fa-layers-counter.shopping_cart_badge")
	WebElement cart;
	
	@FindBy(css=".subheader")
	WebElement cartpage;
	
	@FindBys(@FindBy(css=".btn_secondary.btn_inventory"))
	List<WebElement> a;
	
	
	public String puttheitemsincart() throws InterruptedException{
		
		Select select= new Select(sorting);
		select.selectByVisibleText("Price (low to high)");
		ArrayList<Double> arr= new ArrayList<Double>();
//		  System.out.println(ele.size());
		  
		  for (int i=0 ;i<price.size(); i++){
			  
	
//			   arr.add(ele1.get(i).getText());
			   String t1=price.get(i).getText();
			   Double num=Double.parseDouble(t1.replaceAll("[^.0-9]",""));
			   System.out.println(num);
			   arr.add(num);
			   
		  }
		  
		 
		 Collections.sort(arr,Collections.reverseOrder());
	     System.out.println(arr);
	     
	     String arrtest=arr.get(2).toString();
	     Double d1= Double.parseDouble(arrtest);
		 System.out.println(d1);
		  
	     
		 for(int j=0; j<price.size();j++){
			
			
			 String t2=price.get(j).getText();
			   String num=(t2.replaceAll("[^.0-9]",""));
			   Double d= Double.parseDouble(num);
			   if (Double.compare(d, d1) == 0){
				   
				   
				 
				 System.out.println("*********Test****");
				 
    			 System.out.println(a.size());
    			 if(a.size()==0){
				    
    				 btn.get(j).click();
                     Thread.sleep(6000);
                     

			 }else if(a.size()>0){
				 
				 btn.get(2).click();
			 }
			 
			 }}
			   
			 cart.click();
		WebDriverWait wait= new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.textToBePresentInElement(cartpage, "Your Cart"));
		return cartpage.getText();
			 
	
		
}}
