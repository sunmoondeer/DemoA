package Test.TestCase.Practicethree;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Test.TestCase.LaunchBrowser.Browsers;
import Test.TestCase.LaunchBrowser.BrowsersType;

public class Practice6OnTestng {
	private WebDriver driver;
	private Browsers browser;
	private ParseProperties data;
	private ParseProperties locator;
	private Wait wait;
	String projectPath = System.getProperty("user.dir");
	
	@Parameters({"data","locator"})
	@BeforeClass
	public void init(String data, String locator) {
		this.data = new ParseProperties(projectPath+data);
		this.locator = new ParseProperties(projectPath+locator);
		browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		driver.get(this.data.getValue("jqueryuiurl"));
		wait = new Wait(driver);
	}
	
	@Test
	public void testSilder() {
			Actions action = new Actions(driver);
			wait.waitForElementPresent(locator.getValue("jqueryhome"));
			//wait.waitFor(40000);
			//String framepath = locator.getValue("sliderIframe");
			driver.switchTo().frame(driver.findElement(By.xpath(locator.getValue("sliderIframe"))));
			WebElement slider = driver.findElement(By.xpath(locator.getValue("sliderBlock")));
			Point initalPoint = slider.getLocation();
			System.out.println(initalPoint);
			action.dragAndDropBy(slider, 200, 6).build().perform();
		} 
		
	
	@AfterClass
	public void release() {
		
	}
	
	
	
}
