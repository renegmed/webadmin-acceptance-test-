package npg.webadmin.acceptance.test.navigation.stepdefs;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
  features={"target/classes/personal_accounts_navigation.feature"},
  tags = {"@wip"},
  format = "html:target/Personal_Accounts_Navigation_Report")
public class PersonalAccountsNavigationTest {
	
}
