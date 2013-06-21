package npg.webadmin.acceptance.test.navigation.stepdefs;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
  features={"target/classes/webadmin_login.feature"},
  //tags = {"@wip"},
  format = "html:target/Login_Test_Report")
public class WebAdminLogInTest {
	
}
