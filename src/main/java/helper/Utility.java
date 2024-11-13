package helper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	
	public static Alert waitForAlert(WebDriver driver) {
		Alert alt = null;
		for (int i = 0; i <= 15; i++) {

			try {
				alt = driver.switchTo().alert();
				break;
			} catch (NoAlertPresentException e) {

				System.out.println("No alert found - waiting for Alert");
				waitforseconds(1);
			}

		}
		return alt;
	}

	public static Alert waitForAlert(WebDriver driver, int time) {
		Alert alt = null;
		for (int i = 0; i <= 15; i++) {

			try {
				alt = driver.switchTo().alert();
				break;
			} catch (NoAlertPresentException e) {

				System.out.println("No alert found - waiting for Alert");
				waitforseconds(time);
			}

		}
		return alt;
	}

	public static void waitforseconds(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {

		}

	}
	
	
	public static String captureScreenshotasBase64(WebDriver driver) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		String base64 = ts.getScreenshotAs(OutputType.BASE64);
		
		return base64;
		
	}

	public static void captureScreenshot(WebDriver driver) {

		try {

			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File("./screenshots/Screenshot_" + getCurrentTime() + ".png"));
		} catch (IOException e) {
			System.out.println("Something went wrong --- " + e.getMessage());
		}
	}

	public static String getCurrentTime() {

		String date = new SimpleDateFormat("HH:mm:ss_dd_MM_yyyy").format(new Date());
		return date;
	}

}
