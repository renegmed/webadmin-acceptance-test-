package npg.webadmin.acceptance.test.guice;

 
import java.util.ResourceBundle; 
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;
import npg.webadmin.acceptance.test.util.LoginService; 
import npg.webadmin.acceptance.test.service.NavigationService;

public class WebAdminGuiceModule implements Module {
  
	
	public void configure(Binder binder) { 
		binder.bind(LoginService.class).toInstance(new LoginService(getResource()));
		binder.bind(NavigationService.class).toInstance(new NavigationService(getResource()));		
		//System.out.println("+++++ WebAdminGuiceModule.configure +++++++");
	}

	protected ResourceBundle getResource() {
		 ResourceBundle resource = ResourceBundle.getBundle("webadmin-selenium");
		 return resource;
	}
 	    
}
