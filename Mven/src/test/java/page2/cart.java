package page2;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import page1.cartpagee;
import page1.homepagee;
import page1.loginpagee;
import page1.productpagee;
import page1.signuppagee;
import utilities.datacart;

public class cart extends base {
	productpagee Productpage;
	cartpagee cartpage;
	loginpagee Loginpage;
	signuppagee Signup;

	@Test(priority = 11, dataProviderClass = datacart.class, dataProvider = "subscriptionincartpage")
	public void verifyScriptionInCartPage(String email) {
		homepage = new homepagee(driver);
		homepage.clickCartButton();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(1349,294.59)");
		homepage.verifyTextSubscription();
		homepage.enterSubscriptionID(email);
		homepage.clickSubscribeButton();
		homepage.verifySuccessMessage();
	}

	@Test(priority = 12)
	public void addProductsInCart() throws Exception {
		Productpage = new productpagee(driver);
		cartpage = new cartpagee(driver);
		homepage = new homepagee(driver);

		homepage.clickProductsButton();
		Productpage.hoverFirstProduct();
		Productpage.clickAddToCartOne();
		Productpage.clickContinueShoppingButton();
		Productpage.hoverSecondProduct();
		Productpage.clickAddToCartTwo();
		Productpage.clickViewCartbutton();
		Productpage.productName();
		cartpage.secondProductName();
		Productpage.price();
		cartpage.firstQuantity();
		cartpage.totalFirst();
		cartpage.priceSecond();
		cartpage.secondQuantity();
		cartpage.total();
	}

	@Test(priority = 13, dataProviderClass = datacart.class, dataProvider = "verifyProductQuantityInCart")
	public void verifyProductQuantityInCart(String quantity) throws Exception {
		Productpage = new productpagee(driver);
		cartpage = new cartpagee(driver);
		homepage = new homepagee(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(600,800)");
		homepage.hoverOnHomePageProductOne();
		Productpage.productName();
		Productpage.category();
		Productpage.price();
		Productpage.available();
		Productpage.condition();
		Productpage.condition();
		Productpage.Quantity(quantity);
		Productpage.addToCart();
		Productpage.clickViewCartbutton();
		cartpage.finalQuantity();
	}

	@Test(priority = 14, dataProviderClass = datacart.class, dataProvider = "registerWhileCheckout")
	public void registerWhileCheckout(String name, String email, String uname, String pwd, String day, String month,
			String year, String fname, String lname, String company, String add1, String add2, String country,
			String state, String city, String zipcode, String mobileNo, String description, String ename, String num,
			String cvc, String emonth, String eyear) throws Exception {
		Productpage = new productpagee(driver);
		cartpage = new cartpagee(driver);
		Signup = new signuppagee(driver);
		Loginpage = new loginpagee(driver);
		homepage = new homepagee(driver);

		homepage.scrollDown();
		homepage.hoverOnFirstProduct();
		Productpage.clickContinueShoppingButton();
		homepage.hoverOnSecondProduct();
		Productpage.clickViewCartbutton();
		homepage.clickCartButton();
		cartpage.verifyCartPageIsDisplayed();
		cartpage.clickProceedToCheckout();
		cartpage.clickRegisterButton();
		Loginpage.enterNameAndEmailID(name, email);
		Signup.clickMrradioButton();
		Signup.accountInformation(uname, pwd, day, month, year);
		Signup.addressInformation(fname, lname, company, add1, add2, country, state, city, zipcode, mobileNo);
		Signup.createAccount();
		Signup.verifyAccountCreated();
		Signup.clickContinue();
		homepage.verifyloggedAsUsername();
		homepage.clickCartButton();
		cartpage.clickProceedToCheckout();
		cartpage.verifyAddressDetails();
		cartpage.reviewOrder();
		cartpage.placeOrder();
		cartpage.enterDescription(description);
		cartpage.enterPaymentDetails(ename, num, cvc, emonth, eyear);
		cartpage.clickPayAndConfirm();
		cartpage.verifysuccessMessage();
		homepage.deleteAccount();
		homepage.verifyAccountDeletedIsVisible();
		Signup.clickContinue();
	}

	@Test(priority = 15, dataProviderClass = datacart.class, dataProvider = "registerBeforeCheckout")
	public void registerBeforeCheckout(String name, String email, String uname, String pwd, String day, String month,
			String year, String fname, String lname, String company, String add1, String add2, String country,
			String state, String city, String zipcode, String mobileNo, String description, String ename, String num,
			String cvc, String emonth, String eyear) throws Exception {
		Loginpage = new loginpagee(driver);
		Productpage = new productpagee(driver);
		cartpage = new cartpagee(driver);
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
		homepage.hoverOnFirstProduct();
		Productpage.clickContinueShoppingButton();
		homepage.hoverOnSecondProduct();
		Productpage.clickViewCartbutton();
		homepage.clickCartButton();
		cartpage.verifyCartPageIsDisplayed();
		cartpage.clickProceedToCheckout();
		cartpage.verifyAddressDetails();
		cartpage.reviewOrder();
		cartpage.placeOrder();
		cartpage.enterDescription(description);
		cartpage.enterPaymentDetails(ename, num, cvc, emonth, eyear);
		cartpage.clickPayAndConfirm();
		cartpage.verifysuccessMessage();
		homepage.deleteAccount();
		homepage.verifyAccountDeletedIsVisible();
		Signup.clickContinue();
	}

	@Test(priority = 16, dataProviderClass = datacart.class, dataProvider = "loginBeforeCheckout")
	public void loginBeforeCheckout(String email, String pwd, String description, String ename, String num, String cvc,
			String emonth, String eyear) {
		Loginpage = new loginpagee(driver);
		Productpage = new productpagee(driver);
		cartpage = new cartpagee(driver);
		Signup = new signuppagee(driver);
		homepage = new homepagee(driver);

		homepage.signinOrLogin();
		Loginpage.loginUser(email, pwd);
		homepage.verifyloggedAsUsername();
		homepage.hoverOnFirstProduct();
		Productpage.clickContinueShoppingButton();
		homepage.hoverOnSecondProduct();
		Productpage.clickViewCartbutton();
		homepage.clickCartButton();
		cartpage.verifyCartPageIsDisplayed();
		cartpage.clickProceedToCheckout();
		cartpage.verifyAddressDetails();
		cartpage.reviewOrder();
		cartpage.placeOrder();
		cartpage.enterDescription(description);
		cartpage.enterPaymentDetails(ename, num, cvc, emonth, eyear);
		cartpage.clickPayAndConfirm();
		cartpage.verifysuccessMessage();
		homepage.deleteAccount();
		homepage.verifyAccountDeletedIsVisible();
		Signup.clickContinue();
	}

	@Test(priority = 17)
	public void removeProductsFromCart() throws Exception {
		Loginpage = new loginpagee(driver);
		Productpage = new productpagee(driver);
		cartpage = new cartpagee(driver);
		homepage = new homepagee(driver);

		homepage.scrollDown();
		homepage.hoverOnFirstProduct();
		Productpage.clickContinueShoppingButton();
		homepage.hoverOnSecondProduct();
		Productpage.clickViewCartbutton();
		homepage.clickCartButton();
		cartpage.verifyCartPageIsDisplayed();
		cartpage.cancelProductOne();
		cartpage.verifyProductIsRemoved();
	}

	@Test(priority = 24, dataProviderClass = datacart.class, dataProvider = "downloadInvoiceAfterPurchaseOrder")
	public void downloadInvoiceAfterPurchaseOrder(String name, String email, String uname, String pwd, String day,
			String month, String year, String fname, String lname, String company, String add1, String add2,
			String country, String state, String city, String zipcode, String mobileNo, String description,
			String ename, String num, String cvc, String emonth, String eyear) throws Exception {
		Loginpage = new loginpagee(driver);
		Productpage = new productpagee(driver);
		cartpage = new cartpagee(driver);
		Signup = new signuppagee(driver);
		homepage = new homepagee(driver);

		homepage.scrollDown();
		homepage.hoverOnFirstProduct();
		Productpage.clickContinueShoppingButton();
		homepage.hoverOnSecondProduct();
		Productpage.clickViewCartbutton();
		homepage.clickCartButton();
		cartpage.clickProceedToCheckout();
		cartpage.clickRegisterButton();
		homepage.signinOrLogin();
		Loginpage.enterNameAndEmailID(name, email);
		Signup.clickMrradioButton();
		Signup.accountInformation(uname, pwd, day, month, year);
		Signup.addressInformation(fname, lname, company, add1, add2, country, state, city, zipcode, mobileNo);
		Signup.createAccount();
		Signup.verifyAccountCreated();
		Signup.clickContinue();
		homepage.verifyloggedAsUsername();
		homepage.clickCartButton();
		cartpage.clickProceedToCheckout();
		cartpage.verifyAddressDetails();
		cartpage.reviewOrder();
		cartpage.placeOrder();
		cartpage.enterDescription(description);
		cartpage.enterPaymentDetails(ename, num, cvc, emonth, eyear);
		cartpage.clickPayAndConfirm();
		cartpage.verifysuccessMessage();
		cartpage.downloadInvoice();
		cartpage.verifyInvoiceIsDownloaded();
		Signup.clickContinue();
		homepage.deleteAccount();
		homepage.verifyAccountDeletedIsVisible();
		Signup.clickContinue();
	}

}
			
		
		

