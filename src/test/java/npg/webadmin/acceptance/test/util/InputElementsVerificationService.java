package npg.webadmin.acceptance.test.util;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import npg.webadmin.acceptance.test.Constants;

public class InputElementsVerificationService extends WebElementsVerificationBaseAbstract { 

	public void verifyElementInputField(WebDriver webDriver, FieldItem item) {
	    	if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_NAME)) {    	    		
	    		verifyElementInputField(webDriver, item, Constants.WITH_ATTRIBUTE_NAME);
	    	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_CLASS)) {    	    		
	    		verifyElementInputField(webDriver, item, Constants.WITH_ATTRIBUTE_CLASS);
	    	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_ID)) {    	    		
	    		verifyElementInputField(webDriver, item, Constants.WITH_ATTRIBUTE_ID);
	    	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_VALUE)) {    	    		
	    		verifyElementInputField(webDriver, item, Constants.WITH_ATTRIBUTE_VALUE);
	    	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_ALT)) {    	    		
	    		verifyElementInputField(webDriver, item, Constants.WITH_ATTRIBUTE_ALT);
	    	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_SOURCE)) {    	    		
	    		verifyElementInputField(webDriver, item, Constants.WITH_ATTRIBUTE_SOURCE);    	
	    	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_NAME_AND_VALUE)) {    	    		
	    		verifyElementInputField(webDriver, item, Constants.WITH_ATTRIBUTE_NAME_AND_VALUE);	
	    	} else {
	    		verifyElementInputField(webDriver, item, null);
	    	}
	}
	
	protected void verifyElementInputField(WebDriver webDriver, FieldItem item, String separator) {
	   	try {   
	   		if (separator == null) {
	   			assertTrue("Input field '"+ item.value + "' not valid. Nothing to identify with", false );
	   		    return;
	   		}else if (item.value.trim().startsWith(separator)) {
	    			String[] parts = item.value.trim().split(separator);
	    			//System.out.println(" +++++ parts[0] " + parts[0] + "   parts[1] " + parts[1] +"\n" +
	    			//		"//input[@" + getAttributes(separator) + "='" + 
	    			//		(parts[1].equals(Constants.BLANK_VALUE)?"":parts[1]) + "']");  
	    			
	    			webDriver.findElement(By.xpath("//input[@" + getAttributes(separator) + "='" + 
	    					(parts[1].equals(Constants.BLANK_VALUE)?"":parts[1]) + "']"));
	   		} else if (separator.equals(Constants.WITH_ATTRIBUTE_NAME_AND_VALUE)) {
	    			String[] parts = item.value.trim().split(separator); 
	    			webDriver.findElement(By.xpath("//input[@name='" + parts[0] + "' and @value='" + 
	    					(parts[1].equals(Constants.BLANK_VALUE)?"":parts[1]) + "']"));
	    			
	   		} else {
	    		 
	    		   assertTrue("Input field '"+ item.value + "' illegal format.", false );    		    
	    			 
	   		}    		
	    		
	   		if (item.present.trim().toLowerCase().equals(Constants.NO)) {
			    	assertTrue("Input field '"+ item.value + "' should not be present in the page.", false );
		    }
	    		
	   	} catch (NoSuchElementException e) {
	   		if(item.present.trim().toLowerCase().equals(Constants.YES)) {
				assertTrue("Input field '"+ item.value + "' should be present in the page.", false );
			}
	   	}
	}
	
	public void verifyElementInputCheckbox(WebDriver webDriver, FieldItem item) {
	    	if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_NAME)) {    	    		
	    		verifyElementInputCheckbox(webDriver, item, Constants.WITH_ATTRIBUTE_NAME);
	    	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_CLASS)) {    	    		
	    		verifyElementInputCheckbox(webDriver, item, Constants.WITH_ATTRIBUTE_CLASS);
	    	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_ID)) {    	    		
	    		verifyElementInputCheckbox(webDriver, item, Constants.WITH_ATTRIBUTE_ID);
	    	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_VALUE)) {    	    		
	    		verifyElementInputCheckbox(webDriver, item, Constants.WITH_ATTRIBUTE_VALUE);
	    	} else if (item.value.trim().contains(Constants.WITH_ATTRIBUTE_VALUE_CHECKED)) {    	    		
	    		verifyElementInputCheckbox(webDriver, item, Constants.WITH_ATTRIBUTE_VALUE_CHECKED); 	
	    	} else {
	    		verifyElementInputCheckbox(webDriver, item, null);
	    	}
	}  
	   
    protected void verifyElementInputCheckbox(WebDriver webDriver, FieldItem item, String separator) {
    	try {   
    		if (separator == null) {
    			assertTrue("Input checkbox '"+ item.value + "' not valid. Nothing to identify with", false );
    		    return;
    		}else if (item.value.trim().startsWith(separator)) {
    			String[] parts = item.value.trim().split(separator);
    			//System.out.println(" +++++ parts[0] " + parts[0] + "   parts[1] " + parts[1] +"\n" +
    			//		"//input[@type='checkbox'][@" + getAttributes(separator) + "='" + parts[1] + "'" +
    			//		(separator.equals(Constants.WITH_ATTRIBUTE_VALUE_CHECKED)?"][@checked":"") + "]");
    			 
    			webDriver.findElement(By.xpath("//input[@type='checkbox'][@" + getAttributes(separator) + "='" + parts[1] + 
    						"'" + (separator.equals(Constants.WITH_ATTRIBUTE_VALUE_CHECKED)?"][@checked":"") + "]"));
    			 
    		} else {
    			assertTrue("Input field '"+ item.value + "' illegal format.", false );
    		    return;
    		}    		
    		
    		if (item.present.trim().toLowerCase().equals(Constants.NO)) {
		    	assertTrue("Input field '"+ item.value + "' should not be present in the page.", false );
		    }
    		
    	} catch (NoSuchElementException e) {
    		if(item.present.trim().toLowerCase().equals(Constants.YES)) {
				assertTrue("Input field '"+ item.value + "' should be present in the page.", false );
			}
    	}
    }    

    public void verifyElementSelectOption(WebDriver webDriver, FieldItem item) {
    	System.out.println("+++++ verifying element select option");
    	
    	if (item.value.trim().contains(Constants.WITH_SELECT_PARENT_NAME)) {  
    		verifyElementSelectOption(webDriver, item, Constants.WITH_SELECT_PARENT_NAME);    	  
    	} else if (item.value.trim().contains(Constants.WITH_SELECT_PARENT_NAME_SELECTED)) {          
    		verifyElementSelectOption(webDriver, item, Constants.WITH_SELECT_PARENT_NAME_SELECTED);          	
    	} else {
    		verifyElementSelectOption(webDriver, item, null); 
    	}   
    }
    
    protected void verifyElementSelectOption(WebDriver webDriver, FieldItem item, String separator) {
    	System.out.println("+++++ verify Element Select Option   item.value: " + item.value + "   item.fieldname: " + item.fieldname + 
    			"  separator: " + (separator==null?"null":separator));
    	try {
    		if (separator == null) {
    			webDriver.findElement(By.xpath("//option[contains(text(), '" + item.value +  "')]"));
    		} else {
    			String[] parts = item.value.trim().split(separator);
    			if (separator.equals(Constants.WITH_SELECT_PARENT_NAME_SELECTED)) {
    				webDriver.findElement(By.xpath("//option[contains(text(), '" + parts[0] + 
        	  				 "')][ancestor::select[@name='" + parts[1] + "']][@selected]"));
    			} else {
    				webDriver.findElement(By.xpath("//option[contains(text(), '" + parts[0] + 
    	  				 "')][ancestor::select[@name='" + parts[1] + "']]"));
    			}    
    		}
    		if (item.present.trim().toLowerCase().equals(Constants.NO)) {
		    	assertTrue("Select option '"+ item.value + "' should not be present in the page.", false );
		    }
    	} catch (NoSuchElementException e) {
    		if(item.present.trim().toLowerCase().equals(Constants.YES)) {
				assertTrue("Select option '"+ item.value + "' should be present in the page.", false );
			}
    	}
    }
    

    
    
}
