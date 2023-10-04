package page1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import page2.base;

public class loginpagee extends base{
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")WebElement emailID;
	@FindBy(xpath="//*[@name=\"password\"]")WebElement passWord;
	@FindBy(xpath="//*[text()=\"Login\"]")WebElement loginButton;
	@FindBy(xpath="//*[@name=\"name\"]")WebElement name;
	@FindBy(xpath="//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")WebElement emailAddress;
	@FindBy(xpath="//*[text()=\"Signup\"]")WebElement signUp;
	@FindBy(xpath="//*[text()=\"New User Signup!\"]")WebElement newUserSignup;
	@FindBy(xpath="//*[text()=\"Enter Account Information\"]")public WebElement accountInfo;
	@FindBy(xpath="//*[text()=\"Login to your account\"]")public WebElement loginToAccount;
	@FindBy(xpath = "//*[text()=\"Your email or password is incorrect!\"]")public WebElement incorrect_credentials;
	@FindBy(xpath="//*[text()=\"Email Address already exist!\"]")public WebElement email_exist;
	public loginpagee(WebDriver d){
		driver=d;
		PageFactory.initElements(driver, this);
	}
	public void enterNameAndEmailID(String uname,String email) {
		name.sendKeys(uname);
		emailAddress.sendKeys(email);
		signUp.click();
	}
	public void loginUser(String email,String pwd) {
		emailID.sendKeys(email);
		passWord.sendKeys(pwd);
		loginButton.click();
	}	
	public void verifyLoginToYourAccountIsVisible() {
		  boolean expected=loginToAccount.isDisplayed();
		  Assert.assertTrue(expected);
	}
	public void verifyErrorMessage() {
		String expected_errmsg="Your email or password is incorrect!";
		  String actual_errmsg=incorrect_credentials.getText();
		  Assert.assertEquals(actual_errmsg,expected_errmsg);
	}
	public void verifyUserIsNavigatedToLoginPage() {
		String expected_url="https://automationexercise.com/login";
		String actual_url=driver.getCurrentUrl();
		Assert.assertEquals(actual_url, expected_url);
	}
	public void verifySecondErrorMessage() {
		String expected_msg="Email Address already exist!";
		String actual_msg=email_exist.getText();
		Assert.assertEquals(actual_msg, expected_msg);
	}
}
