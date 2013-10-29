package npg.webadmin.acceptance.test.util;

import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import npg.webadmin.acceptance.test.WebDriverWrapper;
import npg.webadmin.acceptance.test.Constants;
 

public class LoginService {
     private ResourceBundle resource = null;     
     
	 public LoginService(ResourceBundle resource) {
	    this.resource = resource;	 
	 }

	 public void toWebAdminMainPage(WebDriverWrapper webDriver) {
	    String environment = resource.getString("environment");
		String targetHost = resource.getString("host." + environment);
		//webDriver.navigate().to("http://" + targetHost + "/webadmin");
		webDriver.get("http://" + targetHost + "/webadmin"); 
		
	 }
	 
	 
	 public void toWebAdminLoginPage(WebDriverWrapper webDriver) { 
		String environment = resource.getString("environment");
		String targetHost = resource.getString("host." + environment);		
			//webDriver.navigate().to("http://" + targetHost + "/webadmin/adminlogin.do");
		webDriver.get("http://" + targetHost + "/webadmin/adminlogin.do");
		webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
	 }

	 
	 public void userLogIn(WebDriverWrapper webDriver) {  			
		// test if a user is already logged-in
		try { 
			webDriver.findElement(By.linkText("Logout"));
			System.out.println("====== Already logged in. No need to log in.  ======");
			  
		} catch (NoSuchElementException e) {  // user has not been logged-in		
		    
			System.out.println("====== Going to log in. ======");
				 
			String username=resource.getString("login.username");
		    String password = resource.getString("login.password");    	
		    userLogInWebAdmin(webDriver, username, password);  
		}
	}
 
	public void userLogInWebAdmin(WebDriverWrapper webDriver, String username, String password) {  
		toWebAdminLoginPage(webDriver);
		WebElement userIdElement = webDriver.findElement(By.xpath("//input[@id='login-username']"));  
		WebElement passwordElement = webDriver.findElement(By.xpath("//input[@id='login-password']"));  
		
		userIdElement.sendKeys(username);
		passwordElement.sendKeys(password);		
		//webDriver.findElement(By.id("login-submit")).click();
		webDriver.findElement(By.xpath("//input[@id='login-submit']")).submit();
		 
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}	

	public void userLogoutWebAdmin(WebDriver webDriver) {	
		try {
		  WebElement logoutElement = webDriver.findElement(By.linkText("Logout"));  
	  	  logoutElement.click();
		  webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
 
		} catch (NoSuchElementException e) {
		  // do nothing	
		}
	}
	
	
	
	
	public void loginMyAccount(WebDriverWrapper driver, String username, String password) {  			
		 
		Constants.LOGGER.info("====== Going to log in. ======");				 
		String environment = resource.getString("environment");
		String targetHost = resource.getString("host." + environment); 	    
		driver.navigate().to("http://" + targetHost + "/nams/svc/myaccount");
		//driver.get("http://" + targetHost + "/nams/svc/myaccount");
		WebElement userIdElement = driver.findElement(By.id("email"));  
		WebElement passwordElement = driver.findElement(By.id("password"));  
		userIdElement.sendKeys(username);
		passwordElement.sendKeys(password);
			
		driver.findElement(By.xpath("//input[@value='Login' and @type='submit']")).submit(); 	 
		//driver.findElement(By.linkText("Logout"));		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
	}
	
	public void loginNatureAsLibrarian(WebDriverWrapper driver, String username, String password) {  			
		 
		Constants.LOGGER.info("====== Going to log in. ======");				 
		String environment = resource.getString("environment");
		String targetHost = resource.getString("host." + environment); 	    
		driver.navigate().to("http://" + targetHost + "/webadmin/nams/svc/mysiteaccount");
		//driver.get("http://" + targetHost + "/webadmin/nams/svc/mysiteaccount");
		WebElement userIdElement = driver.findElement(By.name("userId"));  
		WebElement passwordElement = driver.findElement(By.name("password"));  
		userIdElement.sendKeys(username);
		passwordElement.sendKeys(password);
			
		driver.findElement(By.xpath("//input[@type='image' and @src='/store/images/btn_login.gif']")).submit(); 	 
		//driver.findElement(By.linkText("Logout"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	public void loginSiteAdministration(WebDriverWrapper webDriver, String username, String password) {  
		WebElement userIdElement = webDriver.findElement(By.name("userId"));  
		WebElement passwordElement = webDriver.findElement(By.name("password"));  
		userIdElement.sendKeys(username);
		passwordElement.sendKeys(password);		
		webDriver.findElement(By.xpath("//input[@type='image' and @src='/store/images/btn_login.gif']")).click(); 
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
	}	
}
