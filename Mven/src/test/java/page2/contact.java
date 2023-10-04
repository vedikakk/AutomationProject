package page2;

import org.testng.annotations.Test;

import page1.contactuspagee;
import page1.homepagee;
import utilities.datacontact;

public class contact extends base {
	contactuspagee contactpage;

	@Test(priority = 6, dataProviderClass = datacontact.class, dataProvider = "verifyContactUsForm")
	public void verifyContactUsForm(String name, String email, String sub, String msg, String path) {
		homepage = new homepagee(driver);
		contactpage = new contactuspagee(driver);

		homepage.clickContactUs();
		contactpage.verifyGetInTouchIsVisible();
		contactpage.enterDetails(name, email, sub, msg);
		contactpage.uploadFile(path);
		contactpage.clickSubmit();
		contactpage.clickOKButton();
		contactpage.verifySuccessMessage();
		contactpage.clickHomeButton();
		contactpage.verifyLandedOnHomePage();

	}
}