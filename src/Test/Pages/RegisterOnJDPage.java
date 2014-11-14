package Test.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class RegisterOnJDPage {

	private WebDriver driver;
	
	@FindBy(xpath="//input[@id='regName']")
	private WebElement userid;
	
	@FindBys(@FindBy(xpath="//input[@id='pwd']|//input[@id='pwdRepeat']"))
	private List<WebElement> passwd;
	
	@FindBy(xpath="//input[@id='registsubmit']")
	private WebElement regBtn;
	
	public RegisterOnJDPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserId(String userid) {
		this.userid.sendKeys(userid);
	}
	
	public void setPassword(String passwd) {
		for(WebElement we : this.passwd) {
			we.sendKeys(passwd);
		}
	}
	
	public void register() {
		regBtn.submit();
	}
}
