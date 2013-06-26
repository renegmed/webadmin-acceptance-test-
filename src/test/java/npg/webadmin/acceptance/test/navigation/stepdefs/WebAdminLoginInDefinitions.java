package npg.webadmin.acceptance.test.navigation.stepdefs;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import npg.webadmin.acceptance.test.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.google.inject.Inject;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import npg.webadmin.acceptance.test.util.LoginService;

public class WebAdminLoginInDefinitions {
	private WebDriver webDriver;
	private LoginService loginService;
	
	@Inject
	public WebAdminLoginInDefinitions(LoginService loginService) {	 
		this.loginService = loginService;
	}
	
	@Before(value="@Initialize")
	public void initializeDriver() {
		webDriver = WebDriverFactory.createWebDriver();
	}
	 
	@After(value="@Close")
    public void clear() {
		//try {
		//  loginService.userLogout(webDriver);
		//} catch (Exception e) {
		//	// do nothing
		//}
		
		if (webDriver != null) {	    	
	    	webDriver.quit();
	    }	
	}
	    
	@Given("^user is in webadmin main page$")
	public void userIsInWebadminMainPage() throws Exception  {
		loginService.toMainPage(webDriver); 
	}

	@When("^user goes to login page$")
	public void userGoesToLoginPage() throws Exception  {
		loginService.toLoginPage(webDriver); 
	}

	@Then("^ensure the user is able to logged in with username \"([^\"]*)\" password \"([^\"]*)\"$")
	public void ensureTheUserIsAbleToLoggedInWithUsernamePassword(String username, String password) throws Exception {
		loginService.userLogIn(webDriver, username, password);
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// verify you are on the right landing page 
		webDriver.findElement(By.linkText("Logout"));
		
	}

	@Then("^ensure the user is not able to logged in with username \"([^\"]*)\" password \"([^\"]*)\"$")
	public void ensureUserIsNotAbleToLoggedInWithUsernamePassword(String username, String password) throws Exception {
		loginService.userLogIn(webDriver, username, password);
		
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// verify you are on the right landing page 
		try {	 			
		    webDriver.findElement(By.xpath("//span[contains(text(), 'Login incorrect. Try again.')]"));		   
		} catch (NoSuchElementException e) {
			assertTrue(" 'Login incorrect. Try again.' should be present in the page. " , false);
		}
	}
}
