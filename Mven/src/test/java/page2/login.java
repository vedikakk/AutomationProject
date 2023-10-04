package page2;

import org.testng.annotations.Test;

import page1.homepagee;
import page1.loginpagee;
import page1.signuppagee;
import utilities.datalogin;

public class login extends base {
	loginpagee Loginpage;
	signuppagee Signup;

	@Test(priority = 2, dataProviderClass = datalogin.class, dataProvider = "validemailandpassword")
	public void verifyWithValidEmailAndPassword(String email, String password) {

		Loginpage = new loginpagee(driver);
		homepage = new homepagee(driver);

		homepage.signinOrLogin();
		Loginpage.verifyLoginToYourAccountIsVisible();
		Loginpage.loginUser(email, password);
		homepage.verifyloggedAsUsername();
		homepage.deleteAccount();
		homepage.verifyAccountDeletedIsVisible();
	}

	@Test(priority = 3, dataProviderClass = datalogin.class, dataProvider = "invalidemailandpassword")
	public void verifyWithInvalidEmailAndPassword(String email, String password) {
		Loginpage = new loginpagee(driver);
		homepage = new homepagee(driver);

		homepage.signinOrLogin();
		Loginpage.verifyLoginToYourAccountIsVisible();
		Loginpage.loginUser(email, password);
		Loginpage.verifyErrorMessage();
	}

	@Test(priority = 4, dataProviderClass = datalogin.class, dataProvider = "logoutUser")
	public void logoutUser(String email, String pwd) {
		Loginpage = new loginpagee(driver);
		homepage = new homepagee(driver);

		homepage.signinOrLogin();
		Loginpage.verifyLoginToYourAccountIsVisible();
		Loginpage.loginUser(email, pwd);
		homepage.verifyloggedAsUsername();
		homepage.clickLogout();
		Loginpage.verifyUserIsNavigatedToLoginPage();
	}

	@Test(priority = 5, dataProviderClass = datalogin.class, dataProvider = "registeruserwithexistingemail")
	public void verifyRegisterUserWithExistingEmail(String name, String email) {
		Loginpage = new loginpagee(driver);

		homepage.signinOrLogin();
		Loginpage.enterNameAndEmailID(name, email);
		Loginpage.verifySecondErrorMessage();
	}

}
