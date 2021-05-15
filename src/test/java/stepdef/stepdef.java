package stepdef;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import SelCourse.E2EProject.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import junit.framework.Assert;
import pageObjects.landingPage;
import pageObjects.loginPage;
import pageObjects.portalHomepage;

@RunWith(Cucumber.class)
	public class stepdef extends base{
	WebDriver driver;
	    @Given("^webdriver is initialized$")
	    public void webdriver_is_initialized() throws Throwable {
	    	driver = initializeDriver();
	    }

	    @When("^User logs into \"([^\"]*)\"$")
	    public void user_logs_into_something(String strArg1) throws Throwable {
	    	driver.get(strArg1);
			
	    }
	    @And("^clicks on login button$")
	    public void clicks_on_login_button() throws Throwable {
	    	landingPage l = new landingPage(driver);
			loginPage lp =l.getLogin();
	    }


	    @And("^enters username (.+) password (.+) and click login button$")
	    public void enters_username_password_and_click_login_button(String username, String password) throws Throwable {
	    	loginPage lp=new loginPage(driver);
	    	lp.getUsername().sendKeys(username);
			lp.getPassword().sendKeys(password);
			lp.getloginBtn().click();
	    }
	    	
		@Then("^Login is successful$")
	    public void login_is_successful() throws Throwable {
			portalHomepage p= new portalHomepage(driver);
			Assert.assertTrue("Searchbox is displayed", p.getSearchBox().isDisplayed());
	    }

	}
