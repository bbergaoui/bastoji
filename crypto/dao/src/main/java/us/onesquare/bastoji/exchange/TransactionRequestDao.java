package us.onesquare.bastoji.exchange;

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
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;

import us.onesquare.bastoji.CassandraPaging;
import us.onesquare.bastoji.dao.exchange.ITransactionRequestDao;
import us.onesquare.bastoji.model.exchange.TransactionRequest;

@Component
public class TransactionRequestDao implements ITransactionRequestDao {

	@Autowired
	private Session session;

	@Autowired
	private CassandraOperations cassandraOperation;
	
	@Autowired
	CassandraPaging cassandraPaging = new CassandraPaging(session);
	
	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
	}

	@Override
	public TransactionRequest createTransactionRequest(TransactionRequest transactionRequest) {

		cassandraOperation.insert(transactionRequest);
		return transactionRequest;
	}

	@Override
	public TransactionRequest getTransactionRequest(UUID id) {

		return cassandraOperation.selectOneById(id, TransactionRequest.class);

	}

	@Override
	public void updateTransactionRequest(TransactionRequest transactionRequest) {

		cassandraOperation.update(transactionRequest);

	}

	@Override

	public void deleteTransactionRequests(Collection<UUID> TransactionRequests) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (UUID id : TransactionRequests) {
			list.add(new Object[] { id });
		}
		cassandraOperation.deleteById(list, TransactionRequest.class);
	}

	public void deleteTransactionRequest(UUID id) {
		cassandraOperation.deleteById(id, TransactionRequest.class);

	}

	@Override
	public List<TransactionRequest> getAllTransactionRequests(Long first, Long limit) {
		PreparedStatement prepared = session.prepare("SELECT * FROM transaction_request limit ?");
		BoundStatement bound = prepared.bind(limit);
		return cassandraOperation.select(bound, TransactionRequest.class);

	}

	@Override
	public List<TransactionRequest> getAllTransactionRequestsByUserName(String userName, Integer first, Integer limit) {
		Statement statement=new SimpleStatement("SELECT * FROM transaction_request where username=? ",userName);
		cassandraPaging.fetchRowsWithPage(statement, first, limit);
		return cassandraOperation.select(statement, TransactionRequest.class);

	}
	@Override
	public List<TransactionRequest> getAllTransactionRequestsByUserId(UUID userId, Integer first, Integer limit) {
		Statement statement=new SimpleStatement("SELECT * FROM transaction_request where userid=? ",userId);
		cassandraPaging.fetchRowsWithPage(statement, first, limit);
		return cassandraOperation.select(statement, TransactionRequest.class);

	}
	@Override
	public void deleteAll() {
		session.execute("delete FROM transaction_request");
	}

}