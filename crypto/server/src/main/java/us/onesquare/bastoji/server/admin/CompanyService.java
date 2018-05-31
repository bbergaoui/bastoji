package us.onesquare.bastoji.server.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.onesquare.bastoji.model.admin.Company;

@Service("companyService")
public class CompanyService {
	private CompanyRepository companyRepository;

	@Autowired
	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public Company findByEmail(String email) {
		return companyRepository.findByEmail(email);
	}

	public void saveCompany(Company company) {
		companyRepository.save(company);
	}

}
