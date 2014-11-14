package Test.TestCase.Practicetwo.groups;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Test.TestCase.LaunchBrowser.*;


public class Practice3OnTestng {
	private WebDriver driver = null;
	private Browsers browser = null;
	
	@Parameters({"platform"})
	@BeforeMethod(groups="browsers")
	public void initBrowser(String platform) {
		/*browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;*/
		if(platform.equals("ff")) {
			browser = new Browsers(BrowsersType.firefox);
			driver = browser.driver;
		} else if(platform.equals("ie")) {
			browser = new Browsers(BrowsersType.ie);
			driver = browser.driver;
		} else {
			browser = new Browsers(BrowsersType.chrome);
			driver = browser.driver;
		}
	}
	@Test(groups="submodule1")
	public void test1() {
		driver.get("http://www.baidu.com");
	}
	
	@Test(groups="submodule2")
	public void test2() {
		driver.get("http://www.bing.com");
	}
	
	@Test(groups="submodule3")
	public void test3() {
		System.out.println("test3");
	}
	
	@Test(groups="submodule4")
	public void test4() {
		System.out.println("test3");
	}
	
	@AfterMethod(groups="browsers")
	public void release() {
		driver.quit();
	}
	

}
