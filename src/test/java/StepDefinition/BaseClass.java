package StepDefinition;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.Assertion;
import PageObject.AddNewCustomer;
import PageObject.LoginPage;

public class BaseClass {

	public static final String USERNAME = System.getenv("prasannakalkar_dqRD0c");
	public static final String AUTOMATE_KEY = System.getenv("kWfaK6EyXtNypGezcpnG");
	public static final String browserstack_url = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	//ConfigFileReader propertyFile=new ConfigFileReader();
	public static WebDriver driver;
	public AddNewCustomer addNewCustPg;
	public LoginPage loginpg;
	public static Logger log;
	//public static RemoteWebDriver driver;
	//public static AndroidDriver<WebElement> Androiddriver;
	//public static IOSDriver<WebElement> iOSdriver;
	public static String platform;
	Assertion assertion = new Assertion();
	

	public void initiateDriver(String OSVersion) {
		if (OSVersion.equalsIgnoreCase("iOS")) {
			platform = OSVersion;

			try { 
				
				DesiredCapabilities caps = new DesiredCapabilities(); 
				
				// Set your access credentials 

			caps.setCapability("browserstack.user", "prasannakalkar_dqRD0c");
			caps.setCapability("browserstack.key", "kWfaK6EyXtNypGezcpnG");
			
			// Specify device and os_version for testing
			
			caps.setCapability("deviceName","iPhone 12" );
			caps.setCapability("osVersion", "14");

			// Set other BrowserStack capabilities
			
			caps.setCapability("project","Eportal");
			caps.setCapability("build", "1.4");		
			driver = new RemoteWebDriver(new URL(browserstack_url), caps);

			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);

			}

			catch (Exception e) { e.printStackTrace(); }

		}
		else if (OSVersion.equalsIgnoreCase("android")) {
			platform = OSVersion;
			try {
				DesiredCapabilities caps = new DesiredCapabilities();
//				// Set your access credentials
				
				caps.setCapability("browserstack.user", "prasannakalkar_dqRD0c");
				caps.setCapability("browserstack.key", "kWfaK6EyXtNypGezcpnG");
				
//				caps.setCapability("browserstack.user", propertyFile.getBrowserstackUser());
//				caps.setCapability("browserstack.key", propertyFile.getBrowserstackKey());
//				
//				// Specify device and os_version for testing
//				caps.setCapability("device", propertyFile.getAndroidDeviceName());
//				caps.setCapability("os_version", propertyFile.getAndroidVersion());
//
//				// Set other BrowserStack capabilities
//				caps.setCapability("project",propertyFile.getProjectName());
//				caps.setCapability("build", "Android Execution "+propertyFile.getAndroidVersion());

				// Set URL of the application under test
				caps.setCapability("browserName", "chrome");

				// Specify device and os_version for testing
				caps.setCapability("deviceName", "Samsung Galaxy S20");
				caps.setCapability("os_version", "10");


				// Set other BrowserStack capabilities
				caps.setCapability("projectName", "Eportal");
				caps.setCapability("buildName", "3.0");

				
				driver = new RemoteWebDriver(new URL(browserstack_url), caps);

				driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		else if (OSVersion.equalsIgnoreCase("desktop")) {
			platform = OSVersion;
			try {
				DesiredCapabilities caps = new DesiredCapabilities();
				// Set your access credentials
				caps.setCapability("browserstack.user", "prasannakalkar_dqRD0c");
				caps.setCapability("browserstack.key", "kWfaK6EyXtNypGezcpnG");
				
				// Set URL of the application under test
				caps.setCapability("os", "Windows");
				caps.setCapability("browserName", "Edge");

				// Specify device and os_version for testing
				caps.setCapability("browserVersion", "102.0");
				caps.setCapability("osVersion", "10");


				// Set other BrowserStack capabilities
				caps.setCapability("projectName", "Eportal");
				caps.setCapability("buildName", "5.0");

				// Initialise the remote Webdriver using BrowserStack remote URL and desired capabilities defined above
				
				driver = new RemoteWebDriver(new URL(browserstack_url), caps);

				driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);


			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public String generateEmailId() {

		return (RandomStringUtils.randomAlphabetic(5));

	}


}
