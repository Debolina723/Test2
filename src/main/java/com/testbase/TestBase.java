package com.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

import com.TestUtil.TestUtil;
import com.testdata.TestData;


public class TestBase {


	static Properties prop;
	public static WebDriver driver;
	public static TestData testdata;
	
	
	
	public TestBase() throws IOException{
		
		String path= System.getProperty("user.dir");
		prop= new Properties();
		FileInputStream fis= new FileInputStream(path+"/"+"/Folder"+"/config.properties");
		prop.load(fis);
		
	}
	
	@DataProvider
	
	public static Object[][] getarray(){
		
		Object[][] arr1=null;
		try {
			arr1=testdata.getData("Sheet1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("**************");
		return arr1;
		
		
		
	}
	
	
	
	public static void initialisation(){
		
		String browsername=prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome"))
		{
			
	     ChromeOptions option= new ChromeOptions();
	     option.addArguments("--disable-notifications"); 
//	     option.addArguments("--start-maximized");
	     String driverset=System.getProperty("user.dir");
		System.getProperty("webdriver.chrome.driver", driverset+"/"+"chromedriver");
		 driver=new ChromeDriver(option);
	    }
		else if(browsername.equalsIgnoreCase("FF")){
			
			String driverset=System.getProperty("user.dir");
			System.getProperty("webdriver.gecko.driver", driverset+"/"+"geckodriver");
			driver=new FirefoxDriver();	
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIATWAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().window().fullscreen();
	}
}


