package Test.TestCase.Practicetwo.groups;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


import Test.TestCase.LaunchBrowser.Browsers;
import Test.TestCase.LaunchBrowser.BrowsersType;

public class MutipleBrowsers {
	private WebDriver driver = null;
	private Browsers browser = null;
	
/*	@Parameters({"platform"})
	@BeforeMethod(groups="browsers")
	public void init(String platform) {
		if(platform.equals("ff")) {
			browser = new Browsers(BrowsersType.firefox);
		} else if(platform.equals("ie")) {
			browser = new Browsers(BrowsersType.ie);
		} else {
			browser = new Browsers(BrowsersType.chrome);
			
		}
		driver = browser.driver;
	}*/
	
	@Test(groups="submoudle1")
	public void test1() {
		driver.get("http://www.baidu.com");
		
	}
	
	@Test(groups="submoudle2")
	public void test2() {
		driver.get("http://www.bing.com");
	}
	
	@Test(groups="submoudle3")
	public void test3() {
		driver.get("http://www.sina.com.cn");
		
	}
	
	@Test(groups="submoudle4")
	public void test4() {
		driver.get("http://www.sohu.com.cn");
		
	}
	
	@AfterMethod
	public void release() {
		driver.quit();
	}

}
