package us.onesquare.bastoji.server.subscription;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD:crypto/server/src/main/java/us/onesquare/bastoji/server/UserController.java
import us.onesquare.bastoji.model.admin.User;


=======
import us.onesquare.bastoji.model.subscription.Registration;
import us.onesquare.bastoji.server.EmailService;
>>>>>>> 0dc80009fb0f32d674914a54bd7976fb40a06c1a:crypto/server/src/main/java/us/onesquare/bastoji/server/subscription/RegistrationController.java

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RegistrationController {
	@Autowired
	RegistrationRepository registrationRepository;
	@Autowired
	EmailService emailService;
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

//	@Autowired
//	public UserController(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService,
//			EmailService emailService) {
//
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//		this.userRepository = userRepository;
//		this.emailService = emailService;
//	}

	@PostMapping("/register")
	public void getform(String firstName, String lastName, String password, String email, String confirmationToken,
			@Valid @RequestBody Registration registration, String request) {
		Registration registrationExists = registrationRepository.findByEmail(registration.getEmail());
		if (registrationExists != null) {
			System.out.println("utilisateur déjà existe");
		} else {
			registration.setConfirmationToken(UUID.randomUUID().toString());
			registrationRepository.save(registration);
			String appUrl = request + "://";
			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(registration.getEmail());
			registrationEmail.setSubject("registration ");
			registrationEmail.setText("To confirm your e-mail address, please click the link below:\n" + appUrl
					+ "/confirm?token=" + registration.getConfirmationToken());
			registrationEmail.setFrom("contact@onesquare.us");
			emailService.sendEmail(registrationEmail);
		}
	}

	@PostMapping("/getAll")
	public List<Registration> get() {
		List<Registration> registrationExists =registrationRepository.findAll();
		return registrationExists;
	}
}
