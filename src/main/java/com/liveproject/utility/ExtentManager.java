package com.liveproject.utility;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {

	public static ExtentReports Err;
	public static ExtentHtmlReporter html;
	
public static void setEextent() {
	// TODO Auto-generated method stub

	ExtentHtmlReporter html=new ExtentHtmlReporter
			(System.getProperty("user.dir")+"//ExtentReporter//myreport_"+".html");
	
	
		ExtentReports Err=new ExtentReports();
		Err.attachReporter(html);
		
		
		/*
		 * Err.setSystemInfo("HostName", "MyHost"); Err.setSystemInfo("ProjectName",
		 * "MyStoreProject"); Err.setSystemInfo("Tester", "Hitendra");
		 * Err.setSystemInfo("OS", "Win10"); Errt.setSystemInfo("Browser", "Chrome");
		 */
	
}

public static void endReport() {
	// TODO Auto-generated method stub
	Err.flush();
}

}
