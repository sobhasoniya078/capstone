package com.ust.orangehrm;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	WebDriver driver;
	LoginPage lp;
	@Before
	public void setup() {
		driver = new ChromeDriver();
		lp=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@After
	public void teardown() throws InterruptedException {
		//Thread.sleep(3000);
		driver.close();
	}
	@Given("the user in the orange HRM login page")
	public void the_user_in_the_orange_hrm_login_page() {
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    
	}
	@When("the user name and password entered")
	public void the_username_and_password_entered() {
		lp.enterUsername();
		lp.enterPassword();
	   
	    
	}
	
	@When("the invalid user name and password entered")
	public void the_invalid_username_and_password_entered() {
		lp.invalidName();
		lp.invalidPassword();
	    
	   
	}
	@When("the login button is clicked")
	public void the_login_button_is_clicked() throws InterruptedException {
	    lp.clickLogin();
	   
	}
	@Then("the user should be logged in successfully")
	public void the_user_should_be_logged_in_successfully() {
	 
		String head =  lp.loginValidation();
		assertEquals(head,"Dashboard");
	}
	
	@Then("error message should be displayed")
	public void error_message_should_be_displayed() {  // Write code here that turns the phrase above into concrete actions
	   
	   Boolean alrt = lp.invalid();
	   assertEquals(alrt,true);
	   
	}

}
