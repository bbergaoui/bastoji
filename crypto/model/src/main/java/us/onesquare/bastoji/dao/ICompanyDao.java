package us.onesquare.bastoji.dao;

import java.util.List;
import java.util.UUID;

import us.onesquare.bastoji.model.admin.Company;

public interface ICompanyDao {
	
	public Company createCompany(Company company);

	public Company getCompany(UUID id);

	public void updateCompany(Company company);

	public void deleteCompany(UUID id);
	
	public void deleteAll();

	public List<Company> getAllCompanies();

}
