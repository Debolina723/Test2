package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Loginpage1 {
	
	
	WebDriver driver;
	
	@Test
	public void Test() throws InterruptedException{
		
	String text=System.getProperty("user.dir");
	System.getProperty("webdriver.chrome.driver", text+"/"+"chromedriver");
	 driver=new ChromeDriver();

	 driver.get("https://www.saucedemo.com/index.html");
	 driver.findElement(By.id("user-name")).sendKeys("standard_user");
	 driver.findElement(By.id("password")).sendKeys("secret_sauce");
	 driver.findElement(By.cssSelector(".btn_action")).click();
	 Thread.sleep(5000);
	 WebElement ele10=driver.findElement(By.cssSelector(".product_sort_container"));
	 Select select= new Select(ele10);
	 select.selectByVisibleText("Price (low to high)");
	 Thread.sleep(788);
	 ArrayList<Double> arr= new ArrayList<Double>();
	 List<WebElement> ele=driver.findElements(By.cssSelector(".inventory_item_label"));
//	  System.out.println(ele.size());
	  
	  for (int i=0 ;i<ele.size(); i++){
		  
		  List<WebElement> ele1=driver.findElements(By.cssSelector(".inventory_item_price"));
//		   arr.add(ele1.get(i).getText());
		   String t1=ele1.get(i).getText();
		   Double num=Double.parseDouble(t1.replaceAll("[^.0-9]",""));
		   System.out.println(num);
		   arr.add(num);
		   
	  }
	  
	 
	 Collections.sort(arr,Collections.reverseOrder());
     System.out.println(arr);
	  
		 String arrtest=arr.get(2).toString();
		 System.out.println(arrtest);
		 
		 
		 
		 
		 List<WebElement> ele2=driver.findElements(By.cssSelector(".inventory_item_price"));
		 for(int j=0; j<ele2.size();j++){
			
			
			 String t2=ele2.get(j).getText();
			   String num=(t2.replaceAll("[^.0-9]",""));
			 if (num.equalsIgnoreCase(arrtest)){
				 
				 System.out.println("*********Test****");
				 List<WebElement>el3= driver.findElements(By.cssSelector(".btn_primary.btn_inventory"));
				 
				    
				    el3.get(j).click();
                     Thread.sleep(6000);
					
				    
			 
			 
			 List<WebElement> a=driver.findElements(By.cssSelector(".btn_secondary.btn_inventory"));
			 System.out.println(a.size());
			 if(a.size()>0){
				 
				
				 
				    
				    el3.get(2).click();
                  Thread.sleep(6000);
					
			 }
			 
			 }
		 }
		 
	
	}
		 
		 
	   

	
	@AfterMethod
	 
	 public void teardown(){
		
		driver.quit();
	 }

}




