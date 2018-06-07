package us.onesquare.bastoji.server;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import us.onesquare.bastoji.dao.ICompanyDao;
import us.onesquare.bastoji.model.admin.Company;
import us.onesquare.bastoji.service.ICompanyService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {


	@Autowired
	private ICompanyService companyService;
	@Autowired
	private ICompanyDao companyDao;



	@Test
	public void companyDaoTest() {

		   
		List<Company> companies = companyDao.getAllCompanies();

		if (companies.size() ==0) {
			Company c = new Company();
			c.setCompanyName("one square");
			companyDao.createCompany(c);
		}

		companies = companyDao.getAllCompanies();

		Logger.getLogger("main test").info(" number of companies " + companies.size());

		Assert.assertTrue(companies.size()>0);
	}



}
