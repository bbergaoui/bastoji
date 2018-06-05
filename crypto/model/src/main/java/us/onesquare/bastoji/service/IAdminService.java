package us.onesquare.bastoji.service;

import us.onesquare.bastoji.model.admin.User;
import us.onesquare.bastoji.model.subscription.Registration;

public interface IAdminService {

	
	
	void register(Registration registration);
	
	User login(String login , String password);

	void updateRegistration(Registration registration);

	void getUserProfile(User user);
}
