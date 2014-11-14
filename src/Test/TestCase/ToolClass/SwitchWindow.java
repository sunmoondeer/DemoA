package Test.TestCase.ToolClass;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class SwitchWindow {
	private WebDriver driver;
	private String currentWindowHandle;
	
	public SwitchWindow(WebDriver driver) {
		this.driver = driver;
		currentWindowHandle = driver.getCurrentUrl();
	}
	
	public void switchSpecificWindow(String partialTitleName) {
		Set<String> allHandles = driver.getWindowHandles();
		for(String s:allHandles) {
			String title = driver.switchTo().window(s).getTitle();
			if(title.contains(partialTitleName)) {
				break;
			}
		}
		
	}
	
	public void backToCurrentWindow() {
		driver.switchTo().window(currentWindowHandle);
	}

}
