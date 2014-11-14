package Test.TestCase.Practicethree;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Test.TestCase.LaunchBrowser.Browsers;
import Test.TestCase.LaunchBrowser.BrowsersType;

public class Practice2OnTestng {
	private WebDriver driver = null;
	private String projectpath = System.getProperty("user.dir");
	
	ParseProperties data = null;
	ParseProperties locator = null;
	Wait wait = null;
	
	
	@Parameters({"data","locator"})
	@BeforeClass
	public void init(String da, String loc) {
		data = new ParseProperties(projectpath+da);
		locator = new ParseProperties(projectpath+loc);
		
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		wait = new Wait(driver);
		
	}
	
	@Test
	public void loginTest() {
		driver.get(data.getValue("url"));
		wait.waitForElementPresent(locator.getValue("username"));
		driver.findElement(By.xpath(locator.getValue("username"))).clear();
		driver.findElement(By.xpath(locator.getValue("username"))).sendKeys(data.getValue("username"));
		wait.waitForElementPresent(locator.getValue("password"));
		driver.findElement(By.xpath(locator.getValue("password"))).sendKeys(data.getValue("password"));
		wait.waitForElementPresent(locator.getValue("submit"));
		driver.findElement(By.xpath(locator.getValue("submit"))).click();
	
		wait.waitForElementIsEnables(locator.getValue("homepage"));
		Assert.assertEquals(driver.findElement(By.xpath(locator.getValue("homepage"))).isDisplayed(), true);
		
	}
	
	/*@Test(dependsOnMethods = {"loginTest"})
	public void unreadMailNumTest() {
		int actualunreadMailsNum = 0;
		int inboxunreadMailsNum = 0;
		int pageNum = 0;
		
		wait.waitForElementIsEnables("inboxMailsNum");
		String countNum = driver.findElement(By.xpath(locator.getValue("inboxMailsNum"))).getText();
		actualunreadMailsNum = Integer.valueOf(countNum.substring(1, countNum.length()-1));
		
		wait.waitForElementIsEnables("inbox");
		driver.findElement(By.xpath(locator.getValue("inbox"))).click();
		wait.waitForElementPresent("unreadLink");
		driver.findElement(By.xpath(locator.getValue("unreadLink"))).click();
		wait.waitFor(5000);
		String[] pages = driver.findElement(By.xpath(locator.getValue("pagesNum"))).getText().split("/");
		pageNum = Integer.valueOf(pages[pages.length-1]);
		
		while(pageNum>=1) {
			inboxunreadMailsNum = inboxunreadMailsNum + driver.findElements(By.xpath(locator.getValue("unreadMails"))).size();
			try {
				driver.findElement(By.xpath(locator.getValue("nextPageButton"))).click();
			} catch(NoSuchElementException e) {
				e.printStackTrace();
				break;
			}
			pageNum--;
		}
		
		
		Assert.assertEquals(inboxunreadMailsNum, actualunreadMailsNum);
		
	}*/
	
	@Test(dependsOnMethods = {"loginTest"})
	public void contextClickTest() {
		wait.waitForElementPresent(locator.getValue("inbox"));
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.xpath(locator.getValue("inbox")))).build().perform();
		wait.waitFor(3000);
		driver.findElement(By.xpath("//span[text()='全部标为已读']")).click();
		wait.waitFor(5000);
	}
	
	@AfterClass
	public void release() {
		driver.quit();
	}

}
