package SelCourse.E2EProject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;

public class HomePage extends base {
	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	public WebDriver driver;
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		landingPage l = new landingPage(driver);
		loginPage lp =l.getLogin();
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getloginBtn().click();
		log.info("Login is successful");
		log.info("Login is successful");
		log.info("Login is successful");
		log.info("Login is successful");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "username@gmail.com";
		data[0][1] = "password";
		data[1][0] = "username1@gmail.com";
		data[1][1] = "password1";
		return data;
	}

	@AfterMethod
	public void closeBrowser() throws IOException {
		driver.close();
	}

}
