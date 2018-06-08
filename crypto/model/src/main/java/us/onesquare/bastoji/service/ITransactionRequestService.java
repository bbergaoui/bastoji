package us.onesquare.bastoji.service;

import java.util.List;

import us.onesquare.bastoji.model.exchange.TransactionRequest;

public interface ITransactionRequestService {
	
	
	
	void requestTransaction(TransactionRequest request);

	void updateRequestTransaction(TransactionRequest request);
	
	List<TransactionRequest> getAllRequests(Long first, Long limit);
	

	List<TransactionRequest> getAllRequestsByUserName(String userName, Long first, Integer limit);



}
