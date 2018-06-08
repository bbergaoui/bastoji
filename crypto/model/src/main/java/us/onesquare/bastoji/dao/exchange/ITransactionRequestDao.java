package us.onesquare.bastoji.dao.exchange;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import us.onesquare.bastoji.model.exchange.TransactionRequest;

public interface ITransactionRequestDao {
	
	public TransactionRequest createTransactionRequest(TransactionRequest transactionRequest);

	public TransactionRequest getTransactionRequest(UUID id);

	public void updateTransactionRequest(TransactionRequest transactionRequest);

	public void deleteTransactionRequest(UUID id);
	
	public void deleteAll();

	public List<TransactionRequest> getAllTransactionRequests(Long first,Long limit);

	void deleteTransactionRequests(Collection<UUID> transactionRequests);


	List<TransactionRequest> getAllTransactionRequestsByUserName(String userName, Long first, Integer limit);


}
