package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPageObjects;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPageObjects;
import utilities.WaitHelper;

public class Base {
	
	WebDriver driver;
	LoginPage login;
	AddCustomerPageObjects addCust;
	SearchCustomerPageObjects searchCust;
	WaitHelper waitHelper;
	
	public String genrateRandomString() {
		String randomEmail= RandomStringUtils.randomAlphabetic(5);
		return randomEmail;			
	}
	
	public static void takeScreenshotOfPage(WebDriver driver, String filePath) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
	    File srcFile = ts.getScreenshotAs(OutputType.FILE);
	    File trgFile=new File(filePath);
	    FileUtils.copyFile(srcFile, trgFile);
	}


}
