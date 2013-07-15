package npg.webadmin.acceptance.test.navigation.stepdefs;


//import java.util.concurrent.TimeUnit;
import java.util.Set;
import java.util.Iterator;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.inject.Inject;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import npg.webadmin.acceptance.test.util.LoginService;
import npg.webadmin.acceptance.test.service.NavigationService;
import npg.webadmin.acceptance.test.util.WebDriverFactory;
import npg.webadmin.acceptance.test.WebDriverWrapper;

public class WebAdminSiteLicFunctionalDefinitions {
	private WebDriverWrapper webDriver;	
	private LoginService loginService;
	private NavigationService navigationService;
	
	@Inject
	public WebAdminSiteLicFunctionalDefinitions(
			LoginService loginService,
			NavigationService navigationService) {
		
		this.loginService = loginService;
		this.navigationService = navigationService;
	}
	
	@Before(value="@InitializeWebAdminSLFunc")
	public void initializeDriver() {
		webDriver = WebDriverFactory.getWebDriver();
		if (webDriver.getDriver() instanceof HtmlUnitDriver) {
			((HtmlUnitDriver)webDriver.getDriver()).setJavascriptEnabled(true);
		}
	}
	 
	@After(value="@CloseWebAdminSLFunc")
    public void clear() { 
		if (webDriver != null) {
			webDriver.manage().deleteAllCookies();
			webDriver.quit();
			webDriver = null;
	    }	
	} 
  
	
	@Given("^webadmin user logs in with username \"([^\"]*)\" password \"([^\"]*)\"$")
	public void functionalUserLogsIn(String username, String password) {
		loginService.userLogInWebAdmin(webDriver, username, password); 
		webDriver.findElement(By.linkText("Logout"));		   
	}
	
	@When("^user searches site \"([^\"]*)\" with existing licenses and tries to deactivate it$")
	public void functionalSearchSiteId(String siteId) {
		 // to WebAdmin main page
    	navigationService.toWebAdminMainPage(webDriver);
    	
    	// select 'Main Site License Search
    	navigationService.toWebAdminMainSiteLicenseSearch(webDriver);
    	
    	// search for Site ID
    	navigationService.toWebAdminMainSiteLicenseSearchSiteId(webDriver, siteId);
	}
 
 
	@Then("^alert message \"([^\"]*)\" should display on site \"([^\"]*)\"$")
	public void functionalAssertMessage( String message, String siteId) {
		 //webDriver.findElement(By.linkText("activate")).click();
		 webDriver.findElement(By.xpath("//a[contains(text(), 'active') and @href='webAdmin.do?initparam=updateSiteAccountStatus&site_account_id=" + siteId + "']")).click();
		 try{
		     
		     WebDriverWait wait = new WebDriverWait(webDriver, 2);
		     wait.until(ExpectedConditions.alertIsPresent());
		     Alert alert = webDriver.switchTo().alert();
		     String alertText = alert.getText();
		     
		     System.out.println("====== alert text: " + alertText);
		     
		     alert.accept();
		     assertTrue("Alert message is invalid.", "You cannot delete this account. There are still licenses in this account. Please disassociate the licenses.".equals(alertText));
		 } catch (Exception e) {
	        assertTrue("No alert message is found.",false);
		 }
		 
		 /*
		 Set<String> windowHandlers = webDriver.getWindowHandles();
		 if (windowHandlers!=null) {
			WebDriverWrapper popup = null;   
			
			//if (webDriver.getDriver() instanceof HtmlUnitDriver) {
			//	((HtmlUnitDriver)webDriver.getDriver()).setJavascriptEnabled(false);
			//}
			 
		    Iterator<String> iter = windowHandlers.iterator();		 
		    while(iter.hasNext()) { 
		        String windowHandle = iter.next(); 
		        popup = WebDriverFactory.getWebDriver();
		        popup.switchTo().window(windowHandle);
		        if (popup.getTitle().equals("Google") {
		          break;
		        }
		    }
		 }
		 */
	}                
	  
	
	@And("^site \"([^\"]*)\" is still active$") 
	public void functionalSiteNotAllowDeactivation(String siteId) {
		webDriver.findElement(By.xpath("//a[contains(text(), 'active') and @href='webAdmin.do?initparam=updateSiteAccountStatus&site_account_id=" + siteId + "]"));
	}    
}
