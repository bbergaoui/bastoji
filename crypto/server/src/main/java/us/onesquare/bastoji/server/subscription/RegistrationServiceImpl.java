package us.onesquare.bastoji.server.subscription;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.onesquare.bastoji.model.subscription.Registration;

@Service("regsitrationService")
public class RegistrationServiceImpl implements RegistrationService{
	
	
//	@Autowired  
//    private RegistrationDAO registrationDAO;
	/**
     * Default Constructor
     */
    public RegistrationServiceImpl() {
        super();    
    }

    @Override   
    public Registration createRegistration(Registration registration) {     
//        return registrationDAO.createRegistration(registration);
    	return null;
    }

    @Override   
    public Registration getRegistration(int id) {       
//        return registrationDAO.getRegistration(id);
        return null;
    }

    @Override   
    public Registration updateRegistration(Registration registration) {     
//        return registrationDAO.updateRegistration(registration);
        return null;
    }

    @Override   
    public void deleteRegistration(int id) {        
//        registrationDAO.deleteRegistration(id);
    }

    @Override   
    public List<Registration> getAllRegistrations() {       
//        return registrationDAO.getAllRegistrations();
        return null;
    }

	@Override
	public Registration findByEmail(String email) {
	
		return null;
	}

	@Override
	public Registration findByConfirmationToken(String confirmationToken) {

		return null;
	}
}
