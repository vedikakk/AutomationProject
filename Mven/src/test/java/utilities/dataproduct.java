package utilities;

import org.testng.annotations.DataProvider;

public class dataproduct {
	@DataProvider(name="verifySearchProduct")
	public Object[][]producttest1(){
		return new Object[][] {{"white top"}};
}
	@DataProvider(name="searchProductAndVerifyCartAfterLogin")
	public Object[][]producttest2(){
		return new Object[][] {{"White top","pqr123@gmail.com","pqr@123"}};
}
	@DataProvider(name="addReviewOnProduct")
	public Object[][]producttest3(){
		return new Object[][] {{"abcd","pqr123@gmail.com","good"}};
	}
}