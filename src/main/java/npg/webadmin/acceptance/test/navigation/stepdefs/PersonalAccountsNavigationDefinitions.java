package npg.webadmin.acceptance.test.navigation.stepdefs;

import java.util.List;

import npg.webadmin.acceptance.test.util.WebDriverFactory;

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
import npg.webadmin.acceptance.test.util.LoginService;
import npg.webadmin.acceptance.test.util.WebElementsVerificationService;
import npg.webadmin.acceptance.test.util.WebElementsVerificationBaseAbstract.FieldItem;

public class PersonalAccountsNavigationDefinitions {
	private WebDriver webDriver;
	private LoginService loginService;
	private WebElementsVerificationService webElementsVerificationService;
	
	@Inject
	public PersonalAccountsNavigationDefinitions(
			  LoginService loginService,
			  WebElementsVerificationService webElementsVerificationService) {		
	    
		this.loginService = loginService;
		this.webElementsVerificationService = webElementsVerificationService;
	}
	
	@Before(value="@InitializePersonal")
	public void initializeDriver() {
		webDriver = WebDriverFactory.createWebDriver();
	}
	 
	@After(value="@ClosePersonal")
    public void clear() {		 
	    if (webDriver != null) {
	    	webDriver.quit();
	    }	
	}
	  
    //   ------------ User My Account Page  ------------------  //
    
    @Given("^user is logged-in as \"([^\"]*)\" password \"([^\"]*)\" for user personal account search$")
    public void user_is_logged_in_as_password_for_user_personal_account_search(String username, String password)  {
       	webDriver.manage().deleteAllCookies(); 
    	loginService.loginMyAccount(webDriver, username, password); 
    }
    
    @When("^is on user my account profile page$")
    public void is_on_user_my_account_profile_page()  {
    	
    	 // wait to load the My Account Profile page
    	(new WebDriverWait(webDriver, 30)).until( new ExpectedCondition<Boolean> () {
     		public Boolean apply(WebDriver d) {				     			 
     				return d.getTitle().equals("My Account - Your profile") ;
     		}
     	});
    	 
    	webDriver.findElement(By.xpath("//title[contains(text(), 'My Account - Your profile')]"));
    }
  
    @When("^is on user my account profile address book modification page$")
    public void is_on_user_my_account_profile_address_book_modification_page() {
    	// go to Profile
    	webDriver.findElement(By.xpath("//span[contains(text(), 'Profile')][parent::a]")).click(); 
    	// go to Address book page
    	webDriver.findElement(By.xpath("//a[contains(text(), 'Edit')][@title='Edit contact information']")).click();
    }
 
    @When("^is on user my account profile change password page$")
    public void is_on_user_my_account_profile_change_password_page() {
       	// go to Profile
    	webDriver.findElement(By.xpath("//span[contains(text(), 'Profile')][parent::a]")).click(); 
    	// go to Edit email page
    	webDriver.findElement(By.xpath("//a[contains(text(), 'Edit')][@title='Edit password']")).click(); 
    }
 
    
    @When("^is on user my account profile change email page$")
    public void is_on_user_my_account_profile_change_email_page() {
    	// go to Profile
    	webDriver.findElement(By.xpath("//span[contains(text(), 'Profile')][parent::a]")).click(); 
    	// go to Edit email page
    	webDriver.findElement(By.xpath("//a[contains(text(), 'Edit')][@title='Edit email']")).click(); 
    }
 
    @When("^is on user my account profile work details page$")
    public void is_on_user_my_account_profile_work_details_page() {
       	// go to Profile
    	webDriver.findElement(By.xpath("//span[contains(text(), 'Profile')][parent::a]")).click(); 
    	// go to Details page 
    	webDriver.findElement(By.xpath("//a[contains(text(), 'Edit')][@title='Edit Education and Work details']")).click(); 
    }  

    @When("^my account user navigate to alerts page$")
    public void my_account_user_navigate_to_alerts_page() {
    	webDriver.findElement(By.xpath("//span[contains(text(), 'Alerts')][parent::a[@href='/nams/svc/myaccount/show/ealerts']]")).click();     
    }
 
    @When("^my account user navigate to alerts modification page$")
    public void my_account_user_navigate_to_alerts_modification_page() {
      	// go to Alerts
    	webDriver.findElement(By.xpath("//span[contains(text(), 'Alerts')][parent::a[@href='/nams/svc/myaccount/show/ealerts']]")).click(); 
    	// go to Modify Alerts
    	webDriver.findElement(By.xpath("//a[contains(text(), 'Modify')][@title='Modify alert settings']")).click(); 
    }
 
    @When("^my account user navigate to subscriptions and purchases page$")
    public void my_account_user_navigate_to_subscriptions_and_purchases_page() {
    	webDriver.findElement(By.xpath("//span[contains(text(), 'Subscriptions and Purchases')]" + 
                "[parent::a[@href='/nams/svc/myaccount/show/subs']]")).click(); 
    }

    @Then("^ensure these elements are present or not present in the current my account page$")
    public void ensure_these_elements_are_present_or_not_present_in_the_current_my_account_page(List<FieldItem> items) {
    	webElementsVerificationService.processFieldItems(webDriver, items);  
    }
 	 
}
