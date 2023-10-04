package utilities;

import org.testng.annotations.DataProvider;

public class datacontact {

	@DataProvider(name="verifyContactUsForm")
	public Object[][]contactpagetest1(){
		return new Object[][] {{"riya","riyab@gmail.com","product placing","product placing","C:\\Users\\ryk96\\Downloads\\geckodriver-v0.33.0-win64 (1)\\.geckodriver.exe"}};
}
}