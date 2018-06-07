package us.onesquare.bastoji.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import us.onesquare.bastoji.UserDao;
import us.onesquare.bastoji.dao.ICompanyDao;
import us.onesquare.bastoji.dao.IRegistrationDao;
import us.onesquare.bastoji.dao.IUserDao;
import us.onesquare.bastoji.model.admin.User;
import us.onesquare.bastoji.model.subscription.Registration;
import us.onesquare.bastoji.model.utils.UserCategory;
import us.onesquare.bastoji.server.EmailService;
import us.onesquare.bastoji.service.IAdminService;

import javax.servlet.http.HttpServletRequest;

@Component
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IRegistrationDao registrationDao;

	@Autowired
	private IUserDao userDao;

	@Autowired
	private ICompanyDao companyDao;

	@Autowired
	private EmailService sendEmail;


	@Override
	public void register(Registration registration) {
		boolean userExists = registrationDao.userExists(registration.getEmail());
		if (userExists) {
			throw new RuntimeException("User exists");
		}
		registration.setMailConfirmationToken(UUID.randomUUID().toString());


		registration.setId(UUID.randomUUID());


		SimpleMailMessage registrationEmail = new SimpleMailMessage();
		registrationEmail.setTo(registration.getEmail());
		registrationEmail.setSubject("Registration Confirmation");
		registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
				+ getAppUrl() + "/confirm?token=" + registration.getMailConfirmationToken());
		registrationEmail.setFrom("barsam.badguen@mail.com");

		sendEmail.sendEmail(registrationEmail);

		registrationDao.createRegistration(registration);

	}

	private String getAppUrl() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if(null != requestAttributes && requestAttributes instanceof ServletRequestAttributes) {
			HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
			return String.format("%s://%s:%d/api",request.getScheme(),  request.getServerName(), request.getServerPort());

		}
		else {
			return "http://localhost:8053/";
		}
	}

	private void getAppUrl(ServletRequestAttributes requestAttributes) {
		HttpServletRequest request = requestAttributes.getRequest();
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

	@Override
	public void confirm(String token) {
		Registration registration = registrationDao.findByToken(token);

		User user = fromRegistration(registration);
		userDao.createUser(user);

		registration.setMailConfirmationToken(UUID.randomUUID().toString());

		registrationDao.updateRegistration(registration);



	}

	private User fromRegistration(Registration registration) {
		User user = new User();
		user.setEmail(registration.getEmail());
		user.setPassword(registration.getPassword());
		user.setId(UUID.randomUUID());
		return user;
	}
}
