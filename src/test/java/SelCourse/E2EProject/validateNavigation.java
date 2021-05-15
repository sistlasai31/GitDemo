package SelCourse.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.landingPage;

public class validateNavigation extends base{
	private static Logger log = LogManager.getLogger(validateNavigation.class.getName());
	public WebDriver driver;
	@Test
	public void validateNavigator() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		landingPage l=new landingPage(driver);
		Assert.assertTrue(l.getNavigation().isDisplayed());
		log.error("navigation page is validated");
	}
	@AfterMethod
	public void closeBrowser() throws IOException
	{
		driver.close();
	}
}
