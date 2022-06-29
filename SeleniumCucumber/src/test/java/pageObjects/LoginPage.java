package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(name="Email")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setTxtEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setTxtPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}

	public void clickBtnLogin() {
		btnLogin.click();
	}

	public void clickLnkLogout() {
		lnkLogout.click();
	}
			
}
