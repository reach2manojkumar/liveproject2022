package testcase_01;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.liveproject.baseclass.BaseClass;

public class TestCase_LP_01 extends BaseClass {
	
	@BeforeMethod
	private void setup() {
		// TODO Auto-generated method stub
		
		lanuchApp("chrome");
	}
	
	@Test
	private void openCreate() {
		
		
	};
	

}
