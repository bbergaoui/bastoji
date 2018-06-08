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
import us.onesquare.bastoji.dao.IRegistrationDao;
import us.onesquare.bastoji.dao.exchange.ITransactionRequestDao;
import us.onesquare.bastoji.model.admin.Company;
import us.onesquare.bastoji.model.exchange.TransactionRequest;
import us.onesquare.bastoji.model.subscription.Registration;
import us.onesquare.bastoji.service.ICompanyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {


	@Autowired
	private ICompanyService companyService;
	@Autowired
	private ICompanyDao companyDao;

	@Autowired
	private IRegistrationDao registrationDao;
	
	@Autowired
	private ITransactionRequestDao transactionRequestDao;


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
	@Test
	public void transactionRequestDaoTest() {


		List<TransactionRequest> requests = transactionRequestDao.getAllTransactionRequests( 0l, 10l);

		if (requests.size() ==0) {
			TransactionRequest c = new TransactionRequest();
			c.setId(UUID.randomUUID());
			transactionRequestDao.createTransactionRequest(c);
		}

		requests = transactionRequestDao.getAllTransactionRequests( 0l, 10l);


		Logger.getLogger("main test").info(" number of requests " + requests.size());

		Assert.assertTrue(requests.size()>0);
	}


}
