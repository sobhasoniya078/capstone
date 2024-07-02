package sobha.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id="user-name")
	public WebElement username;
	@FindBy(id="password")
	public WebElement password;
	@FindBy(xpath="//form[1]/h3[1]/button[1]/*[1]")
	public WebElement errormsg;
	@FindBy (id="login-button")
	public WebElement loginbtn;
	
public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
public void enterUsername(String name) {
	username.clear();
	username.sendKeys(name);
}
public void enterPassword(String pass) {
	password.clear();
	password.sendKeys(pass);
	
}
public Boolean errorMessgae() {
	Boolean err=errormsg.isDisplayed();
	return err;
	
}
public HomePage clickLogin() {
	
	loginbtn.click();
	return new HomePage(driver);
}

}
