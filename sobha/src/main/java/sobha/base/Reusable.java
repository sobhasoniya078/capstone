package sobha.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverImplementtion.DriverClass;
import sobha.utils.ObjectReader;

public class Reusable {
	
	public static WebDriver driver;
	public static Properties pro;
	public static String browser_choice;

	public Reusable() {
		try {
			pro = ObjectReader.objectRead();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static WebDriver invokeBrowser() {
		browser_choice = pro.getProperty("driver");
		try {
			if (browser_choice.contentEquals("chrome")) {
				driver = DriverClass.getChrome();
			} else if (browser_choice.contentEquals("edge")) {
				driver = DriverClass.getEdge();
			} else {
				throw new Exception("invalid browsername provided in properties file");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		

		return driver;

	}
	public static void takeScreenshot(String filepath) {
		TakesScreenshot takeScreenshot=(TakesScreenshot) driver;
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  File dest =takeScreenshot.getScreenshotAs(OutputType.FILE);
		  try {
			 FileUtils.copyFile(screenshotFile, dest); 
		  }
		  catch(IOException e) {
			  e.printStackTrace();
		  }
		}
	public static String getTimeStamp() {
		return new SimpleDateFormat("yy.mm.dd.hh.mm.ss").format(new Date());
	}

}
