package Test.TestCase.Practicethree;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import Test.TestCase.LaunchBrowser.Browsers;
import Test.TestCase.LaunchBrowser.BrowsersType;

public class Practice4OnTestng {
	
	public static void main(String[] args) {
		WebDriver driver;
		
		Browsers browser = new Browsers(BrowsersType.firefox);
		
		driver = browser.driver;
		
		Wait wait = new Wait(driver);
		
		//driver.get("http://www.baidu.com");
		driver.get("http://www.jd.com");
		
		//driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("webdriver");
		
		//driver.findElement(By.xpath("//input[@id='su']")).click();
		
		wait.waitFor(10000);
		
		//Point point = driver.findElement(By.xpath("//a[contains(text(),'ÏÂÒ»Ò³')]")).getLocation();
		
		JavascriptExecutor  jse = (JavascriptExecutor)driver;	
		
		//jse.executeScript("window.scrollBy("+point.getX()+","+point.getY()+")");
		jse.executeScript("window.scrollBy(10,10000)");
		
		wait.waitFor(5000);
		
		
	}
	
	

}
