package Test.TestCase.Practiceone;
import org.testng.annotations.*;

public class Practice2OnTestng {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("2beforeClass");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("2beforemethod");
	}
	
	@Test
	public void test3() {
		System.out.println("test3");
	}
	
	@Test
	public void test4() {
		System.out.println("test4");
	}

	@AfterMethod
	public void AfterMethod() {
		System.out.println("2aftermethod");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("2afterClass");
	}
}
