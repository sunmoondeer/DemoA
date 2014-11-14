package Test.TestCase.Practicetwo;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchFF {
	private WebDriver ffwb;
	private FirefoxProfile firefoxprofile = null;
	private String projectPath = System.getProperty("user.dir");
	
	@BeforeClass
	public void startFF() {
		File firebug = new File(projectPath+"/tools/firebug-2.0.6-fx.xpi");
		File firepath = new File(projectPath+"/tools/firepath-0.9.7-fx.xpi");
		firefoxprofile = new FirefoxProfile();
		
		try{
			firefoxprofile.addExtension(firebug);
			firefoxprofile.addExtension(firepath);
			firefoxprofile.setPreference("webdriver.accept.untrusted.certs", true);
			firefoxprofile.setPreference("extensions.firebug.currentVersion","2.0.6");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		ffwb = new FirefoxDriver(firefoxprofile);				
	}
	
	@Test
	public void searchOnBaidu() {
		ffwb.get("http://www.baidu.com");
	}
	
	@AfterClass
	public void releaseFF() {
		ffwb.quit();
	}
	

}
