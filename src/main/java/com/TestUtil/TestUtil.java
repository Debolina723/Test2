package com.TestUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.testbase.TestBase;

public class TestUtil extends TestBase {

	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	static String path=System.getProperty("user.dir");
	public static long TIMEOUT=60;
	public static long IMPLICIATWAIT=30;
	public static String SHEETPATH= path+"/"+"/Folder"+"/login.xlsx";
	public static String filename="login.xlsx";
	
	public static void takesScreenshot(String methodName, WebDriver driver) throws IOException{
		
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFile(srcfile, new File(currentDir+"/screenshots/"+System.currentTimeMillis()+methodName+".png"));
		
}}
