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

import us.onesquare.bastoji.CompanyDao;
import us.onesquare.bastoji.dao.ICompanyDao;
import us.onesquare.bastoji.model.admin.Company;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CompanyController {
	@Autowired
	private ICompanyDao companyDao;

	public ICompanyDao getCompanyDao() {
		return companyDao;
	}

	public void setCompanyDao(ICompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@GetMapping("/companies")
	public List<Company> getAllCompanies() {
		System.out.println("Get all Companies...");

		List<Company> companies = new ArrayList<>();
		
		return companies;
	}

	@PostMapping("/companies/create")
	public ResponseEntity<Company> createCompany(@Valid @RequestBody Company company) {
		System.out.println("Create Company: " + company.getLegalName() + "...");

		company.setId(UUIDs.timeBased());
		Company _company = companyDao.createCompany(company);
		return new ResponseEntity<>(_company, HttpStatus.OK);
	}

	@PutMapping("/companies/{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable("id") UUID id, @RequestBody Company company) {
		System.out.println("Update Company with ID = " + id + "...");

		Company companyData = companyDao.getCompany(id);
		if (companyData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		companyData.setAddress(company.getAddress());
		companyData.setBusinessActivity(company.getBusinessActivity());
		companyData.setCapital(company.getCapital());
		companyData.setCategoryCode(company.getCategoryCode());
		companyData.setCategoryLabel(company.getCategoryLabel());
		companyData.setCompanyName(company.getCompanyName());
		companyData.setCompanyType(company.getCompanyType());
		companyData.setDescription(company.getDescription());
		companyData.setDirector(company.getDirector());
		companyData.setEmail(company.getEmail());
		companyData.setEmployeesNumber(company.getEmployeesNumber());
		companyData.setFoundingYear(company.getFoundingYear());
		companyData.setHeadQuarterAddress(company.getHeadQuarterAddress());
		companyData.setIdContactDetails(company.getIdContactDetails());
		companyData.setIdLogo(company.getIdLogo());
		companyData.setIdTax(company.getIdTax());
		companyData.setIsAddressValidated(company.getIsAddressValidated());
		companyData.setIsHeadquarters(company.getIsHeadquarters());
		companyData.setIsIdentityValidated(company.getIsIdentityValidated());
		companyData.setIsPhoneValidated(company.getIsPhoneValidated());
		companyData.setLegalImmatriculation(company.getLegalImmatriculation());
		companyData.setLegalIsNonprofit(company.getLegalIsNonprofit());
		companyData.setLegalName(company.getLegalName());
		companyData.setLegalStatus(company.getLegalStatus());
		companyData.setLegalStructure(company.getLegalStructure());
		companyData.setPhoneNumber(company.getPhoneNumber());
		companyData.setUserCategory(company.getUserCategory());
		companyData.setUserId(company.getUserId());	
		companyData.setWebSite(company.getWebSite());
		companyDao.updateCompany(companyData);
		return new ResponseEntity<>(companyData, HttpStatus.OK);
	}

	@DeleteMapping("/companies/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable("id") UUID id) {
		System.out.println("Delete Company with ID = " + id + "...");

		companyDao.deleteCompany(id);

		return new ResponseEntity<>("Company has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/companies/delete")
	public ResponseEntity<String> deleteAllCompanies() {
		System.out.println("Delete All Companies...");

		companyDao.deleteAll();

		return new ResponseEntity<>("All Companies have been deleted!", HttpStatus.OK);
	}

}
