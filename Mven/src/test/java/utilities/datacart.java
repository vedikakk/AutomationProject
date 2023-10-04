package utilities;

import org.testng.annotations.DataProvider;

public class datacart {
	
	@DataProvider(name="subscriptionincartpage")
	public Object[][]cartpagetest1(){
		return new Object[][] {{"abc@gmail.com"}};
}
	@DataProvider(name="registerWhileCheckout")
	public Object[][]cartpagetest2(){
		return new Object[][] {{"abcd","pqr123@gmail.com","pqr","pqr@123","8","june","1985","pqr","txt","xyzabc","omeoad","2nd cross","India","mp","bihar","422378","1234567891","product should be good","pqr","12345665432","445","10","2023"}};
}
	@DataProvider(name="registerBeforeCheckout")
	public Object[][]cartpagetest3(){
		return new Object[][] {{"abcd","pqr123@gmail.com","pqr","pqr@123","8","june","1985","pqr","txt","xyzabc","omeoad","2nd cross","India","mp","bihar","422378","1234567891","product should be good","pqr","12345665432","445","10","2023"}};
}
	@DataProvider(name="loginBeforeCheckout")
	public Object[][]cartpagetest4(){
		return new Object[][] {{"pqr123@.com","pqr@123","product should be good","pqr","12345665432","445","10","2023"}};
	}
	@DataProvider(name="downloadInvoiceAfterPurchaseOrder")
	public Object[][]cartpagetest5(){
		return new Object[][] {{"abcd","pqr123@gmail.com","pqr","pqr@123","8","june","1985","pqr","txt","xyzabc","omeoad","2nd cross","India","mp","bihar","422378","1234567891","product should be good","pqr","12345665432","445","10","2023"}};
}
	@DataProvider(name="verifyProductQuantityInCart")
	public Object[][]cartpagetest6(){
		return new Object[][] {{"4"}};
}
}