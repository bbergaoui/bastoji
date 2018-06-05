package us.onesquare.bastoji.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import us.onesquare.bastoji.dao.ICompanyDao;
import us.onesquare.bastoji.model.admin.Company;
import us.onesquare.bastoji.service.ICompanyService;

@Component
public class CompanyServiceImpl implements ICompanyService{
	@Autowired
	ICompanyDao companyDao;

	@Override
	public Company createCompany(Company company) {
		return  companyDao.createCompany(company);
	}

	@Override
	public Company getCompany(UUID id) {
		return companyDao.getCompany(id);
	}

	@Override
	public void updateCompany(Company company) {
		companyDao.updateCompany(company);
		
	}

	@Override
	public List<Company> getAllCompanies(Long first, Long limit) {
		return companyDao.getAllCompanies();
	}
}
