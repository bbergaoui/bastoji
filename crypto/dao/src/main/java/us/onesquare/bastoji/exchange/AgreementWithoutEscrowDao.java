package us.onesquare.bastoji.exchange;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;

import us.onesquare.bastoji.model.exchange.AgreementWithoutEscrow;

public class AgreementWithoutEscrowDao {
//	
//	
//	@Autowired
//	private Session session;
//	
//	
//	
//	@Autowired
//	private CassandraOperations cassandraOperation;
//
//	public static Cluster connect(String node) {
//		return Cluster.builder().addContactPoint(node).build();
//	}
//	 
//
//
//	@Override
//	public AgreementWithoutEscrow createAgreementWithoutEscrow(AgreementWithoutEscrow agreementWithoutEscrow) {
//
//		PreparedStatement prepared = session.prepare("insert into agreementWithoutEscrow (id, email, password) values (?, ? ,?)");
//
//		BoundStatement bound = prepared.bind(UUID.randomUUID(), agreementWithoutEscrow.getEmail(), agreementWithoutEscrow.getPassword());
//		session.execute(bound);
//		return agreementWithoutEscrow;
//	}
//
//	@Override
//	public AgreementWithoutEscrow getAgreementWithoutEscrow(UUID id) {
//
//		AgreementWithoutEscrow u = (AgreementWithoutEscrow) session.execute("select * from agreementWithoutEscrow where id=?", id);
//		return u;
//
//	}
//
//	@Override
//	public void updateAgreementWithoutEscrow(AgreementWithoutEscrow agreementWithoutEscrow) {
//
//		session.execute("update agreementWithoutEscrow set password=? ,email=? " + "  where id = ?", agreementWithoutEscrow.getPassword(), agreementWithoutEscrow.getEmail(),
//				agreementWithoutEscrow.getId());
//
//	}
//
//	@Override
//
//	public void deleteAgreementWithoutEscrows(Collection<UUID> AgreementWithoutEscrows) {
//		List<Object[]> list = new ArrayList<Object[]>();
//		for (UUID id : AgreementWithoutEscrows) {
//			list.add(new Object[] { id });
//		}
//		session.execute("delete FROM agreementWithoutEscrow where id =?", list);
//	}
//
//	public void deleteAgreementWithoutEscrow(UUID id) {
//
//		
//		session.execute("delete FROM agreementWithoutEscrow where id =?",id);
//	
//
//	}
//
//	@Override
//	public List<AgreementWithoutEscrow> getAllAgreementWithoutEscrows() {
//		return cassandraOperation.select("SELECT * FROM agreementWithoutEscrow" , AgreementWithoutEscrow.class);
//		
//	}
//
//	@Override
//	public void deleteAll() {
//		session.execute("delete FROM agreementWithoutEscrow ");
//	}
//
//
//
//	@Override
//	public AgreementWithoutEscrow findByAgreementWithoutEscrowNameAndPassword(String login, String password) {
//		PreparedStatement prepared = session.prepare("insert into agreementWithoutEscrow (id, email, password) values (?, ? ,?)");
//		BoundStatement bound = prepared.bind( login, password);
//		return cassandraOperation.selectOne(bound, AgreementWithoutEscrow.class);
//		
//	}
//
}
