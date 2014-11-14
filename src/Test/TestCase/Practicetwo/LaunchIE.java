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
		 * ��ϵͳ�����ļ��м������ã������ļ��е�webdriver.ie.driver�ֶ����ò���Ϊres/IEDriverServer.exe���൱��������������ļ����ͻ����IEDriverServer.exe���ߵ�������
		 */
		System.setProperty("webdriver.ie.driver", projectpath+"/tools/IEDriverServer.exe");
		
		/*
		 * ����IEDriver��ʱ��ͨ������Ϊ����ģʽ���������⣬���޷������������ڴ���IEDriver�����ʱ�򣬼�����ʵĲ�������
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
