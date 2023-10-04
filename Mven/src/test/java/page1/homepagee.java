package page1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import page2.base;

public class homepagee extends base {

	@FindBy(xpath = "//*[text()=\" Signup / Login\"]")
	WebElement signUpButton;
	@FindBy(xpath = "//*[text()=\" Contact us\"]")
	WebElement contactUsButton;
	@FindBy(xpath = "//*[text()=\" Test Cases\"]")
	WebElement testcaseButton;
	@FindBy(xpath = "//*[text()=\" Products\"]")
	WebElement productsButton;
	@FindBy(xpath = "//*[text()=\" Cart\"]")
	WebElement cartButton;
	@FindBy(xpath = "//*[text()=\" Delete Account\"]")
	WebElement delete_account;
	@FindBy(xpath = "//*[text()=\"Account Deleted!\"]")
	public WebElement delete_Message;
	@FindBy(xpath = "//*[text()=\" Logged in as \"]")
	public WebElement logged_in_as;
	@FindBy(xpath = "//*[@href=\"/logout\"]")
	WebElement logout;
	@FindBy(xpath = "//*[text()=\"Test Cases\"]")
	public WebElement testCasetag;
	@FindBy(xpath = "//*[text()=\"Subscription\"]")
	public WebElement subscriptionTag;
	@FindBy(xpath = "//*[@id=\"susbscribe_email\"]")
	WebElement subscriptionID;
	@FindBy(xpath = "//*[@id=\"subscribe\"]/i")
	WebElement subscribeButton;
	@FindBy(xpath = "//*[text()=\"You have been successfully subscribed!\"]")
	public WebElement subscribed_msg;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]")
	public WebElement product_One;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[1]")
	public WebElement product_Two;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a")
	WebElement product_one_to_cart;
	@FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[1]/a")
	WebElement product_two_to_cart;
	@FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a")
	WebElement add_to_cart_One;
	@FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div[1]/div[3]/div/div[1]/div[1]/a")
	WebElement add_to_cart_Two;
	@FindBy(xpath = "//*[text()=\"recommended items\"]")
	WebElement rec_items;
	@FindBy(xpath = "//*[@id=\"recommended-item-carousel\"]/div/div[1]/div[1]/div/div/div/a")
	WebElement rec_product_to_cart;
	@FindBy(xpath = "//*[@id=\"scrollUp\"]/i")
	WebElement scrollUp;
	@FindBy(xpath = "//*[text()=\"Full-Fledged practice website for Automation Engineers\"]")
	WebElement text;
	@FindBy(xpath = "//*[@src=\"/static/images/home/logo.png\"]")
	WebElement logo;

	public homepagee(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	public void verifyPageISScrolledUp() {
		boolean expected = logo.isDisplayed();
		Assert.assertTrue(expected, "Scrolled Up");
	}

	public void verifyText() {
		boolean expected_text = text.isDisplayed();
		Assert.assertTrue(expected_text);
	}

	public void clickScrollUpArrow() {
		scrollUp.click();
	}

	public void verifyRecommendedItemsAreVisible() {
		boolean recommended = rec_items.isDisplayed();
		Assert.assertTrue(recommended);
	}

	public void addRecommendedItemToCart() {
		rec_product_to_cart.click();
	}

	public void signinOrLogin() {
		signUpButton.click();
	}

	public void deleteAccount() {
		delete_account.click();
	}

	public void clickLogout() {
		logout.click();
	}

	public void clickContactUs() {
		contactUsButton.click();
	}

	public void clickTestCaseButton() {
		testcaseButton.click();
	}

	public void clickProductsButton() {
		productsButton.click();
	}

	public void enterSubscriptionID(String email) {
		subscriptionID.sendKeys(email);
	}

	public void clickSubscribeButton() {
		subscribeButton.click();
	}

	public void clickCartButton() {
		cartButton.click();
	}

	public void hoverOnHomePageProductOne() {
		Actions a = new Actions(driver);
		a.moveToElement(product_One).build().perform();
	}

	public void hoverOnHomePageProductTwo() {
		Actions a = new Actions(driver);
		a.moveToElement(product_Two).build().perform();
	}

	public void addProductOneToCart() {
		product_one_to_cart.click();
	}

	public void addProductTwoToCart() {
		product_two_to_cart.click();
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
	}

	public void hoverOnFirstProduct() {
		Actions a = new Actions(driver);
		a.moveToElement(add_to_cart_One).click().perform();
	}

	public void hoverOnSecondProduct() {
		Actions a = new Actions(driver);
		a.moveToElement(add_to_cart_Two).click().perform();
	}

	public void scrollDownToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,9000)");
	}

	public void verifyloggedAsUsername() {
		boolean title = logged_in_as.getText().contains("Logged in as");
		Assert.assertTrue(title);
	}

	public void verifySubscriptionTag() {
		String exp_tag = "SUBSCRIPTION";
		String act_tag = subscriptionTag.getText();
		Assert.assertEquals(act_tag, exp_tag);
	}

	public void verifySuccessMessage() {
		String expected_msg = "You have been successfully subscribed!";
		String actual_msg = subscribed_msg.getText();
		Assert.assertEquals(actual_msg, expected_msg);
	}

	public void verifyUserNavigatedToTestcasePage() {
		String expected_headding = "TEST CASES";
		String actual_headding = testCasetag.getText();
		Assert.assertEquals(actual_headding, expected_headding);
	}

	public void verifyAccountDeletedIsVisible() {
		String expected_del_message = "ACCOUNT DELETED!";
		String actual_del_message = delete_Message.getText();
		Assert.assertEquals(actual_del_message, expected_del_message);
	}

	public void verifyAccountCreatedIsVisible() {
		signuppagee signup = new signuppagee(driver);
		String expected = "ACCOUNT CREATED!";
		String actual = signup.account_created.getText();
		Assert.assertEquals(actual, expected);
	}

	public void verifyEnterAccountInformationIsVisible() {
		loginpagee loginpage = new loginpagee(driver);
		String expected_res = "ENTER ACCOUNT INFORMATION";
		String actual_res = loginpage.accountInfo.getText();
		Assert.assertEquals(actual_res, expected_res);
	}

	public void verifyTextSubscription() {
		String exp_sub = "SUBSCRIPTION";
		String act_sub = subscriptionTag.getText();
		Assert.assertEquals(act_sub, exp_sub);
	}

	public void scrollUpWithoutArrow() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-9000)");
	}

	public void verifyHomePageIsVisible() {
		String expected_title = "Automation Exercise";
		String actual_title = driver.getTitle();
		Assert.assertEquals(actual_title, expected_title);
		System.out.println("Home page is visible");
	}
}

	
