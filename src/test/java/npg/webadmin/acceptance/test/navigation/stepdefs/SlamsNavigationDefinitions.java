package npg.webadmin.acceptance.test.navigation.stepdefs; 

import java.util.List;
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import com.google.inject.Inject;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When; 
import npg.webadmin.acceptance.test.util.LoginService;
import npg.webadmin.acceptance.test.util.WebElementsVerificationBaseAbstract.FieldItem;
import npg.webadmin.acceptance.test.service.NavigationService;
import npg.webadmin.acceptance.test.util.LinkElementsVerificationService;
import npg.webadmin.acceptance.test.util.WebDriverFactory;
import npg.webadmin.acceptance.test.util.WebElementsVerificationService;
import npg.webadmin.acceptance.test.WebDriverWrapper;

public class SlamsNavigationDefinitions {
	private static final String WEBADMIN_URL_PREFIX = "/webadmin";
	private static final String NON_WEBADMIN_URL_PREFIX = "";
	
	private WebDriverWrapper webDriver;
	private LoginService loginService;
	private WebElementsVerificationService webElementsVerificationService;
	private NavigationService navigationService;
	private LinkElementsVerificationService linkElementsVerificationService;
	
	@Inject
	public SlamsNavigationDefinitions(
		      LoginService loginService,
			  WebElementsVerificationService webElementsVerificationService,
			  LinkElementsVerificationService linkElementsVerificationService,
			  NavigationService navigationService) {

		this.loginService = loginService;
		this.webElementsVerificationService = webElementsVerificationService;
		this.navigationService = navigationService;
		this.linkElementsVerificationService = linkElementsVerificationService;		
	}
	
	@Before(value="@InitializeSlams")
	public void initializeDriver() {
		webDriver = WebDriverFactory.getWebDriver();
		if (webDriver.getDriver() instanceof HtmlUnitDriver) {    
			((HtmlUnitDriver) webDriver.getDriver()).setJavascriptEnabled(false);  
		}
	}
	 
	@After(value="@CloseSlams")
    public void clear() { 
		if (webDriver != null) {
			webDriver.manage().deleteAllCookies();
			webDriver.quit();
	    }	
	}

	@Given("^user is logged-in as \"([^\"]*)\" password \"([^\"]*)\" for site account search$")
	public void loginWebAdmin(String username, String password) {
		loginService.userLogInWebAdmin(webDriver, username, password);   
	}
	
    @And("^is on SLAMS page for site id \"([^\"]*)\"$")
    public void goToSlamsUsingSiteId(String siteId) {
        // to WebAdmin main page
    	navigationService.toWebAdminMainPage(webDriver);
    	
    	// select 'Main Site License Search
    	navigationService.toWebAdminMainSiteLicenseSearch(webDriver);
    	
    	// search for Site ID
    	navigationService.toWebAdminMainSiteLicenseSearchSiteId(webDriver, siteId);
    	
    	// go to SLAMS page
    	
    	navigationService.toWebAdminSlamsSiteGivenSiteId(webDriver, siteId);
    	
    }
    /*
     * 
     *  SLAMS page navigation testing
     *  
     */    
    @Then("^tabs are present or not at site account SLAMS page$")
    public void tabs_are_present_or_not_at_site_account_SLAMS_page(List<FieldItem> items){
    	webElementsVerificationService.processFieldItems(webDriver, items); 
    }
    
    @And("^ensures these elements are present or not present in the SLAMS current page$") 
    public void ensures_these_elements_are_present_or_not_present_in_the_SLAMS_current_page(List<FieldItem> items){
    	webElementsVerificationService.processFieldItems(webDriver, items); 
    }
    
    
    // 
    //
    // Accessing SLAMS pages as WebAdmin user (Customer Service)(/webadmin/nams/svc/mysiteaccount)
    // 
    // 
    //        
    @When("^on site account summary page$")
    public void on_site_account_summary_page() {			
    	navigationService.toSlamsAccountSummary(webDriver);      
    }
    
    @When("^on site account summary page after checking$")
    public void on_site_account_summary_page_after_checking() {
    	navigationService.toSlamsAccountSummary(webDriver); 
    }
    
    @When("^on site account summary modify user name page$")
    public void on_site_account_summary_modify_user_name_page() {
    	navigationService.toSlamsAccountSummaryEditUserName(webDriver, WEBADMIN_URL_PREFIX);    	
    }
    
    @When("^on site account summary modify password page$")
    public void on_site_account_summary_modify_password_page() {
    	navigationService.toSlamsAccountSummaryEditPassword(webDriver, WEBADMIN_URL_PREFIX); 
    }
    
    @When("^on site account summary modify account details page$")
    public void on_site_account_summary_modify_account_details_page() {
    	navigationService.toSlamsAccountSummaryEditAccountDetails(webDriver, WEBADMIN_URL_PREFIX);
    }
    
    @When("^on site account summary modify open url page$")
    public void on_site_account_summary_modify_open_url_page() {
    	navigationService.toSlamsAccountSummaryEditOpenUrl(webDriver, WEBADMIN_URL_PREFIX);
   
    }
    
    @When("^on site account summary modify email page$")
    public void on_site_account_summary_modify_email_page() {    	
    	navigationService.toSlamsAccountSummaryEditEmail(webDriver, WEBADMIN_URL_PREFIX);  	   
    }
    
    @When("^on site account summary modify address page$")
    public void on_site_account_summary_modify_address_page() {    	
    	navigationService.toSlamsAccountSummaryEditUserAddress(webDriver, WEBADMIN_URL_PREFIX);     
    }
        
    @When("^on site account address page$")
    public void on_site_account_address_page() {    	
    	navigationService.toSlamsAccountAddress(webDriver); 
    }
   
    @When("^on site account modify account address page$")
    public void on_site_account_modify_account_address_page() {
    	navigationService.toSlamsAccountAddressEditAddress(webDriver); 
    }
      
    
    @When("^on site account licenses page$")
    public void on_site_account_licenses_page() { 
    	navigationService.toSlamsAccountLicenses(webDriver); 
    }
    
    @When("^on site account license journal \"([^\"]*)\" page$")
    public void on_site_account_license_journal_page(String productCode) {    	
    	navigationService.toSlamsAccountLicensesJournals(webDriver, WEBADMIN_URL_PREFIX, productCode);  
    }
    
    @When("^on site account article on demand page$")
    public void on_site_account_article_on_demand_page() {
    	navigationService.toSlamsAccountArticleOnDemand(webDriver); 
    }
    
    @When("^on site account article on demand license \"([^\"]*)\" page$")
    public void on_site_account_article_on_demand_license_page(String licenseName) {
    	navigationService.toSlamsAccountArticleOnDemandLicenses(webDriver, licenseName); 
    }
    
    @When("^on site account ip ranges page$")
    public void on_site_account_ip_ranges_page() {
    	navigationService.toSlamsAccountIPRanges(webDriver);		
    }
    
    @When("^on site account ip ranges modification page$")
    public void on_site_account_ip_ranges_modification_page() {
    	navigationService.toSlamsAccountIPRangesEditIPRange(webDriver);
    }  
        
    
    @When("^on site account tokens page$")
    public void on_site_account_tokens_page() {
    	navigationService.toSlamsAccountTokens(webDriver);
    }

    @When("^on site account modify NPG token details page$")
    public void on_site_account_modify_NPG_token_details_page()  {
    	navigationService.toSlamsAccountTokensEditNatureToken(webDriver); 
    }
     
    @When("^on site account modify Palgrave Connect token details page$")
    public void on_site_account_modify_Palgrave_Connect_token_details_page()  {
    	navigationService.toSlamsAccountTokensEditPalgraveConnectToken(webDriver);
    }

    @When("^on site account modify Palgrave Journals token details page$")
    public void on_site_account_modify_Palgrave_Journals_token_details_page()  {
    	navigationService.toSlamsAccountTokensEditPalgraveJournalToken(webDriver); 
    }
    
    
    @When("^on site account statistics page$")
    public void on_site_account_statistics_page() {
    	navigationService.toSlamsAccountStatistics(webDriver);
    }
    
    @When("^on site account e-alerts page$")
    public void on_site_account_e_alerts_page() {
    	navigationService.toSlamsAccountEAlerts(webDriver);
    }
    
    @When("^on site account e-alerts signup page$")
    public void on_site_account_e_alerts_signup_page()  {
    	navigationService.toSlamsAccountEAlertsSignup(webDriver); 
    }
    
    
    @When("^on site account cap page$")
    public void on_site_account_cap_page() {
    	navigationService.toSlamsAccountCap(webDriver);
    	
    }
    
    @When("^on site account modify cap page$")
    public void on_site_account_modify_cap_page() {
    	navigationService.toSlamsAccountCapEditCap(webDriver, WEBADMIN_URL_PREFIX);

    }

    @When("^on site account modify cap password page$")
    public void on_site_account_modify_cap_password_page() {
    	navigationService.toSlamsAccountCapEditPassword(webDriver, WEBADMIN_URL_PREFIX);

    }
 
 
    
    //
    // 
    // Accessing SLAMS pages as Nature, Palgrave Journals or Palgrave Connects
    // Site Administrator (/nams/svc/mysiteaccount)
    //
    //  
       
    @Given("^Nature site administrator is in site account login page$")
    public void Nature_site_administrator_is_in_site_account_login_page(){
    	navigationService.toNatureMySiteAccount(webDriver); 
    }
    
    @Given("^Palgrave Journals site administrator is in site account login page$")
    public void Palgrave_Journals_site_administrator_is_in_site_account_login_page(){
    	navigationService.toPalgraveJournalsMySiteAccount(webDriver);	
    }
    
    @Given("^Palgrave Connect site administrator is in site account login page$")
    public void Palgrave_Connect_site_administrator_is_in_site_account_login_page(){
    	navigationService.toPalgraveConnectMySiteAccount(webDriver);
    }
    
    @When("^site administrator logs in with name \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void site_administrator_logs_in_with_name_and_password(String username, String password) throws Throwable {
    	loginService.loginSiteAdministration(webDriver, username, password); 
    }
    

    @Then("^tabs are present at site administrator SLAMS page$")
    public void tabs_are_present_at_site_administrator_SLAMS_page(List<FieldItem> items){  
    	webElementsVerificationService.processFieldItems(webDriver, items);
    }
    
    @And("^ensures these elements are present or not present in the Site Admin SLAMS current page$")
    public void ensures_these_elements_are_present_or_not_present_in_the_Site_Admin_SLAMS_current_page(List<FieldItem> items){
    	webElementsVerificationService.processFieldItems(webDriver, items);
    }

    @When("^on site administrator account summary modify user name page$")
    public void on_site_administrator_account_summary_modify_user_name_page()  {
    	navigationService.toSlamsAccountSummaryEditUserName(webDriver, NON_WEBADMIN_URL_PREFIX); 
    }

    @When("^on site administrator account summary modify password page$")
    public void on_site_administrator_account_summary_modify_password_page(){
    	navigationService.toSlamsAccountSummaryEditPassword(webDriver, NON_WEBADMIN_URL_PREFIX);
    	// driver.findElement(By.linkText("Account Summary")).click();	
    	// driver.findElement(By.xpath(
   		//      "//a[@href ='/nams/svc/mysiteaccount/edit/passwd']")).click();      
    }
    
    @When("^on site administrator account summary modify account details page$")
    public void on_site_administrator_account_summary_modify_account_details_page() { 
    	navigationService.toSlamsAccountSummaryEditAccountDetails(webDriver, NON_WEBADMIN_URL_PREFIX);
    	//driver.findElement(By.linkText("Account Summary")).click(); 	
    	//driver.findElement(By.xpath(
    	//		"//a[@href ='/nams/svc/mysiteaccount/edit/details']")).click();
    }
    
    @When("^on site administrator account summary modify open url page$")
    public void on_site_administrator_account_summary_modify_open_url_page() {
    	navigationService.toSlamsAccountSummaryEditOpenUrl(webDriver, NON_WEBADMIN_URL_PREFIX);
    	//driver.findElement(By.linkText("Account Summary")).click();    	
    	//driver.findElement(By.xpath(
    	//		"//a[@href ='/nams/svc/mysiteaccount/edit/opurl']")).click();      
    }
    
    @When("^on site administrator account summary modify email page$")
    public void on_site_administrator_account_summary_modify_email_page() {      
    	navigationService.toSlamsAccountSummaryEditEmail(webDriver, NON_WEBADMIN_URL_PREFIX);
    	//driver.findElement(By.linkText("Account Summary")).click();
    	//driver.findElement(By.xpath(
    	//		"//a[@href ='/nams/svc/mysiteaccount/edit/email']")).click();      
    }
    @When("^on site administrator account summary modify address page$")
    public void on_site_administrator_account_summary_modify_address_page() {
    	navigationService.toSlamsAccountSummaryEditUserAddress(webDriver, NON_WEBADMIN_URL_PREFIX);
    	//driver.findElement(By.linkText("Account Summary")).click();
    	//driver.findElement(By.xpath(
    	//		"//a[@href ='/nams/svc/mysiteaccount/edit/address']")).click();      
    }    
    
    @When("^on site administrator account address page$")
    public void on_site_administrator_account_address_page() {
    	navigationService.toSlamsAccountAddress(webDriver); 
    	//driver.findElement(By.linkText("Address Book")).click();
    }
   
    @When("^on site administrator account modify account address page$")
    public void on_site_administrator_account_modify_account_address_page() {
    	navigationService.toSlamsAccountAddressEditAddress(webDriver);
    	//driver.findElement(By.linkText("Address Book")).click();
    	//driver.findElement(By.linkText("Modify")).click();
    }
      
    
    @When("^on site administrator account licenses page$")
    public void on_site_administrator_account_licenses_page() {
    	navigationService.toSlamsAccountLicenses(webDriver);
    	//driver.findElement(By.linkText("Licenses")).click(); 	
    }
    
    @When("^on site administrator account license journal \"([^\"]*)\" page$")
    public void on_site_administrator_account_license_journal_page(String productCode) {
    	navigationService.toSlamsAccountLicensesJournals(webDriver, NON_WEBADMIN_URL_PREFIX, productCode);
    	//driver.findElement(By.linkText("Licenses")).click(); 	    	
    	//driver.findElement(By.xpath(
    	//  "//a[@href ='/nams/svc/mysiteaccount/show/product_license?product=" + productCode + "']")).click();      	
    }
    
    @When("^on site administrator account article on demand page$")
    public void on_site_administrator_account_article_on_demand_page() {    	
    	navigationService.toSlamsAccountArticleOnDemand(webDriver);
		//driver.findElement(By.linkText("AOD")).click();  	
    }
    
    @When("^on site administrator account article on demand license \"([^\"]*)\" page$")    
    public void on_site_administrator_account_article_on_demand_license_page(String licenseName) {
    	navigationService.toSlamsAccountArticleOnDemandLicenses(webDriver, licenseName);
    	//driver.findElement(By.linkText("AOD")).click();
    	//driver.findElement(By.linkText(licenseName)).click();
    }
    
    @When("^on site administrator account ip ranges page$")
    public void on_site_administrator_account_ip_ranges_page() {
    	navigationService.toSlamsAccountIPRanges(webDriver);
		//driver.findElement(By.linkText("IP Ranges")).click(); 	
    }
    
    @When("^on site administrator account ip ranges modification page$")
    public void on_site_administrator_account_ip_ranges_modification_page() {    	
    	navigationService.toSlamsAccountIPRangesEditIPRange(webDriver);
    	//driver.findElement(By.linkText("IP Ranges")).click();   	
    	//driver.findElement(By.linkText("Edit")).click();
    }  
        
    
    @When("^on site administrator account tokens page$")
    public void on_site_administrator_account_tokens_page() {
    	navigationService.toSlamsAccountTokens(webDriver);
		//driver.findElement(By.linkText("Tokens")).click();     	
    }

    @When("^on site administrator account modify NPG token details page$")
    public void on_site_administrator_account_modify_NPG_token_details_page()  {    
    	navigationService.toSlamsAccountTokensEditNatureToken(webDriver);
    	//driver.findElement(By.linkText("Tokens")).click();
    	//driver.findElement(By.xpath(
    	//		"//input[@src ='/store/images/button_modify.gif'][ancestor::form//input[@value='NPG']]")).click();  
    }

     
    @When("^on site administrator account modify Palgrave Connect token details page$")
    public void on_site_administrator_account_modify_Palgrave_Connect_token_details_page()  {
    	navigationService.toSlamsAccountTokensEditPalgraveConnectToken(webDriver);
    	//driver.findElement(By.linkText("Tokens")).click();
    	//driver.findElement(By.xpath(
    	//		"//input[@src ='/store/images/button_modify.gif' and @alt='Change existing token value.']")).click();
    }

    @When("^on site administrator account modify Palgrave Journals token details page$")
    public void on_site_administrator_account_modify_Palgrave_Journals_token_details_page()  {
    	navigationService.toSlamsAccountTokensEditPalgraveJournalToken(webDriver);
    	//driver.findElement(By.linkText("Tokens")).click();
    	//driver.findElement(By.xpath(
    	//  "//input[@src ='/store/images/button_modify.gif'][ancestor::form//input[@value='Palgrave Journals']]")).click();
    }
    
    
    @When("^on site administrator account statistics page$")
    public void on_site_administrator_account_statistics_page() {
    	navigationService.toSlamsAccountStatistics(webDriver);
		//driver.findElement(By.linkText("Statistics")).click();
 	    	
    }
     
    @When("^on site administrator account e-alerts page$")
    public void on_site_administrator_account_e_alerts_page() {
    	navigationService.toSlamsAccountEAlerts(webDriver);
    	//driver.findElement(By.linkText("E-alerts")).click();        	
    }
    
    @When("^on site administrator account e-alerts signup page$")
    public void on_site_administrator_account_e_alerts_signup_page()  {
    	navigationService.toSlamsAccountEAlertsSignup(webDriver);
    	//driver.findElement(By.linkText("E-alerts")).click();
    	//driver.findElement(By.linkText("Modify")).click(); 
    }
    
    
    @When("^on site administrator account cap page$")
    public void on_site_administrator_account_cap_page() {
    	navigationService.toSlamsAccountCap(webDriver);
    	//driver.findElement(By.linkText("CAP")).click();
    }
    
    @When("^on site administrator account modify cap page$")
    public void on_site_administrator_account_modify_cap_page() {
    	navigationService.toSlamsAccountCapEditCap(webDriver, NON_WEBADMIN_URL_PREFIX);
    	//driver.findElement(By.linkText("CAP")).click();
    	//driver.findElement(By.xpath(
    	//    	  "//a[contains(text(),'Modify')][@href ='/nams/svc/mysiteaccount/editcapuserdetail']")).click();
    }

    @When("^on site administrator account modify cap password page$")
    public void on_site_administrator_account_modify_cap_password_page() {
    	navigationService.toSlamsAccountCapEditPassword(webDriver, NON_WEBADMIN_URL_PREFIX);
    	//driver.findElement(By.linkText("CAP")).click();
       	//driver.findElement(By.xpath(
  	    //	  "//a[contains(text(),'Modify')][@href ='/nams/svc/mysiteaccount/editcapuserpassword']")).click();
    }   
	
 
}
