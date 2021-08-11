package Googlesearchnew.Googlesearchnew;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Searchnew 
{

@BeforeTest

public void start()

{
	
	System.out.println("Program starting");	
	
}

	
	
@Test
public  void test()
{
	

System.setProperty("webdriver.chrome.driver","chromedriver.exe");

WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();

driver.manage().deleteAllCookies();

driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

driver.get("https://www.google.com/");

driver.findElement(By.name("q")).sendKeys("YouTube");

WebElement searchIcon = driver.findElement(By.name("btnK"));
searchIcon.click();

driver.quit();
}



@AfterTest

public void Endtest()
{
	
	System.out.println("Program ending");	
}
}

