package page1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import page2.base;

public class signuppagee extends base{

	@FindBy(xpath="//*[@value=\"Mrs\"]")WebElement MrsButton;
	@FindBy(xpath="//*[@value=\"Mr\"]")WebElement MrButton;
	@FindBy(xpath="//*[@id=\"name\"]")WebElement Name;
	@FindBy(xpath="//*[@id=\"password\"]")WebElement password;
	@FindBy(xpath="//*[@id=\"newsletter\"]")WebElement newsletter;
	@FindBy(xpath="//*[@id=\"optin\"]")WebElement recieveOffers;
	@FindBy(xpath="//*[@id=\"days\"]")WebElement days;
	@FindBy(xpath="//*[@id=\"months\"]")WebElement months;
	@FindBy(xpath="//*[@id=\"years\"]")WebElement years;
	@FindBy(xpath="//*[@id=\"first_name\"]")WebElement fname;
	@FindBy(xpath="//*[@id=\"last_name\"]")WebElement lname;
	@FindBy(xpath ="//*[@id=\"company\"]")WebElement company;
	@FindBy(xpath="//*[@id=\"address1\"]")WebElement address1;
	@FindBy(xpath="//*[@id=\"address2\"]")WebElement address2;
	@FindBy(xpath="//*[@id=\"country\"]")WebElement country;
	@FindBy(xpath="//*[@id=\"state\"]")WebElement state;
	@FindBy(xpath="//*[@id=\"city\"]")WebElement city;
	@FindBy(xpath="//*[@id=\"zipcode\"]")WebElement zipcode;
	@FindBy(xpath="//*[@id=\"mobile_number\"]")WebElement mobile_number;
	@FindBy(xpath="//*[text()=\"Create Account\"]")WebElement create_account;
	@FindBy(xpath="//*[text()=\"Account Created!\"]")public WebElement account_created;
	@FindBy(xpath="//*[text()=\"Continue\"]")WebElement continue_button;
	@FindBy(xpath="//*[@id=\"card\"]")WebElement card;
	@FindBy(xpath="//*[@id=\"ad_iframe\"]")WebElement frame2;
	@FindBy(xpath="//*[@id=\"dismiss-button\"]/div/span")WebElement close_button;
	@FindBy(xpath="//*[@id=\"aswift_2\"]")WebElement frame1;
	
	
	public signuppagee(WebDriver d){
		driver=d;
		PageFactory.initElements(driver,this);
	}
	public void clickMrradioButton() {
		MrButton.click();
	}
	public void clickMrsradiobutton() {
		MrsButton.click();
	}
	public void accountInformation(String uname,String pwd,String day,String month,String year) throws Exception {
		Name.clear();
		Name.sendKeys(uname);
		password.clear();
		password.sendKeys(pwd);
		Select s=new Select(days);
		s.selectByValue(day);
		Select s1=new Select(months);
		s1.selectByVisibleText(month);
		Select s2=new Select(years);
		s2.selectByVisibleText(year);
		newsletter.click();
		recieveOffers.click();
		
	}
	public void addressInformation(String fname,String lname,String company,String add1,String add2,String country,String state,String city,String zipcode,String mobileNo) {
		this.fname.sendKeys(fname);
		this.lname.sendKeys(lname);
		this.company.sendKeys(company);
		address1.sendKeys(add1);
		address2.sendKeys(add2);
		Select s=new Select(this.country);
		s.selectByVisibleText(country);
		this.state.sendKeys(state);
		this.city.sendKeys(city);
		this.zipcode.sendKeys(zipcode);
		mobile_number.sendKeys(mobileNo);
		}
	public void createAccount() {
		create_account.click();
	}
	public void clickContinue() {
		continue_button.click();
	}
	
	public void adClose() {
		driver.switchTo().frame(frame1);
		driver.switchTo().frame(frame2);
		close_button.click();
		driver.switchTo().defaultContent();
	}
	public void verifyAccountCreated() {
		String expected="ACCOUNT CREATED!";
		String actual=account_created.getText();
		Assert.assertEquals(actual,expected);
	}
}