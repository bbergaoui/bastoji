package us.onesquare.bastoji.server.subscription;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import us.onesquare.bastoji.model.subscription.Registration;

@RestController
public class RegistrationController {
	
	
	 @Autowired
	    private RegistrationService registrationService;
	    
	    public RegistrationController() {
	        System.out.println("RegistrationController()");
	    }
	         
	    @RequestMapping(value = "/registration", method = RequestMethod.POST)    
	    Registration create(@RequestBody Registration registration) {        
	        return registrationService.createRegistration(registration);
	    }
	 
	    @RequestMapping(value = "/registration/{id}", method = RequestMethod.DELETE)
	    void delete(@PathVariable("id") int id) {
	        registrationService.deleteRegistration(id);
	    }
	 
	    @RequestMapping(value="/registration", method = RequestMethod.GET)
	    List<Registration> findAll() {
	        return registrationService.getAllRegistrations();
	    }
	 
	    @RequestMapping(value = "/registration/{id}", method = RequestMethod.GET)
	    Registration findById(@PathVariable("id") int id) {        
	        return registrationService.getRegistration(id);
	    }
	 
	    @RequestMapping(value = "/registration", method = RequestMethod.PUT)
	    Registration update(@RequestBody Registration registration) {
	        return registrationService.updateRegistration(registration);
	    }
	
	
}
