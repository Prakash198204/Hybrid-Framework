package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	By user = By.id("email1");
	By pass = By.name("password1");
	By login =By.className("submit-bt");
	
	public void LoginToApplication(String username, String password) {
		
		System.out.println(username);
		System.out.println(password);
		
		driver.findElement(user).sendKeys(username);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(login).click();
		
		
	}
	

}
