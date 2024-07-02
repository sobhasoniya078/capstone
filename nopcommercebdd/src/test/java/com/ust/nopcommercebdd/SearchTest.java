package com.ust.nopcommercebdd;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;

import com.ust.nopcommercebdd.Searchpage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchTest {
	WebDriver driver;
	Searchpage sp;
	
	
	@Before
	public void setup() {
		driver = new ChromeDriver();
		sp=new Searchpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@After
	public void teardown() throws InterruptedException {
		//Thread.sleep(3000);
		driver.close();
	}
	@Given("the user in the search page")
	public void the_user_in_the_search_page() {
		driver.get("https://demo.nopcommerce.com");
	}
	@When("user pass the null value")
	public void user_pass_the_null_value() {
		sp.nullValue();
	   
	}
	@When("the search button is clicked")
	public void the_search_button_is_clicked() {
	   sp.clickSearch();
	}
	@Then("the error msg should be displayed")
	public void the_error_msg_should_be_displayed() throws InterruptedException {
		Thread.sleep(3000);
	    driver.switchTo().alert().getText();
	}
	@When("user pass the invalid value")
	public void user_pass_the_invalid_value() {
	   sp.invalidItem();
	}
	@Then("the error message should be displayed")
	public void the_error_message_should_be_displayed() {
		 Boolean message=sp.notFound();
	  assertEquals(message,true);
	}
	@When("user pass the valid value")
	public void user_pass_the_valid_value() {
		sp.validItem();
	}
	
	@Then("the results will be displayed")
	public void the_results_will_be_displayed() {
	   Boolean sort=sp.results();
	    assertEquals(sort,true);
	    }


}
