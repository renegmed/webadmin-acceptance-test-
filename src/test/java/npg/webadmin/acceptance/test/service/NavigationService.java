package npg.webadmin.acceptance.test.service;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import npg.webadmin.acceptance.test.WebDriverWrapper;


public class NavigationService {
     private ResourceBundle resource = null;     
     
	 public NavigationService(ResourceBundle resource) {
	    this.resource = resource;	 
	 }
 
	 public void toMyAccountProfile(WebDriverWrapper webDriver) {
		 webDriver.findElement(By.xpath("//span[contains(text(), 'Profile')][parent::a]")).click(); 
	 }
	 
	 public void toMyAccountProfileEditPassword(WebDriverWrapper webDriver) {
		// go to Profile
	   	webDriver.findElement(By.xpath("//span[contains(text(), 'Profile')][parent::a]")).click(); 
	   	// go to Edit email page
	   	webDriver.findElement(By.xpath("//a[contains(text(), 'Edit')][@title='Edit password']")).click(); 
	 }
	 
	 public void toMyAccountProfileEditContactInformation(WebDriverWrapper webDriver) {
		// go to Profile
	   	webDriver.findElement(By.xpath("//span[contains(text(), 'Profile')][parent::a]")).click(); 
	   	// go to Edit Contact Information
	   	webDriver.findElement(By.xpath("//a[contains(text(), 'Edit')][@title='Edit contact information']")).click();
	 }
	 
	 public void toMyAccountProfileEditEmail(WebDriverWrapper webDriver) {
		// go to Profile
	   	webDriver.findElement(By.xpath("//span[contains(text(), 'Profile')][parent::a]")).click(); 
    	// go to Edit email page
    	webDriver.findElement(By.xpath("//a[contains(text(), 'Edit')][@title='Edit email']")).click();  
	 }
	 
	 public void toMyAccountProfileEditWorkDetails(WebDriverWrapper webDriver) {
		// go to Profile
	   	webDriver.findElement(By.xpath("//span[contains(text(), 'Profile')][parent::a]")).click(); 
    	// go to Work Details page 
    	webDriver.findElement(By.xpath("//a[contains(text(), 'Edit')][@title='Edit Education and Work details']")).click(); 
	 } 	 
	 
	 public void toMyAccountAlerts(WebDriverWrapper webDriver) {
		 webDriver.findElement(By.xpath("//span[contains(text(), 'Alerts')][parent::a]")).click();      
	 }
	 
	 public void toMyAccountAlertsEditAlerts(WebDriverWrapper webDriver) {
	   	// go to Alerts
		webDriver.findElement(By.xpath("//span[contains(text(), 'Alerts')][parent::a]")).click();    
	    // go to Modify Alerts
	   	webDriver.findElement(By.xpath("//a[contains(text(), 'Modify')][@title='Modify alert settings']")).click();    	
	 }

	 public void toMyAccountSubscriptionsPurchases(WebDriverWrapper webDriver) {
	    webDriver.findElement(By.xpath("//span[contains(text(), 'Alerts')][parent::a]")).click();
		webDriver.findElement(By.xpath("//span[contains(text(), 'Subscriptions and Purchases')][parent::a]")).click();  
	 }
	 
	 public void toWebAdminMainPage(WebDriverWrapper webDriver) {
	    String environment = resource.getString("environment");
		String targetHost = resource.getString("host." + environment);
		webDriver.navigate().to("http://" + targetHost + "/webadmin"); 
	 }
	 
	 public void toWebAdminPersonalAccountSearch(WebDriverWrapper webDriver) {		 
		 webDriver.findElement(By.xpath("//a[contains(text(), 'Main Personal Account Search')]")).click();  	
	 }	 
	 
	 public void webAdminSearchOrcidAccount(WebDriverWrapper webDriver, String orcid) {
		WebElement inputOrcidElement = webDriver.findElement(By.xpath("//input[@name='orcid_id']"));		 
		inputOrcidElement.sendKeys(orcid);		 
		webDriver.findElement(By.id("search2")).click();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
	 
	 public void toWebAdminMyAccountGivenEmail(WebDriverWrapper webDriver, String email) {
		 webDriver.findElement(By.xpath("//a[contains(text(), '" + email + "') and @title='Edit account in My Account page']")).click();
		 webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		 
	 }
	 
	 public void toWebAdminMyAccountEditProfileMaximumLogin(WebDriverWrapper webDriver) {
		// go to Profile
	 	webDriver.findElement(By.xpath("//span[contains(text(), 'Profile')][parent::a]")).click(); 
	   	// go to Work Details page 
	   	webDriver.findElement(By.xpath("//a[contains(text(), 'Edit') and @title='Edit max logins']")).click(); 	 
	 }	 
	 
}
