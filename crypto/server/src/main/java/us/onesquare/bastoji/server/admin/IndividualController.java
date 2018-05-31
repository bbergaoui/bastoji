package us.onesquare.bastoji.server.admin;

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

import us.onesquare.bastoji.model.admin.Individual;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class IndividualController {

	@Autowired
	IndividualRepository individualRepository;

	@GetMapping("/individuals")
	public List<Individual> getAllIndividuals() {
		System.out.println("Get all Individuals...");

		List<Individual> individuals = new ArrayList<>();
		individualRepository.findAll().forEach(individuals::add);
		return individuals;
	}

	@PostMapping("/individuals/create")
	public ResponseEntity<Individual> createIndividual(@Valid @RequestBody Individual individual) {
		System.out.println("Create Individual: " + individual.getId() + "...");

		individual.setId(UUIDs.timeBased());
		individual.setIsAddressValidated(false);
		individual.setIsIdentityValidated(false);
		individual.setIsPhoneValidated(false);
		Individual _individual = individualRepository.save(individual);
		return new ResponseEntity<>(_individual, HttpStatus.OK);
	}

	@PutMapping("/individuals/{id}")
	public ResponseEntity<Individual> updateIndividual(@PathVariable("id") UUID id, @RequestBody Individual individual) {
		System.out.println("Update Individual with ID = " + id + "...");

		Individual individualData = individualRepository.findById(id).get();
		if (individualData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		individualData.setIdTiers(individual.getIdTiers());
		individualData.setIdUser(individual.getIdUser());
		individualData.setUserCategory(individual.getUserCategory());

		individual.setIsAddressValidated(individual.getIsAddressValidated());
		individual.setIsIdentityValidated(individual.getIsIdentityValidated());
		individual.setIsPhoneValidated(individual.getIsPhoneValidated());
		Individual updatedindividual = individualRepository.save(individualData);
		return new ResponseEntity<>(updatedindividual, HttpStatus.OK);
	}

	@DeleteMapping("/individuals/{id}")
	public ResponseEntity<String> deleteIndividual(@PathVariable("id") UUID id) {
		System.out.println("Delete Individual with ID = " + id + "...");

		individualRepository.delete(individualRepository.findById(id).get());

		return new ResponseEntity<>("Individual has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/individuals/delete")
	public ResponseEntity<String> deleteAllIndividuals() {
		System.out.println("Delete All Individuals...");

		individualRepository.deleteAll();

		return new ResponseEntity<>("All individuals have been deleted!", HttpStatus.OK);
	}
}
