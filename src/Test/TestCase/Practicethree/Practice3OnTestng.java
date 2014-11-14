package Test.TestCase.Practicethree;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Test.TestCase.LaunchBrowser.Browsers;
import Test.TestCase.LaunchBrowser.BrowsersType;

public class Practice3OnTestng {
	WebDriver driver;
	String projectpath = System.getProperty("user.dir");
	ParseProperties data;
	ParseProperties locator;
	Wait wait;
	
	@Parameters({"data","locator"})
	@BeforeClass
	public void init(String data, String locator) {
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		this.data = new ParseProperties(projectpath+data);
		this.locator = new ParseProperties(projectpath+locator);
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
	
	@Test(dependsOnMethods = {"loginTest"})
	public void contactsTest() {
		int actualContactsNum = 0;
		int contactsBoxNum = 0;
		wait.waitForElementPresent(locator.getValue("contactsLink"));
		driver.findElement(By.xpath(locator.getValue("contactsLink"))).click();
		JavascriptExecutor  jse = (JavascriptExecutor)driver;	
		
		jse.executeScript("window.scrollTo(10,10000)");
		wait.waitFor(20000);
		wait.waitForElementPresent(locator.getValue("allContactsNum"));
		String numsText = driver.findElement(By.xpath(locator.getValue("allContactsNum"))).getText();
		actualContactsNum = Integer.valueOf(numsText.substring(1, numsText.length()-1));
		contactsBoxNum = driver.findElements(By.xpath(locator.getValue("contactBoxNum"))).size();
		wait.waitFor(5000);
		Assert.assertEquals(actualContactsNum, contactsBoxNum);
		
		
	}
	
	@AfterClass
	public void release() {
		driver.quit();
	}

}
