package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {

	WebDriver ldriver;
	public AddNewCustomer(WebDriver rdriver) {

		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement lnkCustomer_menu;

	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement lnkCustomer_menuItem;

	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnAddNew;

	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;

	@FindBy(xpath="//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover k-state-focused k-state-border-up']//div[@role='listbox']")
	WebElement txtCustomerRole;

	@FindBy(xpath="//li[normalize-space()='Administrators']")
	WebElement listItemAdministrator;

	@FindBy(xpath="//li[normalize-space()='Registered']")
	WebElement listItemRegistered;

	@FindBy(xpath="//li[@id='d681c459-448f-4632-8edd-e1fb29b75d3f']")
	WebElement listItemGuests;

	@FindBy(xpath="//li[contains(text(),'Vendors')]")
	WebElement listItemVendors;

	@FindBy(xpath="//select[@id='VendorId']")
	WebElement dropdownVendorMgr;

	@FindBy(xpath="//input[@id='Gender_Male']")
	WebElement maleGender;

	@FindBy(xpath="//input[@id='Gender_Female']")
	WebElement feMaleGender;

	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFirstName;

	@FindBy(xpath="//input[@id='LastName']")
	WebElement txtLastName;


	@FindBy(xpath="//input[@id='DateOfBirth']") 
	WebElement txtDOB;


	@FindBy(xpath="//input[@id='Company']")
	WebElement txtCompanyName;

	@FindBy(xpath="//textarea[@id='AdminComment']")
	WebElement txtAdminContent;

	@FindBy(xpath="//button[@name='save']")
	WebElement btnSave;

	public String getPageTitle() {

		return ldriver.getTitle();
	}

	public void clickOnCustomerMenu() {
		lnkCustomer_menu.click();
	}

	public void clickOnCustomerMenuItem() {
		lnkCustomer_menuItem.click();
	}

	public void clickOnAddNewButton() {
		btnAddNew.click();
	}

	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void enterGender(String gender) {
		maleGender.sendKeys(gender);
	}
	public void enterDOB(String dob) {
		txtDOB.sendKeys(dob);
	}


	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void enterFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}

	public void enterCompanyName(String companyName) {
		txtCompanyName.sendKeys(companyName);
	}

	public void enterAdminContent(String admin) {
		txtAdminContent.sendKeys(admin);
	}

	public void saveButton() {
		btnSave.click();
	}


}
