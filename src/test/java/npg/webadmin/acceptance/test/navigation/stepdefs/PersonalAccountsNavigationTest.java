package npg.webadmin.acceptance.test.navigation.stepdefs;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
  features={"target/classes/npg/webadmin/acceptance/test/navigation/stepdefs/personal_accounts_navigation.feature"},
 // tags = {},  
 // glue = { "npg.webadmin.acceptance.test.navigation.stepdefs" },
	format =  {"pretty","html:target/personal_account_nav_test","json:target/personal_account_nav_test.json"})
public class PersonalAccountsNavigationTest {
	
}
