package us.onesquare.bastoji.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import us.onesquare.bastoji.model.subscription.Registration;
import us.onesquare.bastoji.service.IAdminService;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class AdminController {

	@Autowired
	private IAdminService adminService;

	

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	ResponseEntity<Registration> create(@RequestBody Registration registration) {
		 adminService.register(registration);
		 return new ResponseEntity<Registration>(registration , HttpStatus.OK);
	}

//	@RequestMapping(value = "/registration/{id}", method = RequestMethod.DELETE)
//	void delete(@PathVariable("id") int id) {
//		adminService.deleteRegistration(id);
//	}

//	@RequestMapping(value = "/registration", method = RequestMethod.GET)
//	List<Registration> findAll() {
//		return registrationDao.getAllRegistrations();
//	}

//	@RequestMapping(value = "/registration/{id}", method = RequestMethod.GET)
//	Registration findById(@PathVariable("id") int id) {
//		return registrationDao.getRegistration(id);
//	}

	@RequestMapping(value = "/registration", method = RequestMethod.PUT)
	Registration update(@RequestBody Registration registration) {

		adminService.updateRegistration(registration);
		return registration;
	}
	

}
