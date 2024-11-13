package browserFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowserInstance() {
		
		return driver;
		
	}

	public static WebDriver startBrowser(String browserName, String ApplicationURL) {

		

		if (browserName.contains("Chrome") || browserName.contains("GC") || browserName.contains("Google Chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.contains("Edge")) {
			driver = new EdgeDriver();
		} else if (browserName.contains("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		driver.get(ApplicationURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;

	}

}
