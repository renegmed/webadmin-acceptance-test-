package npg.webadmin.acceptance.test.navigation.stepdefs;


//import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
//import npg.webadmin.acceptance.test.util.TextElementsVerificationService;
import npg.webadmin.acceptance.test.service.NavigationService;
import npg.webadmin.acceptance.test.service.SearchService;
import npg.webadmin.acceptance.test.util.WebDriverFactory;
import npg.webadmin.acceptance.test.WebDriverWrapper;
import npg.webadmin.acceptance.test.util.WebElementsVerificationBaseAbstract.SearchItem;
import npg.webadmin.acceptance.test.util.WebElementsVerificationBaseAbstract.License;

public class WebAdminSiteAccountAdminFunctionalDefinitions {
	private WebDriverWrapper webDriver;	
	private LoginService loginService;
	private NavigationService navigationService;
	private SearchService searchService;
	
	@Inject
	public WebAdminSiteAccountAdminFunctionalDefinitions(
			LoginService loginService,
			NavigationService navigationService,
			SearchService searchService) {
		
		this.loginService = loginService;
		this.navigationService = navigationService;
		this.searchService = searchService;
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
	
	@When("^user searches site \"([^\"]*)\" with existing active license$")
	public void functionalSearchSiteId(String siteId) {
		 // to WebAdmin main page
    	navigationService.toWebAdminMainPage(webDriver);
    	
    	// select 'Main Site License Search
    	navigationService.toWebAdminMainSiteLicenseSearch(webDriver);
    	
    	// search for Site ID
    	navigationService.toWebAdminMainSiteLicenseSearchSiteId(webDriver, siteId);
    	try {
    	  
    	  webDriver.findElement(By.xpath(
    	     "//a[text()[normalize-space(.)='active']][@href='webAdmin.do?initparam=updateSiteAccountStatus&site_account_id=" + siteId + "']"));
    	  
    	} catch (NoSuchElementException e) {
    	  
    	   System.out.println("------ no such element --------");
    	   
    	   webDriver.findElement(By.xpath(
    		    	   "//a[contains(text(), 'inactive')][@href='webAdmin.do?initparam=updateSiteAccountStatus&site_account_id=" + 
    	               siteId + "']")).click();
    	                                                     
    	   WebDriverWait wait = new WebDriverWait(webDriver, 10);
		   wait.until(ExpectedConditions.alertIsPresent()); 
    	   
		   Alert alert = webDriver.switchTo().alert();
		   System.out.println("Activate alert box text --------> " + alert.getText() + " ----------");				   
		   alert.accept();		   
    	   // go back to search and this time the site is active
    	   navigationService.toWebAdminMainPage(webDriver);
    	   navigationService.toWebAdminMainSiteLicenseSearch(webDriver);
    	   navigationService.toWebAdminMainSiteLicenseSearchSiteId(webDriver, siteId); 
    	}
	}
 
	@When("user searches site \"([^\"]*)\" with existing inactive license$")
	public void functionalSearchAndActivateSite(String siteId) {
		 // to WebAdmin main page
    	navigationService.toWebAdminMainPage(webDriver);    	
    	// select 'Main Site License Search
    	navigationService.toWebAdminMainSiteLicenseSearch(webDriver);    	
    	// search for Site ID
    	navigationService.toWebAdminMainSiteLicenseSearchSiteId(webDriver, siteId);
    	try {
    	  
    	  webDriver.findElement(By.xpath(
    	     "//a[text()[normalize-space(.)='inactive']][@href='webAdmin.do?initparam=updateSiteAccountStatus&site_account_id=" + siteId + "']"));
    	  
    	} catch (NoSuchElementException e) {
    	  
    	   // the license is currently active. make it inactive	
    	   
    	   webDriver.findElement(By.xpath(
    		    	   "//a[contains(text(), 'active')][@href='webAdmin.do?initparam=updateSiteAccountStatus&site_account_id=" + 
    	               siteId + "']")).click();
    	                                                     
    	   WebDriverWait wait = new WebDriverWait(webDriver, 10);
		   wait.until(ExpectedConditions.alertIsPresent()); 
    	   
		   Alert alert = webDriver.switchTo().alert();
		   System.out.println("Activate alert box text --------> " + alert.getText() + " ----------");				   
		   alert.accept();		   

		   // go back to search and this time the site is inactive
    	   navigationService.toWebAdminMainPage(webDriver);
    	   navigationService.toWebAdminMainSiteLicenseSearch(webDriver);
    	   navigationService.toWebAdminMainSiteLicenseSearchSiteId(webDriver, siteId); 
    	}		
	}
	 
	@Then("^confirm window message \"([^\"]*)\" should display at site \"([^\"]*)\"$")     
	public void functionalAssertConfirmWindowMessage( String message, String siteId) {		 
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
		       
		       //System.out.println("Alert box text --------> " + alertText + " ----------");
		       //System.out.println("Alert param message ---> " + message + " ----------");
		       alert.accept();
		     
		       assertTrue("Alert message is invalid.", message.trim().equals(alertText.trim()));
		       
		     } catch (NoAlertPresentException e2) {
		    	 //System.out.println("++++++ NoAlertPresentException " + e2.getMessage());
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
/*	  
	@And("^confirm window message \"([^\"]*)\"$")
	public void confirmWindowMessage(String message) {
		Alert alert = webDriver.switchTo().alert();
		String alertText = alert.getText();
		//System.out.println("Confirmation message -------> " + alertText);
		//System.out.println("   Parameter message -------> " + message);
		assertTrue("Confirmation message is not correct.", message.trim().equals(alertText.trim()));
		alert.accept();	     	    
	}
*/	

	@And("^display confirmation page message \"([^\"]*)\"$")
	public void functionalDisplayConfirmationPageMessage(String message) {
		webDriver.findElement(By.xpath("//td[contains(text(), '" + message + "')]"));
	}

/*	
	@And("^site \"([^\"]*)\" is still active$") 
	public void functionalSiteNotAllowDeactivation(String siteId) {
		webDriver.findElement(By.xpath("//a[contains(text(), 'active')][@href='webAdmin.do?initparam=updateSiteAccountStatus&site_account_id=" + siteId + "']"));
	} 
*/	
	
	
	@Given("^Nature site administrator is in login page$")
    public void functionalSiteAdminToNature() {
		navigationService.toNatureMySiteAccount(webDriver); 
	}
	
	@When("^site administrator logs in with username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void functionalSiteAdminLogsIn(String username, String password) {
		loginService.loginSiteAdministration(webDriver, username, password); 
	}
	
    @Then("^site administrator should not be able to login with page message \"([^\"]*)\"$") 
    public void functionalSiteAdminNotAbleToLogin(String messageText) {
    	webDriver.findElement(By.xpath("//span[contains(text(), '" + messageText + "')]"));
    }
    
    @Then("^site administrator should be able to login displaying \"([^\"]*)\".$")
    public void functionSiteAdminAbleToLogin(String text) {    	 
    	webDriver.findElement(By.xpath("//p[contains(text(), '" + text + "')]"));
    }
     
        
    @When("^user is on site account search page to fill search fields$")
    public void searchSiteAccounts() {
    	 // to WebAdmin main page
    	navigationService.toWebAdminMainPage(webDriver);
    	
    	// select 'Main Site License Search
    	navigationService.toWebAdminMainSiteLicenseSearch(webDriver);
    }
    
    @Then("^ensure the organization \"([^\"]*)\" is in search result page given the following conditions$")
    public void searchSiteAccountResult(String result, List<SearchItem> items) {
    	for (SearchItem item : items) {
       		
    		//System.out.println(
     		//		  "   item field: " + item.field +
     		//		"\n   item operation condition: " + item.operation +     				
     		//		"\n   item field value: " + item.fieldvalue
     		//		);   	
    		
       		String operationField = searchService.mapOperationFieldSiteLicense(item.field);
       		String operationCondition = searchService.mapOperationConditionSiteLicense(item.operation);
    		String inputField = searchService.mapInputFieldSiteLicense(item.field);
    		String inputFieldValue = item.fieldvalue; 
    
       		//System.out.println(
       		//		  "   operationField: " + operationField +
       		//		"\n   operationCondition: " + operationCondition +
       		//		"\n   inputField: " + inputField +   	
       		//		"\n   inputFieldValue: " + inputFieldValue
       		//		);   		    		
     
    		 
    		
    		searchService.fillAndSubmitInputField(
        			webDriver,
     				operationField,
     				operationCondition,
     	    	    inputField,
     	    	    inputFieldValue,
     	    	    "//input[@value=' Search ' and @type=\"SUBMIT\" and @id=\"search1\"]"  
     	     );  
    		
    		navigationService.navigateToWebAdminMainSiteLicenseSearch(webDriver);
    	}
    }
    
    @Then("^ensure the organization \"([^\"]*)\" is in site administrator result page given the following conditions$")
    public void searchSiteAdminResult(String result, List<SearchItem> items) {
    	for (SearchItem item : items) {
       		
    		//System.out.println(
     		//		  "   item field: " + item.field +
     		//		"\n   item operation condition: " + item.operation +     				
     		//		"\n   item field value: " + item.fieldvalue
     		//		);   	
    		
       		String operationField = searchService.mapOperationFieldSiteLicense(item.field);
       		String operationCondition = searchService.mapOperationConditionSiteLicense(item.operation);
    		String inputField = searchService.mapInputFieldSiteLicense(item.field);
    		String inputFieldValue = item.fieldvalue; 
    
       		//System.out.println(
       		//		  "   operationField: " + operationField +
       		//		"\n   operationCondition: " + operationCondition +
       		//		"\n   inputField: " + inputField +   	
       		//		"\n   inputFieldValue: " + inputFieldValue
       		//		);   		    		
     
       		searchService.inputAndSubmitFieldForSiteAdmin(
       				webDriver, 
       				operationField, 
       				operationCondition, 
       				inputField, 
       				inputFieldValue, 
       				"//input[@value=' Search ' and @type=\"SUBMIT\" and @id=\"search1\"]"); 
       		
    		navigationService.navigateToWebAdminMainSiteLicenseSearch(webDriver);
    	}
    } 
    
    
    
    @Then("^user goes to site licenses list page and delete the following$")
    public void deleteSiteLicenses(List<License> license) {
    	
    }    
      
 
    @And("^add the following new license and verify it is was added$")
    public void addSiteLicenses(List<License> license) {
    
    }
              

    @When("^user is at site license list page$")
    public void toSiteLicenseListPage() {
    	
    }
  
 
    @And("^add the following archived license and verify it is was added$")     
    public void addArchivedSiteLicenses(List<License> license) {
    	
    }
     
}
