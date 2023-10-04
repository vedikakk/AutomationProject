package page1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import page2.base;

public class contactuspagee extends base{
	@FindBy(xpath="//*[text()=\"Get In Touch\"]")public WebElement get_in_touch;
	@FindBy(xpath="//*[@name=\"name\"]")WebElement name;
	@FindBy(xpath="//*[@name=\"email\"]")WebElement emailId;
	@FindBy(xpath="//*[@name=\"subject\"]")WebElement subject;
	@FindBy(xpath="//*[@name=\"message\"]")WebElement message;
	@FindBy(xpath = "//*[@name=\"upload_file\"]")WebElement upload_file;
	@FindBy(xpath = "//*[@name=\"submit\"]")WebElement submit;
	@FindBy(xpath="//*[@class=\"status alert alert-success\"]")public WebElement success_msg;
	@FindBy(xpath="//*[@id=\"form-section\"]/a/span")WebElement home_button;
	
	public contactuspagee(WebDriver d){
		driver=d;
		PageFactory.initElements(driver, this);
	}
	public void verifyGetInTouchIsVisible() {
		 String expected="GET IN TOUCH";
		 String actual=get_in_touch.getText();
		 Assert.assertEquals(actual, expected);
	}
	public void clickOKButton() {
		 Alert a=driver.switchTo().alert();
		 a.accept();
	}
	public void verifySuccessMessage() {
		String expected_msg="Success! Your details have been submitted successfully.";
		 String actual_msg=success_msg.getText();
		 Assert.assertEquals(actual_msg, expected_msg);
	}
	public void verifyLandedOnHomePage() {
		 String expected_homepage="Automation Exercise";
		 String actual_homepage=driver.getTitle();
		 Assert.assertEquals(actual_homepage, expected_homepage);
	}
	public void enterDetails(String name,String email,String sub,String msg) {
		this.name.sendKeys(name);
		emailId.sendKeys(email);
		subject.sendKeys(sub);
		message.sendKeys(msg);
	}
	public void uploadFile(String file) {
		upload_file.sendKeys(file);
	}
	public void clickSubmit() {
		submit.click();
	}
	public void clickHomeButton() {
		home_button.click();
	}
}
