package Test.TestCase.Practicetwo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.openqa.selenium.ie.*;

public class LaunchIE {
	private WebDriver iewb = null;
	private DesiredCapabilities caps = null;
	private String projectpath = System.getProperty("user.dir");
	
	
	@BeforeClass
	public void startIE() {
		/*
		 * 在系统配置文件中加入配置，配置文件中的webdriver.ie.driver字段设置参数为res/IEDriverServer.exe就相当于如果加载配置文件，就会加载IEDriverServer.exe工具调用它。
		 */
		System.setProperty("webdriver.ie.driver", projectpath+"/tools/IEDriverServer.exe");
		
		/*
		 * 加载IEDriver的时候，通常会因为兼容模式的设置问题，而无法启动，尝试在创建IEDriver对象的时候，加入合适的参数设置
		 */
		caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		
		caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "*private");
		
		caps.setCapability("ignoreZoomSetting", true);
		iewb = new InternetExplorerDriver(caps);
	}
	
	@Test
	public void searchOnBaidu() {
		iewb.get("http://www.baidu.com");
		
		try{
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void releaseIEDriver() {
		iewb.quit();
	}

}
