package sobha.utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import sobha.base.Reusable;

public class ExtentManager {

	public static ExtentReports extent;
	public static ExtentSparkReporter htmlRepoerter;
	public static  ExtentReports createInstance() {
		try {
			String repname="TestReport--"+Reusable.getTimeStamp()+".html";
			htmlRepoerter=new ExtentSparkReporter(System.getProperty("user.dir")+"//reports//"+repname);
			htmlRepoerter.config().setDocumentTitle("Extent Report  Demo");
			htmlRepoerter.config().setReportName("Test Report");
			htmlRepoerter.config().setTimelineEnabled(true);
			htmlRepoerter.config().setTheme(Theme.DARK);
			htmlRepoerter.config().setTimeStampFormat("MM/dd/yy HH:mm:ss");
			
			extent= new ExtentReports();
			extent.attachReporter(htmlRepoerter);
			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("Host Name", "localHost");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("User Name", "Sobha");
		
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return extent;
	}
	
	
}
