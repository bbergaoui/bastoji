package us.onesquare.bastoji;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;

import us.onesquare.bastoji.dao.IRegistrationDao;
import us.onesquare.bastoji.model.subscription.Registration;

@Component
public class RegistrationImplDao implements IRegistrationDao {

	@Autowired
	private Session session;

	@Autowired
	private CassandraOperations cassandraOperations;

	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();

	}

	@Override
	public Registration createRegistration(Registration registration) {
		System.out.println("\n*********Insert User Data  *************");

		PreparedStatement prepared = session.prepare(
				"insert into registration (id, email, password,isCompany,companyEmail,companyAddress,companyName,companyId,firstName,lastName,enabled,phoneNumber,confirmationToken) values (?, ? ,?,?, ? ,?,?, ? ,?,?,?, ? ,?)");

		BoundStatement bound = prepared.bind(UUID.randomUUID(), registration.getEmail(), registration.getPassword(),
				registration.getIsCompany(), registration.getCompanyEmail(), registration.getCompanyAddress(),
				registration.getCompanyName(), registration.getCompanyId(), registration.getFirstName(),
				registration.getLastName(), registration.getEnabled(), registration.getPhoneNumber(),
				registration.getConfirmationToken());
		session.execute(bound);
		return registration;
	}

	// @Override
	// public Registration getRegistration(UUID id) {
	// Registration u = (Registration) session.execute("select * from
	// registration where id=?", id);
	// return u;
	// }

	// @Override
	// public Registration updateRegistration(Registration registration) {
	// session.execute(
	// "update registration set password=? ,email=?,isCompany=?,companyEmail=?
	// ,companyAddress=?,companyName=? ,companyId=?,firstName=? ,lastName=?
	// ,enabled=? ,phoneNumber=?,confirmationToken=? "
	// + " where id = ?",
	// registration.getPassword(), registration.getEmail(),
	// registration.getIsCompany(),
	// registration.getCompanyEmail(), registration.getCompanyAddress(),
	// registration.getCompanyName(),
	// registration.getCompanyId(), registration.getFirstName(),
	// registration.getLastName(),
	// registration.getEnabled(), registration.getPhoneNumber(),
	// registration.getConfirmationToken(),
	// registration.getId());
	//
	// }

	// @Override
	// public void deleteRegistration(int id) {
	//// List<Object[]> list = new ArrayList<Object[]>();
	//// for (UUID id : Registrations) {
	//// list.add(new Object[] { id });
	//// }
	// session.execute("delete FROM registration where id =?", list);
	//
	// }

	@Override
	public List<Registration> getAllRegistrations() {

		return cassandraOperations.select("SELECT * FROM registration", Registration.class);

	}

	@Override
	public Registration getRegistration(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRegistration(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Registration updateRegistration(Registration registration) {
		// TODO Auto-generated method stub
		return null;
	}

}
