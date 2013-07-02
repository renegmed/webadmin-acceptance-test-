package npg.webadmin.acceptance.test.util;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import npg.webadmin.acceptance.test.Constants;

public class TextElementsVerificationService extends WebElementsVerificationBaseAbstract {

	public TextElementsVerificationService() {
		
	}

	public void verifyElementText(WebDriver webDriver, FieldItem item) {
	    	if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_LINK_PARENT)) {    	    		
	    		verifyElementText(webDriver, item, Constants.WITH_ATTRIBUTE_LINK_PARENT);
	    	} else if (item.value.trim().contains(Constants.PRECEDING_SIBLING_TEXT)) {  
	    		verifyElementText(webDriver, item, Constants.PRECEDING_SIBLING_TEXT);    	  
	    	} else if (item.value.trim().contains(Constants.FOLLOWING_SIBLING_TEXT)) {          
	          	verifyElementText(webDriver, item, Constants.FOLLOWING_SIBLING_TEXT);      	
	    	} else {
	    		verifyElementText(webDriver, item, null);
	    	}
	}	
	 
    private void verifyElementText(WebDriver webDriver, FieldItem item, String separator) {
    	try {
    		if (separator==null) {    		  	
    		    try{
    		    	webDriver.findElement(By.xpath("//span[contains(text(), '" + item.value + "')]"));
    		    } catch (NoSuchElementException e) {  // it could be label
    		    	try {
    		    		webDriver.findElement(By.xpath("//label[contains(text(), '" + item.value + "')]"));
    		    	} catch (NoSuchElementException e2) { // if not label, it could be td
    		    		try {
    		    			webDriver.findElement(By.xpath("//td[contains(text(), '" + item.value + "')]"));    		    		     
    		    		} catch (NoSuchElementException e3) { // if not td, it could be p	 
    		    			 try {
    		    				 webDriver.findElement(By.xpath("//p[contains(text(), '" + item.value + "')]"));
    		    			 } catch (NoSuchElementException e4) { // if not p, it could be strong
    		    				 try {
    		    					 webDriver.findElement(By.xpath("//strong[contains(text(), '" + item.value + "')]")); 
    		    				 } catch (NoSuchElementException e5) { // if not strong, it must be em
    		    					 try {
    		    						 webDriver.findElement(By.xpath("//em[contains(text(), '" + item.value + "')]"));
    		    					 } catch (NoSuchElementException e6) { // if not em, it must be b
    		    						 webDriver.findElement(By.xpath("//b[contains(text(), '" + item.value + "')]"));
    		    					 }
    		    				 }
    		    			 }
    		    		}
    		    	}
    		    }    		    
    		    return;
    		}
    		
    		String[] parts = item.value.trim().split(separator);     			
    		
    		if (parts.length > 1 && parts[1] != null && !parts[1].trim().equals("")) {
    			
    			//System.out.println("XPATH: SEPARATOR: " + separator + "\n" + "//span[contains(text(), '" + parts[0] + 
   				//	 "')][parent::a[@href='" + parts[1] + "']]"  );    			
    			
    			//System.out.println(" verifyElement_text parts[0]: " + parts[0] + "  parts[1]: " + parts[1]);
    			
    			if (separator.equals(Constants.WITH_ATTRIBUTE_LINK_PARENT)) {
    				webDriver.findElement(By.xpath("//*[contains(text(), '" + parts[0] + 
    	    				"')][ancestor::a]"));
    			} else if (item.value.trim().contains(Constants.PRECEDING_SIBLING_TEXT) ||
    					item.value.trim().contains(Constants.FOLLOWING_SIBLING_TEXT)) {  		    			
    				webDriver.findElement(By.xpath("//td[contains(text(), '" + parts[0] + 
  		    	  				 "')][" + getAttributes(separator) + "::td[contains(text(),'" + parts[1] + "')]]"));  		    	  
    			} else {
    				webDriver.findElement(By.xpath("//span[contains(text(), '" + parts[0] + 
    	    		  		"')][ancestor::a[@href='" + parts[1] + "']]")); 
    				  
    			}  
    		} else {     		
    			//System.out.println("XPATH: SEPARATOR: " + separator + "\n" + "//span[contains(text(), '" + parts[0] + 
   				//	 "')][parent::a]"  );    			    			
    	    	if (separator.equals(Constants.WITH_ATTRIBUTE_LINK_PARENT)) {
    	    		webDriver.findElement(By.xpath("//*[contains(text(), '" + parts[0] + "')][parent::a]"));
    	    	} else {
    	    		webDriver.findElement(By.xpath("//span[contains(text(), '" + parts[0] + "')][parent::a]"));
    	    	}    
    		}   
    		
    		if (item.present.trim().toLowerCase().equals(Constants.NO)) {
    			assertTrue("Text '"+ item.value + "' should not be present in the page.", false );
    		}    	 
    	} catch (NoSuchElementException e) {
    	   if (item.present.trim().toLowerCase().equals(Constants.YES)) {		    	
		       assertTrue("Text '"+ item.value + "' should be present in the page. " , false);
    	   } 
    	}
    }
        
   
    
    public void verifyElementDt(WebDriver webDriver, FieldItem item) {
    	try {    		
    		webDriver.findElement(By.xpath("//dt[contains(text(), '" + item.value + "')]"));
  		  if (item.present.trim().toLowerCase().equals(Constants.NO)) {
		   	  //System.out.println("  Definition term '"+ item.value + "' should not be present in the page. " );		    	  
		   	  assertTrue("  Definition term '"+ item.value + "' should not be present in the page. " , false);		    	  
  		  }  
  		} catch (NoSuchElementException e) {
  		  if (item.present.trim().toLowerCase().equals(Constants.YES)) {
  			  //System.out.println("  Definition term '"+ item.value + "' should be present in the page. " );
  			  assertTrue("  Definition term '"+ item.value + "' should be present in the page. " , false);
  		  } 
  		}
    }    

    public void verifyElementHeader2(WebDriver webDriver, FieldItem item) {
    	try {    	
    		webDriver.findElement(By.xpath("//h2[contains(text(), '" + item.value + "')]"));
    		if (item.present.trim().toLowerCase().equals(Constants.NO)) {  	    	  
  	    	  assertTrue("  Header 2 text '"+ item.value + "' should not be present in the page." , false);
    		}  
    	} catch (NoSuchElementException e) {    		    	
       	    if (item.present.trim().toLowerCase().equals(Constants.YES)) {
       	    	assertTrue("  Header 2 text '"+ item.value + "' should be present in the page." , false);
       	    }	     
	    }    	
    }
  
    public void verifyElementDd(WebDriver webDriver, FieldItem item) {    	
    	if (item.value.trim().contains(Constants.PRECEDING_SIBLING_TEXT)) {  
    		verifyElementDd(webDriver, item, Constants.PRECEDING_SIBLING_TEXT);    	  
    	} else if (item.value.trim().contains(Constants.FOLLOWING_SIBLING_TEXT)) {          
          	verifyElementDd(webDriver, item, Constants.FOLLOWING_SIBLING_TEXT);          	
    	} else {
    		verifyElementDd(webDriver, item, null); 
    	}   
    }    
    
    private void verifyElementDd(WebDriver webDriver, FieldItem item, String separator) {
    	try {
    		if (separator == null) {
    			webDriver.findElement(By.xpath("//dd[contains(text(), '" + item.value +  "')]"));
    		} else {
    			String[] parts = item.value.trim().split(separator);
    			webDriver.findElement(By.xpath("//dd[contains(text(), '" + parts[0] + 
    	  				 "')][" + getAttributes(separator) + "::dt[contains(text(),'" + parts[1] + "')]]"));
    		}
    		if (item.present.trim().toLowerCase().equals(Constants.NO)) {
		    	assertTrue("Definition description '"+ item.value + "' should not be present in the page.", false );
		    }
    	} catch (NoSuchElementException e) {
    		if(item.present.trim().toLowerCase().equals(Constants.YES)) {
				assertTrue("Definition description '"+ item.value + "' should be present in the page.", false );
			}
    	}
    }
    
   
}