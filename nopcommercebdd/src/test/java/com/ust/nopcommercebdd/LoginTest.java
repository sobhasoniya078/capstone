package com.ust.nopcommercebdd;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	static WebDriver driver;
	static LoginPage lp;
	@BeforeAll
	public static void setup() {
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com");
		lp=new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@AfterAll
	public static void teardown() throws InterruptedException {
		//Thread.sleep(3000);
		driver.close();
	}
	
	@Given("the user in the nopecommerce login page")
	public void the_user_in_the_nopecommerce_login_page() throws InterruptedException {
	    
	    lp.login();
	    
	}

	@When("the user name and password entered")
	public void the_user_name_and_password_entered() {
		lp.email();
		 lp.enterPassword();
		
	}

	@When("the login button is clicked")
	public void the_login_button_is_clicked() {
	  lp.clickLogin();
	}

	@Then("the user should be logged in successfully")
	public void the_user_should_be_logged_in_successfully() {
		Boolean cont=lp.loginValidation();
		assertEquals(cont,true);
	    
	}

	@When("the invalid user name and password entered")
	public void the_invalid_user_name_and_password_entered() {
		lp.invalidEmail();
		lp.invalidPassword();
		
	}

	@Then("error message should be displayed")
	public void error_message_should_be_displayed() {
		Boolean msg=lp.invalid();
		assertEquals(msg,true);
	    
	}
	
	@Then("appropriate  error message should be displayed")
	public void appropriate_error_message_should_be_displayed() {
		Boolean error=lp.errorMsg();  
		assertEquals(error,true);
	}

}
