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

import us.onesquare.bastoji.model.admin.Individual;
import us.onesquare.bastoji.service.IIndividualService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class IndividualController {

	@Autowired
	IIndividualService individualService;

	

	@PostMapping("/individuals/create")
	public ResponseEntity<Individual> createIndividual(@Valid @RequestBody Individual individual) {
		Individual _individual = individualService.createIndividual(individual);
		return new ResponseEntity<>(_individual, HttpStatus.OK);
	}

	@PutMapping("/individuals/{id}")
	public ResponseEntity<Individual> updateIndividual(@PathVariable("id") UUID id, @RequestBody Individual individual) {
		System.out.println("Update Individual with ID = " + id + "...");

		Individual individualData = individualService.getIndividual(id);
		if (individualData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		individualService.updateIndividual(individualData);
		return new ResponseEntity<>(individualData, HttpStatus.OK);
	}

	

}
