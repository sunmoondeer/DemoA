package Test.TestCase.LaunchBrowser;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestBrowsers {
	private WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
	}
	
	@Test
	public void serchOnBaidu() {
		driver.get("http://www.baidu.com");
	}
	
	@AfterClass
	public void releaseBrowser() {
		driver.quit();
	}

}
