package stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddCustomerPageObjects;
import pageObjects.LoginPage;

public class Steps extends Base {

	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {

		// driver instance
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// pass driver instance to LoginPage class
		login = new LoginPage(driver);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("User opens url {string}")
	public void user_opens_url(String url) throws Exception {
		// open website
		driver.get(url);
		
		// maximise browser window
		driver.manage().window().maximize();
	}

	@When("User enters email {string} and password {string}")
	public void user_enters_email_and_password(String email, String password) throws Exception {

		// enters username
		login.setTxtEmail(email);

		// enters password
		login.setTxtPassword(password);
		
		takeScreenshotOfPage(driver,".\\Screenshots\\Screenshot1.png");

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
		
		takeScreenshotOfPage(driver,".\\Screenshots\\Screenshot2.png");

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
	    addCust=new AddCustomerPageObjects(driver);
	    addCust.clickOnCustomerMenu();
	}
	
	@Then("Customers Dashboard should be displayed")
	public void customers_dashboard_should_be_displayed() throws Exception {
	    Assert.assertEquals("Customers / nopCommerce administration", addCust.getPageTitle());
	    takeScreenshotOfPage(driver,".\\Screenshots\\Screenshot3.png");
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




}
