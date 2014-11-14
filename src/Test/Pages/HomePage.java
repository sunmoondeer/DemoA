package Test.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	
	@FindBy(xpath=".//*[@id='loginbar']/span/a[2]")
	private WebElement reg;
	
	@FindBy(xpath="//a[text()='Ê×Ò³']")
	private WebElement main;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void register() {
		reg.click();
	}
	
	public void navigateToJD(String url) {
		driver.get(url);
	}

}
