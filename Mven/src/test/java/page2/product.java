package page2;

import org.testng.annotations.Test;

import page1.cartpagee;
import page1.homepagee;
import page1.loginpagee;
import page1.productpagee;
import page1.signuppagee;
import utilities.dataproduct;

public class product extends base {
	productpagee Productpage;
	cartpagee cartpage;
	loginpagee Loginpage;

	@Test(priority = 8)
	public void verifyProductsAndProductsDetails() {
		Productpage = new productpagee(driver);
		homepage = new homepagee(driver);

		homepage.clickProductsButton();
		Productpage.verifyUserNavigatedToAllProductsPage();
		Productpage.clickViewProduct();
		Productpage.userIsLandedToProductDetailPage();
		Productpage.productName();
		Productpage.category();
		Productpage.price();
		Productpage.available();
		Productpage.condition();
		Productpage.brand();
	}

	@Test(priority = 9, dataProviderClass = dataproduct.class, dataProvider = "verifySearchProduct")
	public void verifySearchProduct(String product) {
		Productpage = new productpagee(driver);
		homepage = new homepagee(driver);

		homepage.clickProductsButton();
		Productpage.verifyUserNavigatedToAllProductsPage();
		Productpage.clickSearchButton(product);
		Productpage.verifySearchedProductsAreVisible();
		Productpage.scrollDownToSearchedProduct();
		Productpage.verifyProductsRelatedToSearchAreVisible();
	}

	@Test(priority = 18)
	public void verifyViewCategoryProducts() {
		Productpage = new productpagee(driver);
		homepage = new homepagee(driver);

		homepage.scrollDown();
		Productpage.positionOfCategory();
		Productpage.clickOnWomenCategory();
		Productpage.clickOnDress();
		Productpage.verifyCategoryPageDisplayedAndConfirmtext();
		Productpage.clickOnMenCategory();
		Productpage.clickOnTshirts();
		Productpage.verifyUserNavigatedToCategoryPage();
	}

	@Test(priority = 19)
	public void verifyViewAndCartBrandProducts() {
		Productpage = new productpagee(driver);
		homepage = new homepagee(driver);
		;

		homepage.clickProductsButton();
		Productpage.scrollDownToBrands();
		Productpage.positionOfBrands();
		Productpage.clickOnPOLO();
		Productpage.verifyBrandPageIsDisplayedAndConfirmText();
		Productpage.clickOnHMBrand();
		Productpage.verifyHMBrandPage();
	}

	@Test(priority = 20, dataProviderClass = dataproduct.class, dataProvider = "searchProductAndVerifyCartAfterLogin")
	public void searchProductAndVerifyCartAfterLogin(String pname, String email, String password) {
		Productpage = new productpagee(driver);
		cartpage = new cartpagee(driver);
		Loginpage = new loginpagee(driver);
		homepage = new homepagee(driver);

		homepage.clickProductsButton();
		Productpage.verifyUserNavigatedToAllProductsPage();
		Productpage.clickSearchButton(pname);
		Productpage.verifySearchedProductsAreVisible();
		Productpage.scrollDownToProduct();
		Productpage.hoverOnSummerWhiteTop();
		Productpage.clickViewCartbutton();
		homepage.clickCartButton();
		cartpage.verifyProductIsVisibleInCart();
		homepage.signinOrLogin();
		Loginpage.loginUser(email, password);
		homepage.clickCartButton();
		cartpage.verifyProductIsVisibleInCart();
	}

	@Test(priority = 21)
	public void addReviewOnProduct(String ename, String mail, String rev) {
		Productpage = new productpagee(driver);
		homepage = new homepagee(driver);

		homepage.clickProductsButton();
		Productpage.verifyUserNavigatedToAllProductsPage();
		Productpage.scrollDownToProduct();
		Productpage.hoverFirstProduct();
		Productpage.clickViewProduct();
		Productpage.verifyWriteYourReviewIsVisible();
		Productpage.writeReview(ename, mail, rev);
		Productpage.clickReviewSubmitButton();
		Productpage.verifySuccessMessage();
	}
}