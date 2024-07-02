package sobha.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	@FindBy(id="react-burger-menu-btn")
	WebElement menu;
	@FindBy(className="app_logo")
	WebElement hd;
	@FindBy(id="logout_sidebar_link")
	WebElement logout;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickMenu() {
		
		menu.click();
	}
	public Boolean verifyHome() {
		return hd.isDisplayed();
	}
	public LoginPage clickLogout() {
		logout.click();
		return new LoginPage(driver);
	}

}
