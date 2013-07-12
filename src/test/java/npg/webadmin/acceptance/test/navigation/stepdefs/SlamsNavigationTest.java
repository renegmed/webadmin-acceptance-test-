package npg.webadmin.acceptance.test.navigation.stepdefs;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
  features={"target/classes/npg/webadmin/acceptance/test/navigation/stepdefs/slams_navigation.feature"},
//  tags = {"sprint-2"},  
	format =  {"pretty","html:target/slams_navigation_test","json:target/slams_navigation_test.json"})
public class SlamsNavigationTest {
	
}
