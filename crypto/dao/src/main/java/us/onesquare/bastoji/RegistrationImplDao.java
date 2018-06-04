package us.onesquare.bastoji;

import java.util.ArrayList;
import java.util.Collection;
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

		PreparedStatement prepared = session.prepare(
				"insert into registration (id, email, password,is_company,company_email,company_name,company_id,first_name,last_name,enabled,phone_number,mail_confirmation_token,phone_confirmation_token,city,street_name,street_number,country) values (?, ? ,?,?, ? ,?,?, ? ,?,?,?, ? ,?,?,?,?)");

		BoundStatement bound = prepared.bind(UUID.randomUUID(), registration.getEmail(), registration.getPassword(),
				registration.getIsCompany(), registration.getCompanyEmail(), registration.getCompanyName(),
				registration.getCompanyId(), registration.getFirstName(), registration.getLastName(),
				registration.getEnabled(), registration.getPhoneNumber(), registration.getMailConfirmationToken(),
				registration.getPhoneConfirmationToken(), registration.getCity(), registration.getStreetName(),
				registration.getStreetNumber(), registration.getCountry());
		session.execute(bound);
		return registration;
	}

	@Override
	public Registration getRegistration(UUID id) {
		Registration u = (Registration) session.execute("select * from registration where id=?", id);
		return u;
	}

	@Override
	public void updateRegistration(Registration registration) {
		session.execute(
				"update registration set email=?, password=?,is_company=?,company_email=?,"
				+ "company_name=?,company_id=?,first_name=?,last_name=?,enabled=?,"
				+ "phone_number=?,mail_confirmation_token=?,phone_confirmation_token=?,"
				+ "city=?,street_name=?,street_number=?,country=? " + " where id = ?",
				registration.getEmail(), registration.getPassword(),
				registration.getIsCompany(), registration.getCompanyEmail(), registration.getCompanyName(),
				registration.getCompanyId(), registration.getFirstName(), registration.getLastName(),
				registration.getEnabled(), registration.getPhoneNumber(), registration.getMailConfirmationToken(),
				registration.getPhoneConfirmationToken(), registration.getCity(), registration.getStreetName(),
				registration.getStreetNumber(), registration.getCountry(),
				registration.getId());

	}

	@Override
	public void deleteRegistrations(Collection<UUID> registrations) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (UUID id : registrations) {
			list.add(new Object[] { id });
		}
		session.execute("delete FROM registration where id =?", list);

	}

	@Override
	public List<Registration> getAllRegistrations() {

		return cassandraOperations.select("SELECT * FROM registration", Registration.class);

	}

	@Override
	public void deleteRegistration(UUID id) {
		session.execute("delete FROM registration where id =?", id);

	}

}
