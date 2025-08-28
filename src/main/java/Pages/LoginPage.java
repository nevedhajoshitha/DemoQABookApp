package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userName") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="login") WebElement login;
	
	public void EnterUsername(String user) {
		username.sendKeys(user);
	}
	
	public void EnterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void ClickLogin() {
		login.click();
	}
	
}
