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

import us.onesquare.bastoji.dao.ITiersDao;
import us.onesquare.bastoji.model.admin.Tiers;

@Component
public class TiersDao implements ITiersDao {

	@Autowired
	private Session session;

	@Autowired
	private CassandraOperations cassandraOperation;

	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
	}

	@Override
	public Tiers createTiers(Tiers tiers) {

		PreparedStatement prepared = session.prepare(
				"insert into tiers (id, email, address,birthdate,facebook, first_name, function, gender, id_card, id_photo, id_tax, id_trading_experience, last_name,passeport, phone_number, subscription_date) values (?, ? ,?, ?, ? ,?,?, ? ,?,?, ? ,?,?, ? ,?,?)");

		BoundStatement bound = prepared.bind(UUID.randomUUID(), tiers.getEmail(), tiers.getAddress(),
				tiers.getBirthdate(), tiers.getFacebook(), tiers.getFirstName(), tiers.getFunction(), tiers.getGender(),
				tiers.getIdCard(), tiers.getIdPhoto(), tiers.getIdTax(), tiers.getIdTradingExperience(),
				tiers.getLastName(), tiers.getPassport(), tiers.getPhoneNumber(), tiers.getSubscriptionDate());
		session.execute(bound);
		return tiers;
	}

	@Override
	public Tiers getTiers(UUID id) {

		Tiers u = (Tiers) session.execute("select * from tiers where id=?", id);
		return u;

	}

	@Override
	public void updateTiers(Tiers tiers) {

		session.execute("update tiers set email=?, address=?,birthdate=?,facebook=?,"
				+ " first_name=?, function=?, gender=?, id_card=?, id_photo=?, id_tax=?, id_trading_experience=?,"
				+ " last_name,passeport=?, phone_number=?, subscription_date=? " + "  where id = ?", tiers.getEmail(), tiers.getAddress(),
				tiers.getBirthdate(), tiers.getFacebook(), tiers.getFirstName(), tiers.getFunction(), tiers.getGender(),
				tiers.getIdCard(), tiers.getIdPhoto(), tiers.getIdTax(), tiers.getIdTradingExperience(),
				tiers.getLastName(), tiers.getPassport(), tiers.getPhoneNumber(), tiers.getSubscriptionDate(), tiers.getId());

	}

	@Override

	public void deleteTiersList(Collection<UUID> tiers) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (UUID id : tiers) {
			list.add(new Object[] { id });
		}
		session.execute("delete FROM tiers where id =?", list);
	}

	public void deleteTiers(UUID id) {

		session.execute("delete FROM tiers where id =?", id);

	}

	@Override
	public List<Tiers> getAllTierss() {
		return cassandraOperation.select("SELECT * FROM tiers", Tiers.class);

	}

	@Override
	public void deleteAll() {
		session.execute("delete FROM tiers ");
	}

	

}
