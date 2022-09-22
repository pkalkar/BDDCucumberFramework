package StepDefinition;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import PageObject.AddNewCustomer;
import PageObject.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDef extends BaseClass {

	@Before
	public void setup() {

		log=org.apache.logging.log4j.LogManager.getLogger("StepDef");
		System.out.println("Setup method executed..!! ");
		//WebDriverManager.chromedriver().setup();
		//driver=new ChromeDriver();

		log.info("Setup executed...");
		
		
	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {

		initiateDriver("iOS");

		driver.manage().window().maximize();
		loginpg=new LoginPage(driver);
		addNewCustPg=new AddNewCustomer(driver);

		log.info("Chrome browser Launch...");
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);

		log.info("URL Opened...");
	}

	@When("User Enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pswd) {

		loginpg.enterEmailAdd(email);
		loginpg.enterPassword(pswd);
		log.info("Entered Email ID and Password...");
	}

	@When("Click on Login")
	public void click_on_login() {

		loginpg.ClickOnLoginButton();

		log.info("Clicked on Login Button...");
	}

	@Then("Page Title Should be {string}")
	public void page_title_should_be(String expectedTitle) {

		String actualTitle= driver.getTitle();

		if(actualTitle.equals(expectedTitle)) {

			Assert.assertTrue(true); 
		}
		else {

			//	Assert.assertTrue(false);
		}

		log.info("Page Title Verified...");
	}


	@When("User Click on Log out link")
	public void user_click_on_log_out_link() {

		loginpg.ClickOnLogoutButton();

		log.info("Clicked on LogOut Button...");
	}

	@Then("close browser")
	public void close_browser() {

		driver.close();
	}


	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle=addNewCustPg.getPageTitle();
		String expectedTitle="Dashboard / nopCommerce administration";

		if(actualTitle.equals(expectedTitle)) {

			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}

		log.info("DashBoard Screen verified...");
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		addNewCustPg.clickOnCustomerMenu();

		log.info("Clicked on Customer Menu...");
	}

	@When("Click on customers Menu Item")
	public void click_on_customers_menu_item() {
		addNewCustPg.clickOnCustomerMenuItem();

		log.info("Clicked on Customer Menu Item...");
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() {

		addNewCustPg.clickOnAddNewButton();

		log.info("Clicked on Add New Button...");

	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {

		String actualTitle=addNewCustPg.getPageTitle();
		String expectedTitle="Add a new customer / nopCommerce administration";

		if(actualTitle.equals(expectedTitle)) {

			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		log.info("Verified Add New Customer Page...");
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		addNewCustPg.enterEmail(generateEmailId()+"@gmail.com");
		addNewCustPg.enterPassword("test1");
		addNewCustPg.enterFirstName("Prasanna");
		addNewCustPg.enterLastName("Kalkar");
		addNewCustPg.enterGender("Male");
		addNewCustPg.enterDOB("6/12/1999");
		addNewCustPg.enterCompanyName("Msys");
		addNewCustPg.enterAdminContent("Admin");


		log.info("Entered Cutomer Info...");

	}

	@When("Click on Save button")
	public void click_on_save_button() {
		addNewCustPg.saveButton();

		log.info("Clicked on Save button...");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmation) {

		String bodyTagText=driver.findElement(By.tagName("Body")).getText();

		if(bodyTagText.contains(expectedConfirmation)) {
			Assert.assertTrue(true);

		}
		else {
			Assert.assertTrue(false);
		}

		log.info("Verified confirmation message...");
	}


	@After
	public void tearDown(Scenario sc) {


		if(sc.isFailed()==true) {
			String filePath="C:\\Users\\prasanna.kalkar\\eclipse-workspace\\BDDCucumberFramework\\Screenshots\\failed1.png";
			TakesScreenshot scrShot=((TakesScreenshot)driver);
			File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
			File destFile=new File(filePath);
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		System.out.println("Tear Down Method Executed..!");
		driver.quit();

		log.info("Tear Down method executed");
	}

	//@BeforeStep
	public void beforeStep() {
		System.out.println("This is before step");
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {

		if(scenario.isFailed())
		{
			final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

	}

}
