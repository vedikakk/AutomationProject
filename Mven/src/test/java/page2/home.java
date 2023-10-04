package page2;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import page1.cartpagee;
import page1.homepagee;
import page1.loginpagee;
import page1.productpagee;
import page1.signuppagee;
import utilities.datahome;

public class home extends base {
	productpagee Productpage;
	cartpagee cartpage;
	loginpagee Loginpage;
	signuppagee Signup;

	@Test(priority = 1, dataProviderClass = datahome.class, dataProvider = "RegisterUser")
	public void RegisterUser(String name, String email, String uname, String pwd, String day, String month, String year,
			String fname, String lname, String company, String add1, String add2, String country, String state,
			String city, String zipcode, String mobileNo) throws Exception {
		Loginpage = new loginpagee(driver);
		Signup = new signuppagee(driver);

		homepage = new homepagee(driver);

		homepage.signinOrLogin();
		Loginpage.enterNameAndEmailID(name, email);
		homepage.verifyEnterAccountInformationIsVisible();
		Signup.clickMrradioButton();
		Signup.accountInformation(uname, pwd, day, month, year);
		Signup.addressInformation(fname, lname, company, add1, add2, country, state, city, zipcode, mobileNo);
		Signup.createAccount();
		homepage.verifyAccountCreatedIsVisible();
		Signup.clickContinue();
		Signup.adClose();
		homepage.verifyloggedAsUsername();
		homepage.deleteAccount();
		homepage.verifyAccountDeletedIsVisible();
		Signup.clickContinue();
	}

	@Test(priority = 7)
	public void verifyTestCasesPage() {
		homepage = new homepagee(driver);

		homepage.clickTestCaseButton();
		homepage.verifyUserNavigatedToTestcasePage();
	}

	@Test(priority = 10, dataProviderClass = datahome.class, dataProvider = "verifySubscriptionInHomePage")
	public void verifySubscriptionInHomePage(String subID) {
		homepage = new homepagee(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(1349,294.59)");
		homepage.verifySubscriptionTag();
		homepage.enterSubscriptionID(subID);
		homepage.clickSubscribeButton();
		homepage.verifySuccessMessage();
	}

	@Test(priority = 22)
	public void addToCartFromRecommendedItems() {
		Productpage = new productpagee(driver);
		cartpage = new cartpagee(driver);
		homepage = new homepagee(driver);

		homepage.scrollDownToBottom();
		homepage.verifyRecommendedItemsAreVisible();
		homepage.addRecommendedItemToCart();
		Productpage.clickViewCartbutton();
		cartpage.verifyProductIsDisplayedInCart();
	}

	@Test(priority = 23, dataProviderClass = datahome.class, dataProvider = "verifyAddressDetailsInCheckoutPage")
	public void verifyAddressDetailsInCheckoutPage(String name, String email, String uname, String pwd, String day,
			String month, String year, String fname, String lname, String company, String add1, String add2,
			String country, String state, String city, String zipcode, String mobileNo) throws Exception {
		Productpage = new productpagee(driver);
		cartpage = new cartpagee(driver);
		Loginpage = new loginpagee(driver);
		Signup = new signuppagee(driver);
		homepage = new homepagee(driver);

		homepage.signinOrLogin();
		Loginpage.enterNameAndEmailID(name, email);
		Signup.clickMrradioButton();
		Signup.accountInformation(uname, pwd, day, month, year);
		Signup.addressInformation(fname, lname, company, add1, add2, country, state, city, zipcode, mobileNo);
		Signup.createAccount();
		Signup.clickContinue();
		homepage.verifyloggedAsUsername();
		homepage.scrollDown();
		homepage.hoverOnFirstProduct();
		Productpage.clickContinueShoppingButton();
		homepage.hoverOnSecondProduct();
		Productpage.clickViewCartbutton();
		homepage.clickCartButton();
		cartpage.verifyCartPageIsDisplayed();
		cartpage.clickProceedToCheckout();
		cartpage.compareDeliveryAddressWithRegisteredAddress();
		cartpage.compareBillingAddressWithRegisteredAddress();
		homepage.deleteAccount();
		homepage.verifyAccountDeletedIsVisible();
		Signup.clickContinue();
	}

	@Test(priority = 25)
	public void verifyScrollUpWithArrowAndScrollDown() {
		homepage = new homepagee(driver);

		homepage.scrollDownToBottom();
		homepage.verifyTextSubscription();
		homepage.clickScrollUpArrow();
		homepage.verifyPageISScrolledUp();
		homepage.verifyText();
	}

	@Test(priority = 26)
	public void verifyScrollUpWithoutArrow() {
		homepage = new homepagee(driver);

		homepage.scrollDownToBottom();
		homepage.verifyTextSubscription();
		homepage.scrollUpWithoutArrow();
		homepage.verifyPageISScrolledUp();
		homepage.verifyText();
	}
}