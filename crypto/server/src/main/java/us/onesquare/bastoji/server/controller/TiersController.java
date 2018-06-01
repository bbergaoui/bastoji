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

import us.onesquare.bastoji.model.admin.Tiers;
import us.onesquare.bastoji.service.ITiersDao;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TiersController {

	@Autowired
	ITiersDao tiersDao;

	@GetMapping("/tiers")
	public List<Tiers> getAlltiers() {
		System.out.println("Get all tiers...");

		List<Tiers> tiers = new ArrayList<>();
		
		return tiers;
	}

	@PostMapping("/tiers/create")
	public ResponseEntity<Tiers> createTiers(@Valid @RequestBody Tiers tiers) {
		System.out.println("Create Tiers: " + tiers.getFirstName()+" "+ tiers.getLastName() + "...");

		tiers.setId(UUIDs.timeBased());
		Tiers _tiers = tiersDao.createTiers(tiers);
		return new ResponseEntity<>(_tiers, HttpStatus.OK);
	}

	@PutMapping("/tiers/{id}")
	public ResponseEntity<Tiers> updateTiers(@PathVariable("id") UUID id, @RequestBody Tiers tiers) {
		System.out.println("Update Tiers with ID = " + id + "...");

		Tiers tiersData = tiersDao.getTiers(id);
		if (tiersData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		tiersData.setAddress(tiers.getAddress());
		tiersData.setBirthdate(tiers.getBirthdate());
		tiersData.setFacebook(tiers.getFacebook());
		tiersData.setFirstName(tiers.getFirstName());
		tiersData.setFunction(tiers.getFunction());
		tiersData.setGender(tiers.getGender());
		tiersData.setIdCard(tiers.getIdCard());
		tiersData.setIdPhoto(tiers.getIdPhoto());
		tiersData.setIdTax(tiers.getIdTax());
		tiersData.setIdTradingExperience(tiers.getIdTradingExperience());
		tiersData.setLastName(tiers.getLastName());
		tiersData.setPassport(tiers.getPassport());
		tiersData.setPhoneNumber(tiers.getPhoneNumber());
		tiersData.setEmail(tiers.getEmail());
		
		tiersData.setIdTax(tiers.getIdTax());
		
		Tiers updatedTiers = tiersDao.updateTiers(tiersData);
		return new ResponseEntity<>(updatedTiers, HttpStatus.OK);
	}

	@DeleteMapping("/tiers/{id}")
	public ResponseEntity<String> deleteTiers(@PathVariable("id") UUID id) {
		System.out.println("Delete Tiers with ID = " + id + "...");

		tiersDao.deleteTiers(id);

		return new ResponseEntity<>("Tiers has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/tiers/delete")
	public ResponseEntity<String> deleteAlltiers() {
		System.out.println("Delete All tiers...");

		tiersDao.deleteAll();

		return new ResponseEntity<>("All tiers have been deleted!", HttpStatus.OK);
	}



}
