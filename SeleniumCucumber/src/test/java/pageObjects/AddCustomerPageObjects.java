package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPageObjects {
	
	public WebDriver adriver;
	
	public AddCustomerPageObjects(WebDriver driver) {
		adriver=driver;
		PageFactory.initElements(adriver, this);	}
	
	// All the Web Elements
	
	By custMenu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By custOption=By.xpath("(//p[contains(text(),'Customers')])[2]");
	
	By addCustButton=By.xpath("//a[normalize-space()='Add new']");
	
	By txtEmail=By.xpath("(//input[@id='Email'])[1]");
	By txtPassword=By.xpath("(//input[@id='Password'])[1]");
	By txtFName=By.xpath("(//input[@id='FirstName'])[1]");
	By txtLName=By.xpath("//input[@id='LastName']");
	
	By radioMale=By.xpath("//input[@id='Gender_Male']");
	By radioFemale=By.xpath("//input[@id='Gender_Female']");
	
	By cldDOB=By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName=By.xpath("//input[@id='Company']");
	
	By listNewsLetter=By.xpath("//div[@class='input-group-append']//div[@role='listbox']");
	By listYourStore=By.xpath("//option[normalize-space()='Your store name']");
	By listTestStore=By.xpath("//option[normalize-space()='Test store 2']");
	
	By drpCustomerRoles=By.xpath("//div[@class='input-group-append input-group-required']//div[@role='listbox']");
	By drpDownAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By drpDownForum=By.xpath("//li[contains(text(),'Forum Moderators')]");
	By drpDownGuests=By.xpath("//li[contains(text(),'Guests')]");
	By drpDownRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By drpDownVendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpDownManagerOfVendor=By.xpath("//select[@id='VendorId']");
	
	
	By txtAdminComment=By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave=By.xpath("//button[@name='save']");
	
	// Action Methods
	
	public String getPageTitle() {
		String pageTitle=adriver.getTitle();
		return pageTitle;
	}
	
	public void clickOnCustomerMenu() {
		adriver.findElement(custMenu).click();
	}
	
	public void clickOnFirstCustomerOption() {
		adriver.findElement(custOption).click();
	}
	
	public void addNewButton() {
		adriver.findElement(addCustButton).click();
	}

	public void setTxtEmail(String email) {
		adriver.findElement(txtEmail).sendKeys(email);
	}

	public void setTxtPassword(String password) {
		adriver.findElement(txtPassword).sendKeys(password);
	}

	public void setTxtFName(String fName) {
		adriver.findElement(txtFName).sendKeys(fName);
	}
	
	public void setTxtLName(String lName) {
		adriver.findElement(txtLName).sendKeys(lName);
	}
	
	public void setGender(String gender) {
		if(gender.equals("Male")) {
		adriver.findElement(radioMale).click();
		}
		else if(gender.equals("Female")) {
			adriver.findElement(radioFemale).click();
		}
		else
			adriver.findElement(radioMale).click();  //default
	}


	public void setCldDOB(String dateOfBirth) {
		adriver.findElement(cldDOB).sendKeys(dateOfBirth);
	}

	public void setTxtCompanyName(String companyName) {
		adriver.findElement(txtCompanyName).sendKeys(companyName);
	}
	
	public void setNewsLetter(String newsletter) {
		adriver.findElement(listNewsLetter).click();
			
		WebElement news;
		if(newsletter.equals("Your store name")) {
			news=adriver.findElement(listYourStore);
		}
		else if(newsletter.equals("Test store 2")){
			news=adriver.findElement(listTestStore);
		}
		else
			news=adriver.findElement(listTestStore);  //default
		
		//news.click();
		
		JavascriptExecutor js=(JavascriptExecutor) adriver;
		js.executeScript("arguments[0].click()", news);
			
	}

	public void setCustomerRoles(String role) {
		
		adriver.findElement(drpCustomerRoles).click();
		
		WebElement element;
		
		if(role.equals("Administrators")) {
			element=adriver.findElement(drpDownAdministrators);
		}
		else if(role.equals("Forum Moderators")) {
			element=adriver.findElement(drpDownForum);
		}
		else if(role.equals("Guests")) {
			element=adriver.findElement(drpDownGuests);
		}
		else if(role.equals("Registered")) {
			element=adriver.findElement(drpDownRegistered);
		}
		else if(role.equals("Vendors")) {
			element=adriver.findElement(drpDownVendors);
		}
		else {
			element=adriver.findElement(drpDownGuests);
		}
		
		//element.click();
		
		JavascriptExecutor js=(JavascriptExecutor) adriver;
		js.executeScript("arguments[0].click()", element);
	}	

	public void setManagerVendor(String value) {
		Select drpDown=new Select(adriver.findElement(drpDownManagerOfVendor));
		drpDown.selectByVisibleText(value);
	}
	
	
	public void setTxtAdminComment(String adminComment) {
		adriver.findElement(txtAdminComment).sendKeys(adminComment);
	}

	
	public void clickSaveButton() {
		adriver.findElement(btnSave).click();
		
	}
	
	
	
	
	
}
