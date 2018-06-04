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

import us.onesquare.bastoji.dao.IIdentityProofDao;
import us.onesquare.bastoji.model.admin.IdentityProof;

@Component
public class IdentityProofDao implements IIdentityProofDao {

	@Autowired
	private Session session;

	@Autowired
	private CassandraOperations cassandraOperation;

	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
	}

	@Override
	public IdentityProof createIdentityProof(IdentityProof identityProof) {

		PreparedStatement prepared = session
				.prepare("insert into identity_proof (id, description, proof,thumbnail,user_id) values (?, ? ,?,?,?)");

		BoundStatement bound = prepared.bind(UUID.randomUUID(), identityProof.getDescription(),
				identityProof.getProof(), identityProof.getThumbnail(), identityProof.getUserId());
		session.execute(bound);
		return identityProof;
	}

	@Override
	public IdentityProof getIdentityProof(UUID id) {

		IdentityProof u = (IdentityProof) session.execute("select * from identityProof where id=?", id);
		return u;

	}

	@Override
	public void updateIdentityProof(IdentityProof identityProof) {

		session.execute("update identity_proof " + "  where id = ?", identityProof.getDescription(),
				identityProof.getProof(), identityProof.getThumbnail(), identityProof.getUserId(), identityProof.getId());

	}

	@Override

	public void deleteIdentityProofs(Collection<UUID> IdentityProofs) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (UUID id : IdentityProofs) {
			list.add(new Object[] { id });
		}
		session.execute("delete FROM identity_proof where id =?", list);
	}

	public void deleteIdentityProof(UUID id) {

		session.execute("delete FROM identity_proof where id =?", id);

	}

	@Override
	public List<IdentityProof> getAllIdentityProofs() {
		return cassandraOperation.select("SELECT * FROM identity_proof", IdentityProof.class);

	}

	@Override
	public void deleteAll() {
		session.execute("delete FROM identityProof ");
	}

	@Override
	public IdentityProof findByUserId(Long userId) {
		PreparedStatement prepared = session
				.prepare("insert into identity_proof (id, user_id) values (?, ? )");
		BoundStatement bound = prepared.bind(userId);
		return cassandraOperation.selectOne(bound, IdentityProof.class);

	}

}
