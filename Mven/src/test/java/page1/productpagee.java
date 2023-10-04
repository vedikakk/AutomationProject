package page1;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import page2.base;

public class productpagee extends base{
	productpagee productpage;
	
	@FindBy(xpath="//*[text()=\"All Products\"]")public WebElement allProducts;
	@FindBy(xpath="/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div/div[2]/ul/li/a")WebElement view_product;
	@FindBy(xpath="//*[text()=\"Blue Top\"]")public WebElement product_name;
	@FindBy(xpath="//*[text()=\"Category: Women > Tops\"]")public WebElement category;
	@FindBy(xpath="//*[text()=\"Availability:\"]")public WebElement availabality;
	@FindBy(xpath="//*[text()=\"Condition:\"]")public WebElement condition;
	@FindBy(xpath="//*[text()=\"Brand:\"]")public WebElement brand;
	@FindBy(xpath="//*[text()=\"Rs. 500\"]")public WebElement price;
	@FindBy(xpath="//*[@id=\"search_product\"]")public WebElement searchProduct;
	@FindBy(xpath="//*[@id=\"submit_search\"]")WebElement submitSearch;
	@FindBy(xpath="//*[text()=\"Summer White Top\"]")public WebElement white_top;
	@FindBy(xpath="//*[text()=\"Searched Products\"]")public WebElement searched_product;
	@FindBy(xpath="/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div[1]")public WebElement second_product;
	@FindBy(xpath = "/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div[1]/div[1]/div[1]")public WebElement first_product;
	@FindBy(xpath="/html/body/section[2]/div[1]/div/div[2]/div/div[2]/div[1]/div[1]/div[1]/a")WebElement add_to_Cart_One;
	@FindBy(xpath="/html/body/section[2]/div[1]/div/div[2]/div/div[3]/div/div[1]/div[1]/a")WebElement add_to_Cart_Two;
	@FindBy(xpath="//*[text()=\"Continue Shopping\"]")public WebElement continue_shopping;
	@FindBy(xpath="//*[text()=\"View Cart\"]")WebElement view_cart;
	@FindBy(xpath="//*[@id=\"quantity\"]")WebElement quantity;
	@FindBy(xpath="/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")WebElement add_to_cart;
	@FindBy(xpath="//*[text()=\"Women - Dress Products\"]")WebElement confirm_text_women;
	@FindBy(xpath="//*[@href=\"#Women\"]")WebElement women_category;
	@FindBy(xpath="//*[@href=\"/category_products/1\"]")WebElement dress;
	@FindBy(xpath="//*[@href=\"#Men\"]")WebElement men_category;
	@FindBy(xpath="//*[text()=\"Tshirts \"]")WebElement tshirts_subcategory;
	@FindBy(xpath="//*[text()=\"Men - Tshirts Products\"]")WebElement confirm_text_men;
	@FindBy(xpath="//*[text()=\"Category\"]")WebElement category_page;
	@FindBy(xpath="//*[text()=\"Brands\"]")WebElement brands_page;
	@FindBy(xpath="//*[text()=\"Polo\"]")WebElement polo_brand;
	@FindBy(xpath="//*[text()=\"Brand - Polo Products\"]")WebElement brand_text;
	@FindBy(xpath="//*[text()=\"H&M\"]")WebElement hm_brand;
	@FindBy(xpath="/html/body/section/div/div[1]/ol/li[2]")WebElement hm_page;
	@FindBy(xpath="//*[text()=\"Brand - H&M Products\"]")WebElement hm_products;
	@FindBy(xpath="/html/body/section/div/div[1]/ol/li[2]")WebElement polo_page;
	@FindBy(xpath="/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a")WebElement product_white_top;
	@FindBy(xpath="//*[text()=\"Write Your Review\"]")WebElement write_review_text;
	@FindBy(xpath="//*[@id=\"name\"]")WebElement enter_name;
	@FindBy(xpath="//*[@id=\"email\"]")WebElement enter_email;
	@FindBy(xpath="//*[@id=\"review\"]")WebElement review;
	@FindBy(xpath="//*[@id=\"button-review\"]")WebElement submit_button;
	@FindBy(xpath="//*[text()=\"Thank you for your review.\"]")WebElement thanks_message;
	
	public productpagee(WebDriver d){
		driver=d;
		PageFactory.initElements(driver,this);
	}
	public void userIsLandedToProductDetailPage() {
		 String expected_url="https://automationexercise.com/product_details/1";
		 String actual_url=driver.getCurrentUrl();
		 Assert.assertEquals(actual_url, expected_url);
	}
	public void productName() {
		boolean actual_product=product_name.getText().contains("Blue Top");
		Assert.assertTrue(actual_product);
	}
	public void category() {
		boolean actual_res=category.getText().contains("Category:");
		Assert.assertTrue(actual_res);
	}
	public void price() {
		boolean actual_price=price.getText().contains("Rs. 500");
		Assert.assertTrue(actual_price);
	}
	public void available() {
		 boolean actual_avl=availabality.getText().contains("Availability");
		 Assert.assertTrue(actual_avl);
	}
	public void condition() {
		 boolean actual_condition=condition.getText().contains("Condition");
		 Assert.assertTrue(actual_condition);
	}
	public void brand() {
		boolean actual_brand=brand.getText().contains("Brand");
		Assert.assertTrue(actual_brand);
	}
	public void writeReview(String ename,String mail,String rev) {
		enter_name.sendKeys(ename);
		enter_email.sendKeys(mail);
		review.sendKeys(rev);
	}
	public void verifySuccessMessage() {
		boolean success_msg=thanks_message.isDisplayed();
		SoftAssert s=new SoftAssert();
		s.assertEquals(success_msg, true);
	}
	public void clickReviewSubmitButton() {
		submit_button.click();
	}
	public void clickViewProduct() {
		view_product.click();
	}
	public void clickSearchButton(String pname) {
		searchProduct.sendKeys(pname);
		submitSearch.click();
	}
	public void hoverFirstProduct() {
		Actions a=new Actions(driver);
		a.moveToElement(first_product).perform();
	}
	public void hoverSecondProduct() {
		Actions a2=new Actions(driver);
		a2.moveToElement(second_product).perform();
	}
	public void clickAddToCartOne() {
		add_to_Cart_One.click();
	}
	public void clickAddToCartTwo() {
		add_to_Cart_Two.click();
	}
	public void clickContinueShoppingButton() {
		continue_shopping.click();
	}
	public void clickViewCartbutton() {
		view_cart.click();
	}
	public void Quantity(String value) {
		quantity.click();
		quantity.clear();
		quantity.sendKeys(value);
	
			}
	public void addToCart() {
		add_to_cart.click();
	}
	public void verifyCategoryPageDisplayedAndConfirmtext() {
		productpage=new productpagee(driver);
		Assert.assertTrue(productpage.category_page.isDisplayed());
		String expected_text="WOMEN - DRESS PRODUCTS";
		String actual_text=confirm_text_women.getText();
		Assert.assertEquals(actual_text,expected_text);
	}
	public void clickOnWomenCategory() {
		women_category.click();
	}
	public void clickOnDress() {
		dress.click();
	}
	public void clickOnMenCategory() {
		men_category.click();
	}
	public void clickOnTshirts() {
		tshirts_subcategory.click();
	}
	public void verifyUserNavigatedToCategoryPage() {
		String expected="MEN - TSHIRTS PRODUCTS";
		String actual=confirm_text_men.getText();
		Assert.assertEquals(actual,expected);
	}
	public void scrollDownToBrands() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,750)");
	}
	public void positionOfCategory() {
		org.openqa.selenium.Point p=category_page.getLocation();
		int xpos=p.getX();
		int ypos=p.getY();
		System.out.println(category_page.getLocation());
		Assert.assertTrue((xpos==104)&&(ypos==619));
		System.out.println("The categories are visible in left side bar");
	}
	public void positionOfBrands() {
		org.openqa.selenium.Point p=brands_page.getLocation();
		int xposs=p.getX();
		int yposs=p.getY();
		System.out.println(brands_page.getLocation());
		Assert.assertTrue((xposs==p.getX())&&(yposs==p.getY()));
		System.out.println("The Brands are visible in left side bar");
	}
	public void clickOnPOLO() {
		polo_brand.click();
	}
	public void verifyBrandPageIsDisplayedAndConfirmText() {
		productpage=new productpagee(driver);
		Assert.assertTrue(productpage.polo_page.isDisplayed());
		String expected_text="BRAND - POLO PRODUCTS";
		String actual_text=brand_text.getText();
		Assert.assertEquals(actual_text,expected_text);
	}
	public void clickOnHMBrand() {
		hm_brand.click();
	}
	public void verifyHMBrandPage() {
		Assert.assertTrue(hm_page.isDisplayed());
		String expected="BRAND - H&M PRODUCTS";
		String actual=hm_products.getText();
		Assert.assertEquals(actual,expected);
	}
	public void verifySearchedProductsAreVisible() {
		boolean search=searched_product.isDisplayed();
		Assert.assertTrue(search);
	}
	public void verifyUserNavigatedToAllProductsPage() {
		 String expected_page="ALL PRODUCTS";
		 String actual_page=allProducts.getText();
		 Assert.assertEquals(actual_page,expected_page);
	}
	public void scrollDownToSearchedProduct() {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(500,600)");
	}
	public void verifyProductsRelatedToSearchAreVisible() {
		String expected_product="Summer White Top";
		String actual_product=productpage.white_top.getText();
		Assert.assertEquals(actual_product, expected_product);
	}
	public void scrollDownToProduct() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
}
	public void hoverOnSummerWhiteTop() {
		Actions a=new Actions(driver);
		a.moveToElement(product_white_top).click().perform();
	}
	public void verifyWriteYourReviewIsVisible() {
		boolean review=write_review_text.isDisplayed();
		Assert.assertTrue(review);
	}
}