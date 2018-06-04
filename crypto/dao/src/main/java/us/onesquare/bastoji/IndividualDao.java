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

import us.onesquare.bastoji.dao.IIndividualDao;
import us.onesquare.bastoji.model.admin.Individual;

@Component
public class IndividualDao implements IIndividualDao {

	@Autowired
	private Session session;

	@Autowired
	private CassandraOperations cassandraOperation;

	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
	}

	@Override
	public Individual createIndividual(Individual individual) {

		PreparedStatement prepared = session.prepare(
				"insert into individual (id, id_tiers,id_user,is_identity_validated,is_address_validated,is_phone_validated, user_category) values (?, ? ,?, ?, ?, ?)");

		BoundStatement bound = prepared.bind(UUID.randomUUID(), individual.getIdTiers(), individual.getIdUser(),
				individual.getIsIdentityValidated(), individual.getIsAddressValidated(),
				individual.getIsPhoneValidated(), individual.getUserCategory());
		session.execute(bound);
		return individual;
	}

	@Override
	public Individual getIndividual(UUID id) {

		Individual u = (Individual) session.execute("select * from individual where id=?", id);
		return u;

	}

	@Override
	public void updateIndividual(Individual individual) {

		session.execute(
				"update individual set id_tiers=?,id_user=?,is_identity_validated=?,is_address_validated=?,is_phone_validated=?, user_category=? "
						+ "  where id = ?",
				individual.getIdTiers(), individual.getIdUser(), individual.getIsIdentityValidated(),
				individual.getIsAddressValidated(), individual.getIsPhoneValidated(), individual.getUserCategory(),
				individual.getId());

	}

	@Override

	public void deleteIndividuals(Collection<UUID> individuals) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (UUID id : individuals) {
			list.add(new Object[] { id });
		}
		session.execute("delete FROM individual where id =?", list);
	}

	public void deleteIndividual(UUID id) {

		session.execute("delete FROM individual where id =?", id);

	}

	@Override
	public List<Individual> getAllIndividuals() {
		return cassandraOperation.select("SELECT * FROM individual", Individual.class);

	}

	@Override
	public void deleteAll() {
		session.execute("delete FROM individual ");
	}

	@Override
	public Individual findByUserId(Long userId) {
		PreparedStatement prepared = session.prepare("insert into individual (id, user_id) values (?, ? )");
		BoundStatement bound = prepared.bind(userId);
		return cassandraOperation.selectOne(bound, Individual.class);

	}
}
