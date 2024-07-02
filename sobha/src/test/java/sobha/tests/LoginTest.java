package sobha.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import sobha.base.Reusable;
import sobha.pages.HomePage;
import sobha.pages.LoginPage;
import sobha.utils.ExtentReport;
import sobha.utils.excelReader;


	
@Listeners(ExtentReport.class)

public class LoginTest extends Reusable{

	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	
	@BeforeTest
	public void setup() {
		driver=invokeBrowser();
		driver.get(pro.getProperty("url"));
		lp=new LoginPage(driver);
		hp= new HomePage(driver);
	}
	
	
	  @Test(dataProvider = "dp") 
	  public void verifyvalidLogin(String n, String s) throws InterruptedException {
		  System.out.println(n+s);
		  lp.enterUsername(n);
		  lp.enterPassword(s);
		  lp.clickLogin();
		  Thread.sleep(3000);
		
		   assertEquals(hp.verifyHome(),true);
		   
		   

	  }
	  @Test(dataProvider = "invalidData") 
	  public void verifyinvalidLogin(String n, String s) throws InterruptedException {
		  System.out.println(n+s);
		  lp.enterUsername(n);
		  lp.enterPassword(s);
		  lp.clickLogin();
		  Thread.sleep(3000);
		  
		
		   assertEquals(lp.errormsg,true);
		   

	  }
	 @AfterTest
	 public void afterTest() {
		 driver.quit();
	 }
	  
	  @DataProvider public String[][] dp() throws IOException { 
		  String path=System.getProperty("user.dir")+"\\src\\test\\resources\\datasource\\data.xlsx"; 
		  return excelReader.locate(path,"logindata");
	  
	  }
	  @DataProvider public String[][] invalidData() throws IOException { 
		  String path=System.getProperty("user.dir")+"\\src\\test\\resources\\datasource\\data.xlsx"; 
		  return excelReader.locate(path,"invalid");
	  
	  }
	 
}
