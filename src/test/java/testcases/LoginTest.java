package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import dataProvider.CustomDataProvider;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test(dataProvider = "loginDetails", dataProviderClass = CustomDataProvider.class)
	public void loginToApplication(String uname, String pass) {
		
		LoginPage login = new LoginPage(driver);
		login.LoginToApplication(uname, pass);
		
		
			
	}

}
