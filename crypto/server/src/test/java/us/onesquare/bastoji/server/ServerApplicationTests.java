package us.onesquare.bastoji.server;

import org.apache.tools.ant.taskdefs.email.EmailTask;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import us.onesquare.bastoji.dao.ICompanyDao;
import us.onesquare.bastoji.dao.IRegistrationDao;
import us.onesquare.bastoji.model.admin.Company;
import us.onesquare.bastoji.model.subscription.Registration;
import us.onesquare.bastoji.service.ICompanyService;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {


	@Autowired
	private ICompanyService companyService;
	@Autowired
	private ICompanyDao companyDao;

	@Autowired
	private IRegistrationDao registrationDao;

	@Test
	public void contextLoads() {
	}


	@Test
	public void registrationDaoTest() {


		List<Registration> allRegistrations = registrationDao.getAllRegistrations();

		if (allRegistrations.size()==0) {

			Registration registration = new Registration();

			registration.setId(UUID.randomUUID());
			registration.setEmail("zdbrig@onesquare.us");
			registration.setPassword("zdbrig");
			registration.setMailConfirmationToken(UUID.randomUUID().toString());
			registrationDao.createRegistration(registration);
		}
		Logger.getLogger("main test").info(" number of registrations " + allRegistrations.size());

		Assert.assertTrue(allRegistrations.size()>0);
	}

	@Test
	public void companyDaoTest() {


		List<Company> companies = companyDao.getAllCompanies();

		if (companies.size() ==0) {
			Company c = new Company();
			c.setId(UUID.randomUUID());
			c.setCompanyName("One Square");
			companyDao.createCompany(c);
		}

		companies = companyDao.getAllCompanies();

		Logger.getLogger("main test").info(" number of companies " + companies.size());

		Assert.assertTrue(companies.size()>0);
	}



}
