package us.onesquare.bastoji.service;

import java.util.UUID;

import us.onesquare.bastoji.model.admin.Company;

public interface ICompanyService {

	Company createCompany(Company company);

	Company getCompany(UUID id);

	void updateCompany(Company companyData);
	

}
