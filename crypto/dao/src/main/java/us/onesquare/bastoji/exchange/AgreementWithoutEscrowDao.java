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

import us.onesquare.bastoji.dao.exchange.IAgreementWithoutEscrowDao;
import us.onesquare.bastoji.model.exchange.AgreementWithoutEscrow;

public class AgreementWithoutEscrowDao implements IAgreementWithoutEscrowDao{
	
	
	@Autowired
	private Session session;
	
	
	
	@Autowired
	private CassandraOperations cassandraOperation;

	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
	}
	 


	@Override
	public AgreementWithoutEscrow createAgreementWithoutEscrow(AgreementWithoutEscrow agreementWithoutEscrow) {

		cassandraOperation.insert(agreementWithoutEscrow);
		return agreementWithoutEscrow;
	}

	@Override
	public AgreementWithoutEscrow getAgreementWithoutEscrow(UUID id) {

		return cassandraOperation.selectOneById(id, AgreementWithoutEscrow.class);

	}

	@Override
	public void updateAgreementWithoutEscrow(AgreementWithoutEscrow agreementWithoutEscrow) {

		cassandraOperation.update(agreementWithoutEscrow);

	}

	@Override

	public void deleteAgreementWithoutEscrows(Collection<UUID> AgreementWithoutEscrows) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (UUID id : AgreementWithoutEscrows) {
			list.add(new Object[] { id });
		}
		cassandraOperation.deleteById(list, AgreementWithoutEscrow.class);
	}

	public void deleteAgreementWithoutEscrow(UUID id) {
		cassandraOperation.deleteById(id, AgreementWithoutEscrow.class);

	}

	@Override
	public List<AgreementWithoutEscrow> getAllAgreementWithoutEscrows() {
		
		return cassandraOperation.select("SELECT * FROM agreement_without_escrow" , AgreementWithoutEscrow.class);
		
	}

	@Override
	public void deleteAll(Long limit, Long first) {
	
		session.execute("delete from agreement_without_escrow ");
	}

}
