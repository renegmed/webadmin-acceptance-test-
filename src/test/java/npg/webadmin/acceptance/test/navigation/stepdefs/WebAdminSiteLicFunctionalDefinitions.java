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
import org.openqa.selenium.NoAlertPresentException;
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
    	
    	webDriver.findElement(By.xpath(
    	 "//a[contains(text(), 'active')][@href='webAdmin.do?initparam=updateSiteAccountStatus&site_account_id=" + siteId + "']"));
    	
	}
 
 
	@Then("^alert message \"([^\"]*)\" should display on site \"([^\"]*)\"$")
	public void functionalAssertMessage( String message, String siteId) {		 
		 webDriver.findElement(By.xpath("//a[contains(text(), 'active')][@href='webAdmin.do?initparam=updateSiteAccountStatus&site_account_id=" + siteId + "']")).click();
		 
		 try{
			 
			 //System.out.println("====== wait for alert window to popup ===== ");
		     
			 WebDriverWait wait = new WebDriverWait(webDriver, 10);
		     wait.until(ExpectedConditions.alertIsPresent()); 
		     try {
		       //System.out.println("xxxxx START " ); 
		       Alert alert = webDriver.switchTo().alert();		       
		       //System.out.println("xxxxx alert is " + (alert == null?"null":"not null"));
		       
		       String alertText = alert.getText(); 
		       //System.out.println("xxxxx " + alertText);
		       alert.accept();
		     
		       assertTrue("Alert message is invalid.", message.equals(alertText));
		       
		     } catch (NoAlertPresentException e2) {
		    	 System.out.println("++++++ NoAlertPresentException " + e2.getMessage());
		    	 assertTrue("No Alert Present Exception", false);
		     } catch (Exception e2) {
		    	 assertTrue("General exception generated during alert verification", false);
		    	 //System.out.println("++++++ Exception " + e2.getMessage());
		    	 //e2.printStackTrace();
		     }
		     
		 } catch (Exception e) { 
			System.out.println("++++++" + e.getMessage());			
	        assertTrue("General exception generated. No alert message is found.",false);
		 } 
		 
	}                
	  
	
	@And("^site \"([^\"]*)\" is still active$") 
	public void functionalSiteNotAllowDeactivation(String siteId) {
		webDriver.findElement(By.xpath("//a[contains(text(), 'active')][@href='webAdmin.do?initparam=updateSiteAccountStatus&site_account_id=" + siteId + "']"));
	}    
}
