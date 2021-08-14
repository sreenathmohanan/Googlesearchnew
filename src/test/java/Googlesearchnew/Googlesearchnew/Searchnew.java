package Googlesearchnew.Googlesearchnew;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Searchnew 
{

WebDriver driver;
public static final String USERNAME= "sso-aa-Sharath.Madananth";
public static final String ACCESS_KEY= "ffa62482-99ff-45c3-8044-557e05d6e503";
public static final String URL= "https://" + USERNAME + ":" + ACCESS_KEY +"@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	
@Parameters({"browser"})	
@Test
public void Login(String browser) throws MalformedURLException

{

	System.out.println("Launching browser "+ browser );	
	
	if(browser.equals("chrome"))
		
	{
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");

	    driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.google.com/");

		driver.findElement(By.name("q")).sendKeys("YouTube");

		WebElement searchIcon = driver.findElement(By.name("btnK"));
		searchIcon.click();
		
		
	}
	
	else if(browser.equals("chrome_remote"))
		
	{
		

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("username", "SAUCE_USERNAME");
		capabilities.setCapability("accessKey", "SAUCE_ACCESS_KEY");
		capabilities.setCapability("platform", "Windows 10");
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("version", "latest");
		capabilities.setCapability("name", "Test");
		capabilities.setCapability("screenResolution", "1280x800");		
		driver = new RemoteWebDriver(new java.net.URL(URL), capabilities);
		driver.get("https://www.google.com/");

		driver.findElement(By.name("q")).sendKeys("YouTube");

		WebElement searchIcon = driver.findElement(By.name("btnK"));
		searchIcon.click();
		
		
	}


driver.quit();
}


}

