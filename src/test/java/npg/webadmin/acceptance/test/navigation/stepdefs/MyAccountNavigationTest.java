package npg.webadmin.acceptance.test.navigation.stepdefs;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
  features={"target/classes/npg/webadmin/acceptance/test/navigation/stepdefs/myaccount_navigation.feature"},
//  tags = {"sprint-2"},  
 // glue = { "npg.webadmin.acceptance.test.navigation.stepdefs" },
	format =  {"pretty","html:target/myaccount_navigation_test","json:target/myaccount_navigation_test.json"})
public class MyAccountNavigationTest {
	
}
