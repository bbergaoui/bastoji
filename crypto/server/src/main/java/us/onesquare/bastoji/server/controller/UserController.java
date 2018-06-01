package us.onesquare.bastoji.server.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;

import us.onesquare.bastoji.model.admin.User;
import us.onesquare.bastoji.service.IUserDao;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	IUserDao userDao;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		System.out.println("Get all Users...");

		List<User> users = new ArrayList<>();
		userDao.getAllUsers();
		return users;
	}

	@PostMapping("/users/create")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		System.out.println("Create User: " + user.getEmail() + "...");

		user.setId(UUIDs.timeBased());
		User _user = userDao.createUser(user);
		return new ResponseEntity<>(_user, HttpStatus.OK);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") UUID id, @RequestBody User user) {
		System.out.println("Update User with ID = " + id + "...");

		User userData = userDao.getUser(id);
		if (userData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userData.setEmail((user.getEmail()));
		userData.setPassword(user.getPassword());
		
		userDao.updateUser(userData);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") UUID id) {
		System.out.println("Delete User with ID = " + id + "...");

		userDao.deleteUser(userDao.getUser(id).getId());

		return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/users/delete")
	public ResponseEntity<String> deleteAllUsers() {
		System.out.println("Delete All Users...");

		userDao.deleteAll();

		return new ResponseEntity<>("All users have been deleted!", HttpStatus.OK);
	}

}
