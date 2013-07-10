package npg.webadmin.acceptance.test.navigation.stepdefs;

import java.util.List;
import npg.webadmin.acceptance.test.util.WebDriverFactory;
import npg.webadmin.acceptance.test.WebDriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.inject.Inject;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import npg.webadmin.acceptance.test.service.NavigationService;
import npg.webadmin.acceptance.test.util.LoginService;
import npg.webadmin.acceptance.test.util.WebElementsVerificationService;
import npg.webadmin.acceptance.test.util.WebElementsVerificationBaseAbstract.FieldItem;
import npg.webadmin.acceptance.test.util.LinkElementsVerificationService;

public class MyAccountNavigationDefinitions {
	private WebDriverWrapper webDriver;
	private LoginService loginService;
	private WebElementsVerificationService webElementsVerificationService;
	private NavigationService navigationService;
	private LinkElementsVerificationService linkElementsVerificationService;
	@Inject
	public MyAccountNavigationDefinitions(
			  LoginService loginService,
			  WebElementsVerificationService webElementsVerificationService,
			  LinkElementsVerificationService linkElementsVerificationService,
			  NavigationService navigationService) {		
	    
		this.loginService = loginService;
		this.webElementsVerificationService = webElementsVerificationService;
		this.navigationService = navigationService;
		this.linkElementsVerificationService = linkElementsVerificationService;
	}
	
	@Before(value="@InitializeMyAccount")
	public void initializeDriver() {
		webDriver = WebDriverFactory.getWebDriver();
	}
	 
	@After(value="@CloseMyAccount")
    public void clear() {		 
	    if (webDriver != null) {
	    	webDriver.manage().deleteAllCookies();
	    	webDriver.quit();
	    	webDriver = null;
	    }	
	}
	
	//   ------------ WebAdmin My Account Page  ------------------  //
	 
    @Given("^webadmin user is logged-in using username \"([^\"]*)\" password \"([^\"]*)\"$") 
    public void userLoggedInToWebAdmin(String username, String password){
    	//webDriver.manage().deleteAllCookies();
    	loginService.userLogInWebAdmin(webDriver, username, password);    	 
    }
    
    @And("^is on personal account search page and searches orcid \"([^\"]*)\"$")
    public void searchOrcidAccount(String orcid) {
    	navigationService.toWebAdminPersonalAccountSearch(webDriver);
    	navigationService.webAdminSearchOrcidAccount(webDriver, orcid);
    }
    
    @Then("^ensure that orcid account \"([^\"]*)\" is present in personal account search result page$")
    public void orcidAccountIsPresentInTheResultPage(String accountName) {
    	linkElementsVerificationService.verifyElementLinkText(webDriver, accountName);
    	
    }
    
    @When("^searched personal account \"([^\"]*)\" is selected$")
    public void personalAccountIsSelectedFromWebadmin(String accountName) {
    	navigationService.toWebAdminMyAccountGivenEmail(webDriver, accountName);
    }
    
    
    
    @When("^user is on WebAdmin account profile address book modification page$")
    public void user_is_on_WebAdmin_account_profile_address_book_modification_page() throws Throwable {
    	navigationService.toMyAccountProfileEditContactInformation(webDriver);
        
    }

    @When("^user is on WebAdmin my account profile change password page$")
    public void user_is_on_WebAdmin_my_account_profile_change_password_page() throws Throwable {
    	navigationService.toMyAccountProfileEditPassword(webDriver);
        
    }

    @When("^user is on WebAdmin my account profile change email page$")
    public void user_is_on_WebAdmin_my_account_profile_change_email_page() throws Throwable {
    	navigationService.toMyAccountProfileEditEmail(webDriver);
         
    }

    @When("^user is on WebAdmin my account profile work details page$")
    public void user_is_on_WebAdmin_my_account_profile_work_details_page() throws Throwable {
    	navigationService.toMyAccountProfileEditWorkDetails(webDriver);
        
    }

    @When("^user is on WebAdmin my account maximum login page$")
    public void user_is_on_WebAdmin_my_account_maximum_login_page() throws Throwable {
    	navigationService.toWebAdminMyAccountEditProfileMaximumLogin(webDriver);
         
    }

    @When("^user is on WebAdmin my account user navigate to alerts page$")
    public void user_is_on_WebAdmin_my_account_user_navigate_to_alerts_page() throws Throwable {
    	navigationService.toMyAccountAlerts(webDriver);
        
    }

    @When("^user is on WebAdmin my account user navigate to alerts modification page$")
    public void user_is_on_WebAdmin_my_account_user_navigate_to_alerts_modification_page() throws Throwable {
    	navigationService.toMyAccountAlertsEditAlerts(webDriver);
         
    }

    @When("^user is on WebAdmin my account user navigate to subscriptions and purchases page$")
    public void user_is_on_WebAdmin_my_account_user_navigate_to_subscriptions_and_purchases_page() throws Throwable {
    	navigationService.toMyAccountSubscriptionsPurchases(webDriver);
         
    }

    
    
    
    
    //   ------------ User My Account Page  ------------------  //
    
    @Given("^user is logged-in as \"([^\"]*)\" password \"([^\"]*)\" for user personal account search$")
    public void user_is_logged_in_as_password_for_user_personal_account_search(String username, String password)  {
       	webDriver.manage().deleteAllCookies(); 
    	loginService.loginMyAccount(webDriver, username, password); 
    }
    
    @When("^is on user my account profile page$")
    public void is_on_user_my_account_profile_page()  {  
    	navigationService.toMyAccountProfile(webDriver);    	
    	webDriver.findElement(By.xpath("//title[contains(text(), 'My Account - Your profile')]"));
    }
  
    @When("^is on user my account profile address book modification page$")
    public void is_on_user_my_account_profile_address_book_modification_page() {  
    	navigationService.toMyAccountProfileEditContactInformation(webDriver);
    }
 
    @When("^is on user my account profile change password page$")
    public void is_on_user_my_account_profile_change_password_page() {
    	navigationService.toMyAccountProfileEditPassword(webDriver);
    }
 
    
    @When("^is on user my account profile change email page$")
    public void is_on_user_my_account_profile_change_email_page() {
    	navigationService.toMyAccountProfileEditEmail(webDriver);
    }
 
    @When("^is on user my account profile work details page$")
    public void is_on_user_my_account_profile_work_details_page() {
    	navigationService.toMyAccountProfileEditWorkDetails(webDriver);
    }  

    @When("^my account user navigate to alerts page$")
    public void my_account_user_navigate_to_alerts_page() { 
    	navigationService.toMyAccountAlerts(webDriver);
    }
 
    @When("^my account user navigate to alerts modification page$")
    public void my_account_user_navigate_to_alerts_modification_page() {
    	navigationService.toMyAccountAlertsEditAlerts(webDriver);
    }
 
    @When("^my account user navigate to subscriptions and purchases page$")
    public void my_account_user_navigate_to_subscriptions_and_purchases_page() {
    	navigationService.toMyAccountSubscriptionsPurchases(webDriver);
    }

    @Then("^ensure these elements are present or not present in the current my account page$")
    public void ensure_these_elements_are_present_or_not_present_in_the_current_my_account_page(List<FieldItem> items) {
    	webElementsVerificationService.processFieldItems(webDriver, items);  
    }
 	 
}
