package stepDefinations;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddCustomerPageObjects;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPageObjects;

public class Steps extends Base {
	
	@Before()
	public void setup() throws Exception
	{
		
		logger=Logger.getLogger("NOPCommerce");  //added logger
		PropertyConfigurator.configure("Log4J.properties");	
		
		configProps=new Properties();
		FileInputStream propertiesFile=new FileInputStream("config.properties");
		configProps.load(propertiesFile);
		
		String br=configProps.getProperty("browser");
		if(br.equals("chrome")) {
			// driver instance
			logger.info("*****Chrome Driver instance created*******");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			// driver instance
			logger.info("*****Firefox Driver instance created*******");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
				
		
		// pass driver instance to LoginPage class
		login = new LoginPage(driver);
		
		// pass driver instance to AddCustomerPageObjects class 
		addCust=new AddCustomerPageObjects(driver);
		
		// pass driver instance to SearchCustomerPageObjects class 
		searchCust=new SearchCustomerPageObjects(driver);
				
	}
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("User opens url {string}")
	public void user_opens_url(String url) throws Exception {
		
		
		logger.info("*****Browser Opened*******");
		
		// open website
		driver.get(url);
		
		logger.info("URL Is opened successfully");;
		
		// maximise browser window
		driver.manage().window().maximize();
	}

	@When("User enters email {string} and password {string}")
	public void user_enters_email_and_password(String email, String password) throws Exception {

		// enters username
		login.setTxtEmail(email);

		// enters password
		login.setTxtPassword(password);
		logger.info("****####****@@@@@*****&&&&&&&&");
		//takeScreenshotOfPage(driver,".\\Screenshots\\"+"Demo"+fileName);

	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
		// click on login button
		login.clickBtnLogin();

	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) throws Exception {
		// get the title of the page
		String actualTitle = driver.getTitle();

		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		
		//takeScreenshotOfPage(driver,".\\Screenshots\\"+"Demo"+fileName);

	}

	@When("User clicks on logout link")
	public void user_clicks_on_logout_link() throws InterruptedException {

		// click on logout link
		Thread.sleep(20000);
		login.clickLnkLogout();
		Thread.sleep(3000);
	}

	@Then("Close browser")
	public void close_browser() {
		// close browser
		driver.close();
	}
	
	// Add new customers actions
	

	@When("User clicks on Customers Menu")
	public void user_clicks_on_customers_menu() {
	    
	    addCust.clickOnCustomerMenu();
	}
	
	@Then("Customers Dashboard should be displayed")
	public void customers_dashboard_should_be_displayed() throws Exception {
	    Assert.assertEquals("Customers / nopCommerce administration", addCust.getPageTitle());
	    //takeScreenshotOfPage(driver,".\\Screenshots\\"+"Demo"+fileName);
	}
	
	@When("User clicks on First Customers option")
	public void user_clicks_on_first_customers_option() {
	    addCust.clickOnFirstCustomerOption();
	}
	
	@Then("Add a New Customer page should be displayed")
	public void add_a_new_customer_page_should_be_displayed() throws Exception {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
		takeScreenshotOfPage(driver,".\\Screenshots\\Screenshot4.png");
	}
	
	@When("User clicks on Add New button")
	public void user_clicks_on_add_new_button() {
	    addCust.addNewButton();
	}
	@When("User should enter customer information")
	public void user_should_enter_customer_information() throws Exception {
	    String email=genrateRandomString()+"@gmail.com";
	    addCust.setTxtEmail(email);
	    addCust.setTxtPassword("Abc123@");
	    addCust.setTxtFName("Raja");
	    addCust.setTxtLName("Mane");
	    addCust.setGender("Male");
	    addCust.setCldDOB("12/12/1997");
	    addCust.setTxtCompanyName("Google");
	    addCust.setNewsLetter("Your store name");
	    addCust.setCustomerRoles("Forum Moderators");
	    addCust.setManagerVendor("Vendor 1");
	    addCust.setTxtAdminComment("This is my new customer");
	    takeScreenshotOfPage(driver,".\\Screenshots\\Screenshot5.png");
	    
	}
	@When("User clicks on Save button")
	public void user_clicks_on_save_button() {
	    addCust.clickSaveButton();
	}
	@Then("Successful message {string} should be displayed")
	public void successful_message_should_be_displayed(String message) throws Exception {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	    takeScreenshotOfPage(driver,".\\Screenshots\\Screenshot6.png");
	}
	
	//search by email
	
	@When("User enters customer email")
	public void user_enters_customer_email() {		
		
		searchCust.setEmailtoSearch("james_pan@nopCommerce.com");
	}
	@When("Click on search button")
	public void click_on_search_button() {
	    searchCust.clickButtonSearch();
	}
	
	@Then("User should found email in the table")
	public void user_should_found_email_in_the_table() {
		boolean status=searchCust.searchCustomerByEmail("james_pan@nopCommerce.com");
		Assert.assertEquals(true, status);
		
	}




}
