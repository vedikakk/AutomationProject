package utilities;

import org.testng.annotations.DataProvider;

public class datahome {
	
	@DataProvider(name="RegisterUser")
	public Object[][]homepagetest1(){
		return new Object[][] {{"abcd","pqr123@gmail.com","pqr","pqr@123","8","june","1985","pqr","txt","xyzabc","omroad","2nd cross","India","mp","bihar","520056","9876543210"}};
}
	@DataProvider(name="verifySubscriptionInHomePage")
	public Object[][]homepagetest2(){
		return new Object[][] {{"pqr123@gmail.com."}};
}
	@DataProvider(name="verifyAddressDetailsInCheckoutPage")
	public Object[][]homepagetest3(){
		return new Object[][] {{"abcd","pqr123@gmail.com","pqr","pqr@123","8","june","1985","pqr","txt","xyzabc","omroad","2nd cross","India","mp","bihar","520056","9876543210"}};
}
}



