package Test.TestCase.Practicethree;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practice1OnTestng {
	@Parameters({"TestData"})
	@Test
	public void test(@Optional("aaa") String testdata) {
		System.out.println(System.getProperty("user.dir")+testdata);
		
	}

}
