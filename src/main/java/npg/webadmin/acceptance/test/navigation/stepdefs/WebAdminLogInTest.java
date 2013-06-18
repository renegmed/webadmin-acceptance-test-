package npg.webadmin.acceptance.test.navigation.stepdefs;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
  features={"target/classes/webadmin_login.feature"},
  tags = {"@wip"},
  format = "json:target/WebAdmin_Login_Test_Report.json")
public class WebAdminLogInTest {
	
}
