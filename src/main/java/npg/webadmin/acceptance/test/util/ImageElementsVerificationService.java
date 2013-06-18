package npg.webadmin.acceptance.test.util;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import npg.webadmin.acceptance.test.Constants;

 
public class ImageElementsVerificationService extends WebElementsVerificationBaseAbstract {

	public ImageElementsVerificationService() {
		 
	}

    public void verifyElementImage(WebDriver webDriver, FieldItem item) {
    	if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_LINK_PARENT)) {    	    		
    		verifyElementImage(webDriver, item, Constants.WITH_ATTRIBUTE_LINK_PARENT);
    	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_ALT)) {    	    		
        		verifyElementImage(webDriver, item, Constants.WITH_ATTRIBUTE_ALT); 	
    	} else {
    		verifyElementImage(webDriver, item, null);
    	}
    }
    
    private void verifyElementImage(WebDriver webDriver, FieldItem item, String separator) {
    	try {
    		if (separator==null) {      			 
    			webDriver.findElement(By.xpath("//img[@src='" + item.value + "']"));    		         
    		} else {
    			String[] parts = item.value.trim().split(separator);
    			
    			if (parts.length == 1 ) {
    			  if (separator.equals(Constants.WITH_ATTRIBUTE_LINK_PARENT)) {
    				  webDriver.findElement(By.xpath("//img[@src='" + parts[0] + 
  	    				"'][ancestor::a]"));  				      
    			  } else {
    				  assertTrue("Image '"+ item.value + "' is invalid format.", false );  
    			  }
    		    } else {
    		    	 if (separator.equals(Constants.WITH_ATTRIBUTE_ALT)) {
    		    		 webDriver.findElement(By.xpath("//img[@src='" + parts[0] + 
      	    				"'][@alt='" + parts[1] + "']"));  	
    		    	 } else {    
    		    		 webDriver.findElement(By.xpath("//img[@"+ super.getAttributes(separator) + "='" + parts[1] + "']"));	
    		    	 }		 
    		    }
    		}    	   			
    			 
    		if (item.present.trim().toLowerCase().equals(Constants.NO)) {
		    	assertTrue("Image '"+ item.value + "' should not be present in the page.", false );
		    }
    		
    	} catch (NoSuchElementException e) {
    		if(item.present.trim().toLowerCase().equals(Constants.YES)) {
				assertTrue("Image '"+ item.value + "' should be present in the page.", false );
			}
    	}
    }
    

}
