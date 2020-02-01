package com.ExtentReportandListerner;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

private static ExtentReports extent;
	
	public static synchronized ExtentReports getreporter(){
		
		if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir+"/ExtentReportResults.html", true);
        	//extent= new ExtentReports("/Users/debolinachatterjee/Documents/workspace/project1/ExtentReportResults.html");
        }
		return extent;
		
		
	}
	
}
