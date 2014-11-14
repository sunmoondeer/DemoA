package Test.TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import Test.Pages.HomePage;
import Test.Pages.RegisterOnJDPage;

public class TestCase1 {
	WebDriver driver;
	
	@BeforeClass
	public void inialize() {
		System.setProperty("webdriver.firefox.bin", "F:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void regAccount() {
		HomePage hp = new HomePage(driver);
		RegisterOnJDPage rp = new RegisterOnJDPage(driver);
		
		hp.navigateToJD("http://www.jd.com");
		hp.register();
		
		rp.setUserId("perapera");
		rp.setPassword("admin123");
		rp.register();
	}
	@AfterClass
	public void releaseBrowser() {
		driver.quit();
	}
	
	
	
	

}
