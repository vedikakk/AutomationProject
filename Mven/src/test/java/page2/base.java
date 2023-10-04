package page2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import page1.homepagee;

public class base {
 public WebDriver driver;
 public homepagee homepage;

	@BeforeMethod
	public void launchApp() {
		System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver-v0.33.0-win64(1)\\geckodriver.exe");
				
		driver=new FirefoxDriver();
		driver.navigate().to("http://automationexercise.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homepage=new homepagee(driver);
		homepage.verifyHomePageIsVisible();
	}
	@AfterMethod
	public void closeApp() {
		driver.close();
	}
}