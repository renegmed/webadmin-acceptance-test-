package npg.webadmin.acceptance.test;

import java.util.ResourceBundle;
import java.util.List;
import java.util.Set;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver.Navigation;

public class WebDriverWrapper implements WebDriver{
	
	private ResourceBundle resource = null; 	
	private Object objDriver = null;	
	 
	public WebDriverWrapper(){  
	    
	    resource = ResourceBundle.getBundle("webadmin-selenium"); 
       	String browserToUse = ResourceBundle.getBundle("webadmin-selenium").getString("browser.to.use");
       	
       	if (browserToUse.trim().toLowerCase().equals("chrome")) {
   	       System.setProperty("webdriver.chrome.driver", resource.getString("chromedriver.file"));   	    
   	       objDriver = (WebDriver) new ChromeDriver();  	       
   	    
       	} else if (browserToUse.trim().toLowerCase().equals("chromehtml")){   
       		HtmlUnitDriver htmlUnitDriver = new HtmlUnitDriver(BrowserVersion.CHROME);       		
       		//((HtmlUnitDriver)objDriver).setJavascriptEnabled(true);
   		
    	} else if (browserToUse.trim().toLowerCase().equals("chrome16")){       		 
    		objDriver = new HtmlUnitDriver(BrowserVersion.CHROME_16);
    		//((HtmlUnitDriver)objDriver).setJavascriptEnabled(true);
    		
    	} else if (browserToUse.trim().toLowerCase().equals("htmlunit")){   
    		objDriver = new HtmlUnitDriver(true);     		// turn-on javascript
    		//objDriver = new HtmlUnitDriver();
    		
    	} else if (browserToUse.trim().toLowerCase().equals("foxtrot")){
       		objDriver = (WebDriver) new FirefoxDriver();   
       		
       	} else if (browserToUse.trim().toLowerCase().equals("foxtrot17")){
       		//webDriver = new FirefoxDriver();
       		objDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_17);
       		//((HtmlUnitDriver)objDriver).setJavascriptEnabled(true);
       		
       	} else if (browserToUse.trim().toLowerCase().equals("foxtrot10")){       		
       		objDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_10);
       		//((HtmlUnitDriver)objDriver).setJavascriptEnabled(true);
       		
       	} else if (browserToUse.trim().toLowerCase().equals("foxtrot3")){       
       		objDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_3_6);
       		//((HtmlUnitDriver)objDriver).setJavascriptEnabled(true);
       		
       	} else if (browserToUse.trim().toLowerCase().equals("safari")){
       		objDriver = (WebDriver)new SafariDriver();       		 
    	
       	} else if (browserToUse.trim().toLowerCase().equals("explorer") || 
    			 browserToUse.trim().toLowerCase().equals("iexplorer")){
    	
       	    objDriver = (WebDriver) new InternetExplorerDriver();           	        
       	
       	} else {  // default
       		objDriver = new HtmlUnitDriver(BrowserVersion.FIREFOX_17);
       		//((HtmlUnitDriver)objDriver).setJavascriptEnabled(true);
       	}  
       
	}
	
	public Object getDriver() {
		return objDriver;
	}

	  /**
	   * Load a new web page in the current browser window. This is done using an HTTP GET operation,
	   * and the method will block until the load is complete. This will follow redirects issued either
	   * by the server or as a meta-redirect from within the returned HTML. Should a meta-redirect
	   * "rest" for any duration of time, it is best to wait until this timeout is over, since should
	   * the underlying page change whilst your test is executing the results of future calls against
	   * this interface will be against the freshly loaded page. Synonym for
	   * {@link org.openqa.selenium.WebDriver.Navigation#to(String)}.
	   * 
	   * @param url The URL to load. It is best to use a fully qualified URL
	   */
	  public void get(String url) {
		   
		  if (objDriver instanceof HtmlUnitDriver) {
			  ((HtmlUnitDriver)objDriver).get(url);
		  } else {
			  ((WebDriver)objDriver).get(url); 
		  }
	  }

	  /**
	   * Get a string representing the current URL that the browser is looking at.
	   * 
	   * @return The URL of the page currently loaded in the browser
	   */
	  public String getCurrentUrl() {
		  if (objDriver instanceof HtmlUnitDriver) {
			  return ((HtmlUnitDriver)objDriver).getCurrentUrl();
		  } else {
			  return ((WebDriver)objDriver).getCurrentUrl(); 
		  }
	  }

	  // General properties

	  /**
	   * The title of the current page.
	   * 
	   * @return The title of the current page, with leading and trailing whitespace stripped, or null
	   *         if one is not already set
	   */
	  public String getTitle() {
		  if (objDriver instanceof HtmlUnitDriver) {
			  return ((HtmlUnitDriver)objDriver).getTitle();
		  } else {
			  return ((WebDriver)objDriver).getTitle(); 
		  }		  
	  }

	  /**
	   * Find all elements within the current page using the given mechanism.
	   * This method is affected by the 'implicit wait' times in force at the time of execution. When
	   * implicitly waiting, this method will return as soon as there are more than 0 items in the
	   * found collection, or will return an empty list if the timeout is reached.
	   * 
	   * @param by The locating mechanism to use
	   * @return A list of all {@link WebElement}s, or an empty list if nothing matches
	   * @see org.openqa.selenium.By
	   * @see org.openqa.selenium.WebDriver.Timeouts
	   */
	  public List<WebElement> findElements(By by) {
		  if (objDriver instanceof HtmlUnitDriver) {
			  return ((HtmlUnitDriver)objDriver).findElements(by);
		  } else {
			  return ((WebDriver)objDriver).findElements(by); 
		  }		  		  
	  }


	  /**
	   * Find the first {@link WebElement} using the given method.
	   * This method is affected by the 'implicit wait' times in force at the time of execution.
	   * The findElement(..) invocation will return a matching row, or try again repeatedly until 
	   * the configured timeout is reached.
	   *
	   * findElement should not be used to look for non-present elements, use {@link #findElements(By)}
	   * and assert zero length response instead.
	   *
	   * @param by The locating mechanism
	   * @return The first matching element on the current page
	   * @throws NoSuchElementException If no matching elements are found
	   * @see org.openqa.selenium.By
	   * @see org.openqa.selenium.WebDriver.Timeouts
	   */
	public WebElement findElement(By by) {
		  if (objDriver instanceof HtmlUnitDriver) {
			  return ((HtmlUnitDriver)objDriver).findElement(by);
		  } else {
			  return ((WebDriver)objDriver).findElement(by); 
		  }		  
	}

	public String getPageSource() {
		  if (objDriver instanceof HtmlUnitDriver) {
			  return ((HtmlUnitDriver)objDriver).getPageSource();
		  } else {
			  return ((WebDriver)objDriver).getPageSource(); 
		  }		  
	}

	  /**
	   * Close the current window, quitting the browser if it's the last window currently open.
	   */
	  public void close() {
		  if (objDriver instanceof HtmlUnitDriver) {
			  ((HtmlUnitDriver)objDriver).close();
		  } else {
			  ((WebDriver)objDriver).close(); 
		  }		 
	  }

	  /**
	   * Quits this driver, closing every associated window.
	   */
	  public void quit()  {
		  if (objDriver instanceof HtmlUnitDriver) {
			  ((HtmlUnitDriver)objDriver).quit();
		  } else {
			  ((WebDriver)objDriver).quit(); 
		  }			  
	  }

	  /**
	   * Return a set of window handles which can be used to iterate over all open windows of this
	   * webdriver instance by passing them to {@link #switchTo().window(String)}
	   * 
	   * @return A set of window handles which can be used to iterate over all open windows.
	   */
	  public Set<String> getWindowHandles() {
		  if (objDriver instanceof HtmlUnitDriver) {
			  return ((HtmlUnitDriver)objDriver).getWindowHandles();
		  } else {
			  return ((WebDriver)objDriver).getWindowHandles(); 
		  }		
	  }	  
	  /**
	   * Return an opaque handle to this window that uniquely identifies it within this driver instance.
	   * This can be used to switch to this window at a later date
	   */
	  public String getWindowHandle() {
		  if (objDriver instanceof HtmlUnitDriver) {
			  return ((HtmlUnitDriver)objDriver).getWindowHandle();
		  } else {
			  return ((WebDriver)objDriver).getWindowHandle(); 
		  }		  
	  }

	  /**
	   * Send future commands to a different frame or window.
	   * 
	   * @return A TargetLocator which can be used to select a frame or window
	   * @see org.openqa.selenium.WebDriver.TargetLocator
	   */
	  public TargetLocator switchTo() {
		  if (objDriver instanceof HtmlUnitDriver) {
			  return ((HtmlUnitDriver)objDriver).switchTo();
		  } else {
			  return ((WebDriver)objDriver).switchTo(); 
		  }		  	  		  
	  }

	  /**
	   * An abstraction allowing the driver to access the browser's history and to navigate to a given
	   * URL.
	   * 
	   * @return A {@link org.openqa.selenium.WebDriver.Navigation} that allows the selection of what to
	   *         do next
	   */
	  public Navigation navigate() {
		  if (objDriver instanceof HtmlUnitDriver) {
			  return ((HtmlUnitDriver)objDriver).navigate();
		  } else {
			  return ((WebDriver)objDriver).navigate(); 
		  }		
	  }
 
	  public Options manage() {
		  if (objDriver instanceof HtmlUnitDriver) {
			  return ((HtmlUnitDriver)objDriver).manage();
		  } else {
			  return ((WebDriver)objDriver).manage(); 
		  }		  
	  }

}
