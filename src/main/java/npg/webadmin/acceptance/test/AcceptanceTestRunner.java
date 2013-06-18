package npg.webadmin.acceptance.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import npg.webadmin.acceptance.test.navigation.stepdefs.WebAdminLogInTest;
import npg.webadmin.acceptance.test.navigation.stepdefs.PersonalAccountsNavigationTest;

public class AcceptanceTestRunner {
 
	public static void main(String[] args) {
	    Result result = JUnitCore.runClasses(WebAdminLogInTest.class,
	    		PersonalAccountsNavigationTest.class);
	    
	    for (Failure failure : result.getFailures()) {
	      System.out.println(failure.toString());
	    }
	}
}
