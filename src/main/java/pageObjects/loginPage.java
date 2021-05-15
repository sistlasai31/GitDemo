package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	public WebDriver driver;
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//By login=By.xpath("//a[contains(@href,'sign_in')]");
	@FindBy(css="#user_email")
	WebElement username;
	
	public WebElement getUsername()
	{
		return username;
	}
	
	@FindBy(css="#user_password")
	WebElement password;
	
	public WebElement getPassword()
	{
		return password;
	}
	
	@FindBy(css="[name='commit']")
	WebElement loginBtn;
	
	public WebElement getloginBtn()
	{
		return loginBtn;
	}
}
