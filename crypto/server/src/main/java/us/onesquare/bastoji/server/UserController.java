package us.onesquare.bastoji.server;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import us.onesquare.bastoji.model.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	EmailService emailService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

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
			@Valid @RequestBody User user, String request) {
		User userExists = userRepository.findByEmail(user.getEmail());
		if (userExists != null) {
			System.out.println("utilisateur déjà existe");
		} else {
			user.setConfirmationToken(UUID.randomUUID().toString());
			userRepository.save(user);
			String appUrl = request + "://";
			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(user.getEmail());
			registrationEmail.setSubject("registration ");
			registrationEmail.setText("To confirm your e-mail address, please click the link below:\n" + appUrl
					+ "/confirm?token=" + user.getConfirmationToken());
			registrationEmail.setFrom("contact@onesquare.us");
			emailService.sendEmail(registrationEmail);
		}
	}

	@PostMapping("/getAll")
	public List<User> get() {
		List<User> userExists = userRepository.findAll();
		return userExists;
	}
}
