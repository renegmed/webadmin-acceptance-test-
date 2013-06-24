package npg.webadmin.acceptance.test.guice;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.google.inject.Binder;
import com.google.inject.Module;
import npg.webadmin.acceptance.test.util.LoginService; 

public class WebAdminGuiceModule implements Module {
  
	
	public void configure(Binder binder) {
		//binder.bind(Greeter.class).to(FriendlyGreeter.class);
		//binder.bind(WebDriver.class).to(createWebDriver());
		binder.bind(LoginService.class).toInstance(new LoginService(getResource()));
		System.out.println("+++++ WebAdminGuiceModule.configure +++++++");
	}

	protected ResourceBundle getResource() {
		 ResourceBundle resource = ResourceBundle.getBundle("webadmin-selenium");
		 return resource;
	}
	
	protected Class createWebDriver() {
		    Class driverClass = null;
		
		    ResourceBundle resource = ResourceBundle.getBundle("webadmin-selenium");
		    
	    	System.out.println("++++ Initializing the web driver +++++");
	       	
	       	String browserToUse = ResourceBundle.getBundle("webadmin-selenium").getString("browser.to.use");
	       	
	       	if (browserToUse.trim().toLowerCase().equals("chrome")) {
	   	       System.setProperty("webdriver.chrome.driver", resource.getString("chromedriver.file"));   	    
	   	       driverClass = ChromeDriver.class;
	       	} else if (browserToUse.trim().toLowerCase().equals("foxtrot")){
	       	   driverClass = FirefoxDriver.class;
	       	} else if (browserToUse.trim().toLowerCase().equals("safari")){
	       	   driverClass = SafariDriver.class;  
	    	} else if (browserToUse.trim().toLowerCase().equals("explorer") || 
	    			 browserToUse.trim().toLowerCase().equals("iexplorer")){
	    	   driverClass = InternetExplorerDriver.class;           	        
	       	} else {  // default
	       		driverClass = FirefoxDriver.class;	
	       	}
	       	
	       	String environment = resource.getString("environment");       	
	       	System.out.println(" +++++ environment: " + environment);       	
	   	    //driver.get("http://" + resource.getString("host." + environment) + "/webadmin");
	       	return driverClass;
	}
	    
}
