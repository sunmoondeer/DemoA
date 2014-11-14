package Test.TestCase.Practiceone;
import org.testng.annotations.*;

public class Practice1OnTestng {
	
	@BeforeGroups
	public void beforeGroup() {
		System.out.println("before groups");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	@Test
	public void test1() {
		System.out.println("test1");
	}
	
	@Test
	public void test2() {
		System.out.println("test2");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("after class");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite");
	}
	
	@AfterGroups
	public void afterGroups() {
		System.out.println("after groups");
	}
}
