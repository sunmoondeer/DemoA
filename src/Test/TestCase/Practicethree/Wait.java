package Test.TestCase.Practicethree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	private WebDriver driver = null;
	private int timeout = 20;
	
	public Wait(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	public void waitForElementPresent(String locator) {
		try {
			new WebDriverWait(driver,timeout).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void waitForElementIsEnables(String locator) {
		try {
			new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitFor(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
