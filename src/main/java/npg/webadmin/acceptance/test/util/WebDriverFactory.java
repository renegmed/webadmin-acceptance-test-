package npg.webadmin.acceptance.test.util;

import java.util.ResourceBundle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

	public static WebDriver createWebDriver() {
		WebDriver webDriver = null;
	
	    ResourceBundle resource = ResourceBundle.getBundle("webadmin-selenium");
	    
    	System.out.println("++++ Initializing the web driver +++++");
       	
       	String browserToUse = ResourceBundle.getBundle("webadmin-selenium").getString("browser.to.use");
       	
       	if (browserToUse.trim().toLowerCase().equals("chrome")) {
   	       System.setProperty("webdriver.chrome.driver", resource.getString("chromedriver.file"));   	    
   	       webDriver = new ChromeDriver();
       	} else if (browserToUse.trim().toLowerCase().equals("foxtrot")){
       		webDriver = new FirefoxDriver();
       	} else if (browserToUse.trim().toLowerCase().equals("safari")){
       		webDriver = new SafariDriver();  
    	} else if (browserToUse.trim().toLowerCase().equals("explorer") || 
    			 browserToUse.trim().toLowerCase().equals("iexplorer")){
    		webDriver = new InternetExplorerDriver();           	        
       	} else {  // default
       		webDriver = new FirefoxDriver();	
       	}       	
       	String environment = resource.getString("environment");       	
       	//System.out.println(" +++++ environment: " + environment);       	
   	    //driver.get("http://" + resource.getString("host." + environment) + "/webadmin");
       	return webDriver;
	}
}
