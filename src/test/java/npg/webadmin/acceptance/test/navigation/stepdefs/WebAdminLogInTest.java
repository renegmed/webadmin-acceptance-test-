package npg.webadmin.acceptance.test.navigation.stepdefs;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
  features={"target/classes/npg/webadmin/acceptance/test/navigation/stepdefs/webadmin_login.feature"},
//  tags = {"sprint-2"}, 
//  glue = { "npg.webadmin.acceptance.test.navigation.stepdefs" },
  format = {"pretty","html:target/login_test_result","json:target/login_test_result.json"}) // {"html:reports"}) //{"json:target/cucumber.json"})
public class WebAdminLogInTest {
	
}
