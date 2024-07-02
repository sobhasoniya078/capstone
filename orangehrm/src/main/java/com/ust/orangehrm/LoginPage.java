package com.ust.orangehrm;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterUsername() {
		 WebElement name=driver.findElement(By.name("username"));
		    name.sendKeys("Admin");
	}
	public void enterPassword() {
		WebElement pass=driver.findElement(By.name("password"));
	    pass.sendKeys("admin123");
	}
	public void clickLogin() {
		 driver.findElement(By.className("orangehrm-login-button")).click();
	}
	public void invalidName() {
		WebElement name=driver.findElement(By.name("username"));
	    name.sendKeys("sobha");
	}
	public void invalidPassword() {
		 WebElement pass=driver.findElement(By.name("password"));
		    pass.sendKeys("sobha");
	}
	public String loginValidation() {
		WebElement title=driver.findElement(By.className("oxd-topbar-header-breadcrumb-module"));
		  String head=title.getText();
		return head;
		  
	}
	public boolean invalid() {
		boolean alrt=driver.findElement(By.className("oxd-alert--error")).isDisplayed();
		   System.out.println(alrt);
		return alrt;
		
	}

}
