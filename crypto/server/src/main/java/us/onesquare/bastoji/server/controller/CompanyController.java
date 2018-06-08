package us.onesquare.bastoji.server.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.datastax.driver.core.utils.UUIDs;

import us.onesquare.bastoji.model.admin.Company;
import us.onesquare.bastoji.service.ICompanyService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CompanyController {
	@Autowired
	private ICompanyService companyService;

	@PreAuthorize("#oauth2.hasScope('web') and #oauth2.hasScope('read')")
	@ResponseBody
	@GetMapping("/companies")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Company> getAllCompanies() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Logger.getLogger("CompanyController").warning("user details -> " + principal);
		return companyService.getAllCompanies(0l,10l);
	}

	@PostMapping("/companies/create")
	public ResponseEntity<Company> createCompany(@Valid @RequestBody Company company) {
		company.setId(UUIDs.timeBased());
		Company _company = companyService.createCompany(company);
		return new ResponseEntity<>(_company, HttpStatus.OK);
	}

	@PutMapping("/companies/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable("id") UUID id, @RequestBody Company company) {
		Company companyData = companyService.getCompany(id);
		if (companyData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	
		companyService.updateCompany(companyData);
		return new ResponseEntity<>(companyData, HttpStatus.OK);
	}

//	@DeleteMapping("/companies/{id}")
//	public ResponseEntity<String> deleteCompany(@PathVariable("id") UUID id) {
//		System.out.println("Delete Company with ID = " + id + "...");
//
//		companyDao.deleteCompany(id);
//
//		return new ResponseEntity<>("Company has been deleted!", HttpStatus.OK);
//	}

}
