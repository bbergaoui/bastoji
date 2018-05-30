package us.onesquare.bastoji.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.onesquare.bastoji.model.subscription.Registration;

@Service("regsitrationService")
public class RegistrationService {
	private List<Registration> registrations = new ArrayList<Registration>();
	private RegistrationRepository registrationRepository;
	
    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) { 
      this.registrationRepository = registrationRepository;
    }
    
	public Registration findByEmail(String email) {
		return registrationRepository.findByEmail(email);
	}
	
	public Registration findByConfirmationToken(String confirmationToken) {
		return registrationRepository.findByConfirmationToken(confirmationToken);
	}
	
	public void saveRegistration(Registration registration) {
		registrationRepository.save(registration);	}
	
	}
