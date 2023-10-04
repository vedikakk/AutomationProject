package utilities;

import org.testng.annotations.DataProvider;

public class datalogin {
	
@DataProvider(name="validemailandpassword")
public Object[][]logintest1(){
	return new Object[][] {{"riyab22@gmail.com","riyab22"}};
	}
@DataProvider(name="invalidemailandpassword")
public Object[][]logintest2(){
	return new Object[][] {{"riya22@gmail.com","riyab22"}};
	}
@DataProvider(name="logoutUser")
public Object[][]logintest3(){
	return new Object[][] {{"riyab22@gmail.com","riyab22"}};
	}
@DataProvider(name="registeruserwithexistingemail")
public Object[][]logintest4(){
	return new Object[][] {{"riya","riyab22@gmail.com"}};
	}

}