package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver lDriver;
	public LoginPage(WebDriver rDriver) {

		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);

	}

	@FindBy(xpath="//input[@id='Email']")
	WebElement email;

	@FindBy(xpath="//input[@id='Password']")
	WebElement password;

	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(linkText = "Logout")
	WebElement logoutBtn;


	public void enterEmailAdd(String EmailAdd) {
		email.clear();
		email.sendKeys(EmailAdd);
	}

	public void enterPassword(String pswd) {
		password.clear();
		password.sendKeys(pswd);
	}

	public void ClickOnLoginButton() {
		loginBtn.click();
	}

	public void ClickOnLogoutButton(){
		
		logoutBtn.click();
	}


}
