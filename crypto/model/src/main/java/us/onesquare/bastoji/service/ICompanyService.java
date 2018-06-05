package us.onesquare.bastoji.service;

import java.util.List;
import java.util.UUID;

import us.onesquare.bastoji.model.admin.Company;

public interface ICompanyService {

	Company createCompany(Company company);

	Company getCompany(UUID id);

	void updateCompany(Company companyData);


	List<Company> getAllCompanies(Long first , Long limit);

}
