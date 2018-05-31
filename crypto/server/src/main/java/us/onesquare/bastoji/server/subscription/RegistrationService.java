package us.onesquare.bastoji.server.subscription;

import java.util.List;

import us.onesquare.bastoji.model.subscription.Registration;
/**
 * Service interface for Registration to perform CRUD operation.

 */
public interface RegistrationService {
	Registration findByEmail(String email);
	Registration findByConfirmationToken(String confirmationToken); 
  
	// User findByUsername(String username);
	 
	/**
     * Used to Create the Registration Information
     * @param registration
     * @return {@link Registration}
     */
	public Registration createRegistration(Registration registration);
	    
	    /**
	     * Getting the Registration Information using Id
	     * @param id
	     * @return {@link Registration}
	     */
	    public Registration getRegistration(int id);
	    
	    /**
	     * Used to Update the Registration Information
	     * @param registration
	     * @return {@link Registration}
	     */
	    
	    public Registration updateRegistration(Registration registration);
	    
	    /**
	     * Deleting the Registration Information using Id
	     * @param id
	     */
	    public void deleteRegistration(int id);
	    
	    /**
	     * Getting the All Registrations information
	     * @return
	     */
	    public List<Registration> getAllRegistrations();

}
