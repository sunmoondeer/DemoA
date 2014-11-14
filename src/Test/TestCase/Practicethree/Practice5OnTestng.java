package Test.TestCase.Practicethree;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Test.TestCase.LaunchBrowser.Browsers;
import Test.TestCase.LaunchBrowser.BrowsersType;

public class Practice5OnTestng {
	public static void main(String[] args) {
		WebDriver driver;
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		Wait wait = new Wait(driver);
		driver.get("http://www.jd.com");
		driver.findElement(By.xpath("//a[contains(text(),'登录')]")).click();
		wait.waitForElementPresent("//input[@id='loginname']");
		driver.findElement(By.xpath("//input[@id='loginname']")).clear();
		driver.findElement(By.xpath("//input[@id='loginname']")).sendKeys("earthchild");
		driver.findElement(By.xpath("//input[@id='nloginpwd']")).sendKeys("amazon123");
		wait.waitFor(5000);
		driver.findElement(By.xpath("//input[@id='loginsubmit']")).click();
		wait.waitForElementPresent("//a[text()='我的订单']");
		driver.findElement(By.xpath("//a[text()='我的订单']")).click();
		Actions action = new Actions(driver);
		wait.waitForElementPresent("//span[text()='设置']");
		action.moveToElement(driver.findElement(By.xpath("//span[text()='设置']"))).build().perform();
		wait.waitFor(7000);
		driver.findElement(By.xpath("//span[text()='个人信息']")).click();
		wait.waitForElementPresent("//select[@id='province']");
		Select select = new Select(driver.findElement(By.xpath("//select[@id='province']")));
		List<WebElement> all = select.getOptions();
		for(WebElement element:all) {
			System.out.println(element.getText());
		}
		select.selectByVisibleText("河北");
		
		
	}
	

}
