package SelCourse.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.landingPage;

public class validateTitle extends base{
	private static Logger log = LogManager.getLogger(validateTitle.class.getName());
	public WebDriver driver;
	@Test
	public void validationOfTitle() throws IOException
	{
	driver=initializeDriver();
	driver.get(prop.getProperty("url"));
	landingPage l=new landingPage(driver);
	String str=l.getTitle().getText();
	System.out.println(str);
	Assert.assertEquals(str, "Featured Courses");
	log.info("featured courses is validated");
	}
	
	@AfterMethod
	public void closeBrowser() throws IOException
	{
		driver.close();
	}
}
