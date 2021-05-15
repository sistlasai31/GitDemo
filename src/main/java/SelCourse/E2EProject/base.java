package SelCourse.E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\main\\java\\res\\data.properties");
		prop.load(fis);
		//String browserName=System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			ChromeOptions options= new ChromeOptions();
			if(browserName.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		} 
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenshot(String test,WebDriver driver) throws IOException
	{
		TakesScreenshot t=(TakesScreenshot)driver;
		File source=t.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"//reports//"+test+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		}
}
