package npg.webadmin.acceptance.test.util;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import npg.webadmin.acceptance.test.Constants;
import npg.webadmin.acceptance.test.WebDriverWrapper; 

public class LinkElementsVerificationService extends WebElementsVerificationBaseAbstract {

	public LinkElementsVerificationService() {
		 
	}
	public void verifyElementLinkText(WebDriverWrapper webDriver, String text) {
		try{	
			webDriver.findElement(By.xpath("//a[contains(text(), '" + text + "')]"));
		} catch (NoSuchElementException e) { 
		    assertTrue("  Link text '"+ text + "' should be present in the page. " , false);	    
	   	}	
	}
	
	public void verifyElementLinkText(WebDriverWrapper webDriver, FieldItem item) {
	   	if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_ID)) {    	    		
	   		verifyElementLinkText(webDriver, item, Constants.WITH_ATTRIBUTE_ID);		
	   	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_CLASS)) {        		 
	   		verifyElementLinkText(webDriver, item, Constants.WITH_ATTRIBUTE_CLASS);
	   	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_TITLE)) {        		 
	   		verifyElementLinkText(webDriver, item, Constants.WITH_ATTRIBUTE_TITLE);
	   	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_LINK)) {        		 
	   		verifyElementLinkText(webDriver, item, Constants.WITH_ATTRIBUTE_LINK);
	   	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_ALT)) {        		 
	   		verifyElementLinkText(webDriver, item, Constants.WITH_ATTRIBUTE_ALT);	    	
	   	} else {
	   		verifyElementLinkText(webDriver, item, null);
	   	}
	}	
	 
    private void verifyElementLinkText(WebDriverWrapper webDriver, FieldItem item, String separator) {
    	try {
    		if (separator==null) {    		  	
    			webDriver.findElement(By.xpath("//a[contains(text(), '" + item.value + "')]"));
    		} else {
    			String[] parts = item.value.trim().split(separator);     			
    			if (parts.length > 1 && parts[1] != null && !parts[1].trim().equals("")) {
    				//System.out.println("XPATH: SEPARATOR: " + separator + "\n" + "//a[contains(text(), '" + parts[0] + 
    	   			//		 "')][@"+ super.getAttributes(separator) + "='" + parts[1] + "']"  );    			    			
    	    	    	
    				webDriver.findElement(By.xpath("//a[contains(text(), '" + parts[0] + 
    	    					 "')][@"+ super.getAttributes(separator) + "='" + parts[1] + "']")); 
    			} else {
    				//System.out.println("XPATH: SEPARATOR: " + separator + "\n" + 
    				//		"//a[contains(@"+ super.getAttributes(separator) + "='" + parts[0] + "']"  );    			    			
   	    	    	
    				webDriver.findElement(By.xpath("//a[@"+ super.getAttributes(separator) + "='" + parts[0] + "']"));
    			}    			 
    		}    
    		
    		if (item.present.trim().toLowerCase().equals(Constants.NO)) {
    			assertTrue("Link text '"+ item.value + "' should not be present in the page.", false );
    		}    	 
    	} catch (NoSuchElementException e) {
    	   if (item.present.trim().toLowerCase().equals(Constants.YES)) {		    	
		       assertTrue("  Link text '"+ item.value + "' should be present in the page. " , false);
    	   } 
    	}
    }
        
   
}
