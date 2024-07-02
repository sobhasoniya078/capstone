package com.ust.nopcommercebdd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Searchpage {
	WebDriver driver;
	public Searchpage(WebDriver driver) {
		this.driver=driver;
	}

	By key=By.id("small-searchterms");
	By search=By.className("search-box-button");
	By msg=By.className("no-result");
	By srt=By.id("products-orderby");
	
	
	
	public void nullValue() {
		driver.findElement(key).clear();
		   
	}
	public void invalidItem() {
		driver.findElement(key).sendKeys("Orange");
	}
	public void validItem() {
		driver.findElement(key).sendKeys("Book");
	}
	public void clickSearch() {
		 driver.findElement(search).click();
	}
	public void alert() {}
	public boolean notFound() {
		Boolean message=driver.findElement(msg).isDisplayed();
		return message;
	}
	public boolean results() {
		Boolean sort=driver.findElement(srt).isDisplayed();
		return sort;
	}
	
}
