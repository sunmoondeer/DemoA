package Test.TestCase.Practicetwo;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.*;

public class LaunchChrome {
	private WebDriver chromewb = null;
	private DesiredCapabilities caps = null;
	private String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void startChrome() {
		System.setProperty("webdriver.chrome.driver", projectPath+"/tools/chromedriver.exe");
		caps = DesiredCapabilities.chrome();
		caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
		chromewb = new ChromeDriver(caps);
	}
	
	@Test
	public void serchOnBaidu() {
		chromewb.get("http://www.baidu.com");
	}
	
	@AfterClass
	public void releaseChrome() {
		chromewb.quit();
	}

}
