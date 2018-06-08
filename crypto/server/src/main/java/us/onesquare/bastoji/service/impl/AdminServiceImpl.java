package us.onesquare.bastoji.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import us.onesquare.bastoji.dao.ICompanyDao;
import us.onesquare.bastoji.dao.IRegistrationDao;
import us.onesquare.bastoji.dao.IUserDao;
import us.onesquare.bastoji.model.admin.User;
import us.onesquare.bastoji.model.subscription.Registration;
import us.onesquare.bastoji.model.utils.UserCategory;
import us.onesquare.bastoji.service.IAdminService;

@Component
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IRegistrationDao registrationDao;

	@Autowired
	private IUserDao userDao;

	

	@Override
	public void register(Registration registration) {
		registrationDao.createRegistration(registration);

	}

	@Override
	public User login(String login, String password) {
		userDao.findByUserNameAndPassword(login, password);
		return null;
	}

	@Override
	public void updateRegistration(Registration registration) {
		registrationDao.updateRegistration(registration);

	}

	@Override
	public void getUserProfile(User user) {

		UUID id = user.getId();
		Integer userCategory = user.getUserCategory();
		if (userCategory.equals(UserCategory.COMPANY)) {
			// companyDao
		}

	}

}
