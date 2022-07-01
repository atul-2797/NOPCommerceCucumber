package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.Before;
import javafx.util.Duration;
import utilities.WaitHelper;

public class SearchCustomerPageObjects {
	
	public WebDriver ldriver;
	public WaitHelper waitHelper;
	
	public SearchCustomerPageObjects(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(ldriver, this);
		waitHelper=new WaitHelper(ldriver);
	}
	
	
		
	@FindBy(how=How.ID,using="SearchEmail")
	WebElement txtSearchEmail;
	
	@FindBy(how=How.ID,using="search-customers")
	WebElement buttonSearch;
	
	@FindBy(how=How.XPATH,using="//table[@role='grid']")
	WebElement tableSearchResult;
		
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']")
	WebElement table;
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']/tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']/tbody/tr/td")
	List<WebElement> tableColumns;
	
	public void setEmailtoSearch(String email) {
		waitHelper.waitForElement(txtSearchEmail, java.time.Duration.ofSeconds(10));
		txtSearchEmail.clear();
		txtSearchEmail.sendKeys(email);
	}
	
	public void clickButtonSearch() {
		buttonSearch.click();
	}
	
	public int numberOfRows() {
		int rows=tableRows.size();
		return rows;
	}
	
	public int numberOfCols() {
		int cols=tableColumns.size();
		return cols;
	}
	
	public boolean searchCustomerByEmail(String searchedEmail) {
		boolean flag=false;
		for(int i=1;i<=numberOfRows();i++) {
			
			String email=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			if(email.equals(searchedEmail)) {
				flag=true;
			}	
		}
		return flag;		
	}
	
}
