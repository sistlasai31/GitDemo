package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage {

	public WebDriver driver;
	public landingPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//By login=By.xpath("//a[contains(@href,'sign_in')]");
	@FindBy(xpath="//a[contains(@href,'sign_in')]")
	private WebElement login;
	
	public loginPage getLogin()
	{
		login.click();
		loginPage lp=new loginPage(driver);
		return lp;
	}
	
	private By title=By.cssSelector("div.pull-left h2");
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	private By navigation=By.cssSelector(".navigation.clearfix");
	public WebElement getNavigation()
	{
		return driver.findElement(navigation);
	}
}
