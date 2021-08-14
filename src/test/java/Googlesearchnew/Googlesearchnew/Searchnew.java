package Googlesearchnew.Googlesearchnew;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Searchnew 
{

WebDriver driver;
public static final String USERNAME= "sso-aa-Prashanth.Gurupadham";
public static final String ACCESS_KEY= "c846f278-bbb9-4d13-8410-b82054ef373e";
public static final String URL= "https://" + USERNAME + ":" + ACCESS_KEY +"@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	
@Parameters({"browser","url"})	
@Test(priority=1)
public void Login(String browser, String url) throws MalformedURLException

{

	System.out.println("Launching browser "+ browser );	
	
	if(browser.equals("chrome_pip"))
		
	{
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");

	    driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	else if(browser.equals("chrome_saucelab"))
		
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
	
	}
	
	driver.get(url);
}
	
	@Parameters({"username","password"})
	@Test(priority=2)
	
    public void logintest(String username, String password)
    {
		System.out.println("username is "+username +"password is "+password);
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("j_password")).sendKeys(password);
		
		driver.findElement(By.name("companyCode")).sendKeys("AA");
		driver.findElement(By.name("btOk")).click();
		driver.quit();
		
		
    }
	

}




