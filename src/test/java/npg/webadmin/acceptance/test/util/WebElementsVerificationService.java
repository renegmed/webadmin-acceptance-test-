package npg.webadmin.acceptance.test.util;

import java.util.List;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import npg.webadmin.acceptance.test.Constants;
import npg.webadmin.acceptance.test.util.WebElementsVerificationBaseAbstract.FieldItem;

public class WebElementsVerificationService {

	InputElementsVerificationService inputElementsVerificationService;
	TextElementsVerificationService textElementsVerificationService;
	LinkElementsVerificationService linkElementsVerificationService;
	ImageElementsVerificationService imageElementsVerificationService;
	
	@Inject
	public WebElementsVerificationService(
			  InputElementsVerificationService inputElementsVerificationService,
			  TextElementsVerificationService textElementsVerificationService,
			  LinkElementsVerificationService linkElementsVerificationService,
			  ImageElementsVerificationService imageElementsVerificationService) {
		
		 this.inputElementsVerificationService = inputElementsVerificationService;
		 this.textElementsVerificationService = textElementsVerificationService;
		 this.linkElementsVerificationService = linkElementsVerificationService;
		 this.imageElementsVerificationService = imageElementsVerificationService;
	}

	
	public void processFieldItems(WebDriver webDriver, List<FieldItem> items) {
	        for (FieldItem item : items) {      	  
	        	//Constants.LOGGER.info("  TYPE: " + item.type + "  VALUE: " + item.value + "  PRESENT: " + item.present); 
	        	System.out.println("  TYPE: " + item.type + "  VALUE: " + item.value + "  PRESENT: " + item.present); 
	        	
	        	if (item.type.toLowerCase().trim().equals(Constants.DEFINITION_TERM)) { 
	        		textElementsVerificationService.verifyElementDt(webDriver, item);
	        	} else if (item.type.toLowerCase().trim().equals(Constants.TEXT)) {
	        		textElementsVerificationService.verifyElementText(webDriver, item);	
	            } else if (item.type.toLowerCase().trim().equals(Constants.LINK_TEXT)) {
	            	linkElementsVerificationService.verifyElementLinkText(webDriver, item);
	            } else if (item.type.toLowerCase().trim().equals(Constants.IMAGE)) {
	            	imageElementsVerificationService.verifyElementImage(webDriver, item);	
	            } else if (item.type.toLowerCase().trim().equals(Constants.HEADER_2)) { 
	            	textElementsVerificationService.verifyElementHeader2(webDriver, item); 
	            } else if (item.type.toLowerCase().trim().equals(Constants.DEFINITION_DESCRIPTION)) {
	            	textElementsVerificationService.verifyElementDd(webDriver, item);            
	            } else if (item.type.toLowerCase().trim().equals(Constants.SELECT_OPTION_TEXT)) {
	            	inputElementsVerificationService.verifyElementSelectOption(webDriver, item);
	            } else if (item.type.toLowerCase().trim().equals(Constants.INPUT_FIELD)) {
	            	inputElementsVerificationService.verifyElementInputField(webDriver, item);
	            } else if (item.type.toLowerCase().trim().equals(Constants.INPUT_CHECKBOX)) {
	            	inputElementsVerificationService.verifyElementInputCheckbox(webDriver, item);
	            }
	        }	
	    }    
}
