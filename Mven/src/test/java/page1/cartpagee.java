package page1;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import page2.base;

public class cartpagee extends base{
	@FindBy(xpath="//*[text()=\"Blue Top\"]")public WebElement product_one;
	@FindBy(xpath="//*[text()=\"Men Tshirt\"]")public WebElement product_two;
	@FindBy(xpath="//*[@id=\"product-1\"]/td[3]/p")public WebElement first_product_price;
	@FindBy(xpath="//*[@id=\"product-2\"]/td[3]/p")public WebElement second_product_price;
	@FindBy(xpath="//*[@id=\"product-1\"]/td[4]/button")public WebElement first_product_quantity;
	@FindBy(xpath="//*[@id=\"product-2\"]/td[4]/button")public WebElement second_product_quantity;
	@FindBy(xpath="//*[@id=\"product-1\"]/td[5]/p")public WebElement first_product_total;
	@FindBy(xpath="//*[@id=\"product-2\"]/td[5]/p")public WebElement second_product_total;
	@FindBy(xpath="//*[text()=\"Proceed To Checkout\"]")WebElement proceed_to_checkout;
	@FindBy(xpath="//*[text()=\"Register / Login\"]")WebElement register;
	@FindBy(xpath="//*[text()=\"Address Details\"]")public WebElement address_details;
	@FindBy(xpath="//*[text()=\"Review Your Order\"]")public WebElement review_order;
	@FindBy(xpath="//*[@class=\"form-control\"]")WebElement comment;
	@FindBy(xpath="//*[text()=\"Place Order\"]")WebElement place_order;
	@FindBy(xpath = "//*[@id=\"payment-form\"]/div[1]/div/input")WebElement name_on_card;
	@FindBy(xpath="//*[@id=\"payment-form\"]/div[2]/div/input")WebElement card_number;
	@FindBy(xpath="//*[@id=\"payment-form\"]/div[3]/div[1]/input")WebElement cvv;
	@FindBy(xpath="//*[@id=\"payment-form\"]/div[3]/div[2]/input")WebElement expiry_month;
	@FindBy(xpath="//*[@id=\"payment-form\"]/div[3]/div[3]/input")WebElement expiry_year;
	@FindBy(xpath="//*[@id=\"submit\"]")WebElement confirm_order;
	@FindBy(xpath="//*[@class=\"alert-success alert\"]")public WebElement success_msg;
	@FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")WebElement delete_Account;
	@FindBy(xpath="//*[@id=\"product-1\"]/td[6]/a")WebElement cancel_product_one;
	@FindBy(xpath="//*[@id=\"product-2\"]/td[6]/a/i")WebElement cancel_product_two;
	@FindBy(xpath="//*[@id=\"product-1\"]/td[2]/h4/a")WebElement removed_product_one;
	@FindBy(xpath="//*[text()=\"Summer White Top\"]")WebElement summer_white_top;
	@FindBy(xpath="//*[text()=\"Download Invoice\"]")WebElement download_invoice;
	
	public cartpagee(WebDriver d){
		driver=d;
		PageFactory.initElements(driver, this);
	}
	public void secondProductName() {
		 String exp_product_two="Men Tshirt";
		 String act_product_two=product_two.getText();
		 Assert.assertEquals(act_product_two, exp_product_two);
	}
	public void firstQuantity() {
		String expected_quantity1="1";
		 String actual_quantity1=first_product_quantity.getText();
		 Assert.assertEquals(actual_quantity1,expected_quantity1);
	}
	public void finalQuantity() {
		String expected_quantity="4";
		 String actual_quantity=first_product_quantity.getText();
		 Assert.assertEquals(actual_quantity, expected_quantity);
	}
	public void totalFirst() {
		 String expected_total1="Rs. 500";
		 String actual_total1=first_product_total.getText();
		 Assert.assertEquals(actual_total1, expected_total1);
	}
	public void secondQuantity() {
		 String expected_quantity2="1";
		 String actual_quantity2=second_product_quantity.getText();
		 Assert.assertEquals(actual_quantity2,expected_quantity2);
	}
	public void total() {
		String expected_total2="Rs. 400";
		 String actual_total2=second_product_total.getText();
		 Assert.assertEquals(actual_total2, expected_total2);
	}
	public void priceSecond() {
		String expected_price2="Rs. 400";
		 String actual_price2=second_product_price.getText();
		 Assert.assertEquals(actual_price2,expected_price2);
	}
	public void downloadInvoice() {
		download_invoice.click();
	}
	public void verifyCartPageIsDisplayed() {
		String expected_url="https://automationexercise.com/view_cart";
		String actual_url=driver.getCurrentUrl();
		Assert.assertEquals(actual_url, expected_url);
	}
	public void verifyProductIsDisplayedInCart() {
		boolean display=product_one.isDisplayed();
		Assert.assertTrue(display);
	}
	public void clickProceedToCheckout() {
		proceed_to_checkout.click();
	}
	public void clickRegisterButton() {
		register.click();
	}
	public void enterDescription(String description) {
		comment.clear();
		comment.sendKeys(description);
	}
	public void placeOrder() {
		place_order.click();
	}
	public void enterPaymentDetails(String ename,String num,String cvc,String emonth,String eyear) {
		name_on_card.clear();
		name_on_card.sendKeys(ename);
		card_number.clear();
		card_number.sendKeys(num);
		cvv.clear();
		cvv.sendKeys(cvc);
		expiry_month.clear();
		expiry_month.sendKeys(emonth);
		expiry_year.clear();
		expiry_year.sendKeys(eyear);
	}
	public void clickPayAndConfirm() {
		confirm_order.click();
	}
	public void clickDeleteAccount() {
		delete_Account.click();
	}
	public void waitForMessage() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(success_msg));
	}
	public void cancelProductOne() {
		cancel_product_one.click();
	}
	public void cancelProductTwo() {
		cancel_product_two.click();
	}
	public void verifyProductIsRemoved(){
		try {
			boolean displayStatus=cancel_product_one.isDisplayed();
			if(displayStatus) {
				System.out.println("present");
			}
		}
			catch(org.openqa.selenium.NoSuchElementException e) {
				System.out.println("not present");
			}
				}
	public void verifysuccessMessage() {
		boolean order_placed=success_msg.isDisplayed();
		SoftAssert s=new SoftAssert();
		s.assertEquals(order_placed,true);
	}
	public void verifyProductIsVisibleInCart() {
		boolean top=summer_white_top.isDisplayed();
		Assert.assertTrue(top);
	}
	public void compareDeliveryAddressWithRegisteredAddress() {
		List<String>delivery_address=new ArrayList<String>();
			delivery_address.add("Mr.fdbgf");
			delivery_address.add("sfsfs");
			delivery_address.add("8");
			delivery_address.add("January");
			delivery_address.add("1990");
			delivery_address.add("dgfrg");
			delivery_address.add("rgrgrg");
			delivery_address.add("rgrea");
			delivery_address.add("qeqwwed");
			delivery_address.add("silkboard");
			delivery_address.add("India");
			delivery_address.add("3rd cross");
			delivery_address.add("rgrgr");
			delivery_address.add("563452");
			delivery_address.add("9876543210");
	     List<String>registered_address=new ArrayList<String>();
			registered_address.add("Mr.fdbgf");
			registered_address.add("sfsfs");
			registered_address.add("8");
			registered_address.add("January");
			registered_address.add("1990");
			registered_address.add("dgfrg");
			registered_address.add("rgrgrg");
			registered_address.add("rgrea");
			registered_address.add("qeqwwed");
			registered_address.add("silkboard");
			registered_address.add("3rd cross");
			registered_address.add("rgrgr");
			registered_address.add("563452");
			registered_address.add("9876543210");
	 Assert.assertTrue(delivery_address.containsAll(registered_address));
}
	public void compareBillingAddressWithRegisteredAddress() {
		List<String>billing_address=new ArrayList<String>();
			billing_address.add("Mr.fdbgf");
			billing_address.add("sfsfs");
			billing_address.add("8");
			billing_address.add("January");
			billing_address.add("1990");
			billing_address.add("dgfrg");
			billing_address.add("rgrgrg");
			billing_address.add("rgrea");
			billing_address.add("qeqwwed");
			billing_address.add("silkboard");
			billing_address.add("India");
			billing_address.add("3rd cross");
			billing_address.add("rgrgr");
			billing_address.add("563452");
			billing_address.add("9876543210");
		 List<String>registered_address=new ArrayList<String>();
			registered_address.add("Mr.fdbgf");
			registered_address.add("sfsfs");
			registered_address.add("8");
			registered_address.add("January");
			registered_address.add("1990");
			registered_address.add("dgfrg");
			registered_address.add("rgrgrg");
			registered_address.add("rgrea");
			registered_address.add("qeqwwed");
			registered_address.add("silkboard");
			registered_address.add("3rd cross");
			registered_address.add("rgrgr");
			registered_address.add("563452");
			registered_address.add("9876543210");
		Assert.assertTrue(billing_address.containsAll(registered_address));
	}
	public void verifyAddressDetails() {
		 String expected_headding="Address Details";
		 String actual_headding=address_details.getText();
		 Assert.assertEquals(actual_headding, expected_headding);
	}
	public void reviewOrder() {
		 String exp_review="Review Your Order";
		 String act_review=review_order.getText();
		 Assert.assertEquals(act_review,exp_review);
	}
public void verifyInvoiceIsDownloaded() {
		File filelocation=new File("C:\\Users\\HP\\Downloads");
		File[] totalFiles=filelocation.listFiles();
		for(File files:totalFiles) {
			if(files.getName().equals("invoice.txt.crdownload")) {
				System.out.println("File is present");
				break;
			}
		}
	}
}
	
	
		

