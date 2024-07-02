package com.ust.nopcommercebdd;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	By mail = By.id("Email");
	By log=By.linkText("Log in");
    By pass=By.id("Password");
    By btn=By.className("login-button");
    By err=By.className("validation-summary-errors");
    By con=By.className("ico-logout");
    By r=By.id("Email-error");
	
    public void login() {
    	 driver.findElement(log).click();
    }
	
	public void email() {
		driver.findElement(mail).sendKeys("dia@gmail.com");
	}
	public void enterPassword() {
		driver.findElement(pass).sendKeys("Dia@12345");
	}
	public LoginPage clickLogin() {
		driver.findElement(btn).click();
		return new LoginPage(driver);
	}
	public void invalidEmail() {
		driver.findElement(mail).sendKeys("soho@gmail.com");
	}
	public void invalidPassword() {
		driver.findElement(pass).sendKeys("Soho1234");
	}
	public Boolean loginValidation() {
		Boolean cont=driver.findElement(con).isDisplayed();
		
		return cont;
		  
	}
	public boolean invalid() {
		Boolean msg=driver.findElement(err).isDisplayed();
		return msg;
		
	}
public boolean errorMsg() {
	Boolean error=driver.findElement(r).isDisplayed();
	return error;
	
	}


}
