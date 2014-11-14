package Test.TestCase.Practicethree;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Test.TestCase.LaunchBrowser.Browsers;
import Test.TestCase.LaunchBrowser.BrowsersType;
import Test.TestCase.ToolClass.SwitchWindow;

public class Practice7OnTestng {
	private WebDriver driver;
	private ParseProperties baidu;
	String projectpath = System.getProperty("user.dir");
	private Wait wait;
	private SwitchWindow sw;
	
	@Parameters({"data"})
	@BeforeClass
	public void init(String data) {
		Browsers browser = new Browsers(BrowsersType.firefox);
		baidu = new ParseProperties(projectpath+data);
		this.driver = browser.driver;
		wait = new Wait(driver);
		sw = new SwitchWindow(driver);
		driver.get(baidu.getValue("url"));
	}
	
	@Test
	public void testMultipleWindows() {
		String currentWindowHandle = driver.getWindowHandle();
		wait.waitForElementPresent(baidu.getValue("searchBox"));
		driver.findElement(By.xpath(baidu.getValue("searchBox"))).sendKeys("bing");
		driver.findElement(By.xpath(baidu.getValue("searchButton"))).click();
		wait.waitFor(5000);
		driver.findElement(By.xpath("//a[contains(text(),'translator ')]")).click();
		wait.waitFor(10000);
		/*Set<String> allHandles = driver.getWindowHandles();
		for(String s:allHandles) {
			String title = driver.switchTo().window(s).getTitle();
			if(title.contains("在线翻译")) {
				break;
			}
		}*/
		sw.switchSpecificWindow("在线翻译");
		driver.findElement(By.xpath("//textarea[@id='InputText']")).sendKeys("java");
		
		sw.switchSpecificWindow("百度搜索");
		driver.findElement(By.xpath(baidu.getValue("searchBox"))).clear();
		driver.findElement(By.xpath(baidu.getValue("searchBox"))).sendKeys("page");
		wait.waitFor(5000);
		
		
	}
	@AfterClass
	public void release() {
		//driver.quit();
	}
}
