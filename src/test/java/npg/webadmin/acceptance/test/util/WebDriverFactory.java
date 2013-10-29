package npg.webadmin.acceptance.test.util;

import java.util.ResourceBundle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import npg.webadmin.acceptance.test.WebDriverWrapper;

public class WebDriverFactory {

	public static WebDriver createWebDriver() {
		HtmlUnitDriver webDriver = null;
	
	    ResourceBundle resource = ResourceBundle.getBundle("webadmin-selenium");
	    
    	//System.out.println("++++ Initializing the web driver +++++");
       	
       	String browserToUse = ResourceBundle.getBundle("webadmin-selenium").getString("browser.to.use");
       	
       	if (browserToUse.trim().toLowerCase().equals("chrome")) {
   	       System.setProperty("webdriver.chrome.driver", resource.getString("chromedriver.file"));   	    
   	       //webDriver = new ChromeDriver();  	       
   	    
       	} else if (browserToUse.trim().toLowerCase().equals("chromehtml")){   
       		webDriver = new HtmlUnitDriver(BrowserVersion.CHROME);
       		webDriver.setJavascriptEnabled(true);       		 
   		    //((HtmlUnitDriver) webDriver).setJavascriptEnabled(true);   		
    	} else if (browserToUse.trim().toLowerCase().equals("chrome16")){       		 
       		webDriver = new HtmlUnitDriver(BrowserVersion.CHROME_16);       		 
    	} else if (browserToUse.trim().toLowerCase().equals("htmlunit")){   
    	    webDriver = new HtmlUnitDriver(true); 	                      // turn-on javascript
       	} else if (browserToUse.trim().toLowerCase().equals("foxtrot17")){
       		//webDriver = new FirefoxDriver();
       		webDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_17);
       	} else if (browserToUse.trim().toLowerCase().equals("foxtrot10")){       		
       		webDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_10);
       	} else if (browserToUse.trim().toLowerCase().equals("foxtrot3")){       
       		webDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_3_6);       		
       	} else if (browserToUse.trim().toLowerCase().equals("safari")){
       		//webDriver = new SafariDriver();       		 
    	} else if (browserToUse.trim().toLowerCase().equals("explorer") || 
    			 browserToUse.trim().toLowerCase().equals("iexplorer")){
    		//webDriver = new InternetExplorerDriver();           	        
       	} else {  // default
       		webDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_17);
       		webDriver.setJavascriptEnabled(true);
       	}  
       
       	
       	String environment = resource.getString("environment");       	
       	//System.out.println(" +++++ environment: " + environment);       	
   	    //driver.get("http://" + resource.getString("host." + environment) + "/webadmin");
       	return webDriver;
	}
	
	public static WebDriverWrapper getWebDriver() {
		return new WebDriverWrapper();
	}
	
}
