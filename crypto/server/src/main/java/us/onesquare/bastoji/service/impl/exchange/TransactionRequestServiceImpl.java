package us.onesquare.bastoji.service.impl.exchange;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import us.onesquare.bastoji.dao.exchange.ITransactionRequestDao;
import us.onesquare.bastoji.model.exchange.TransactionRequest;
import us.onesquare.bastoji.service.ITransactionRequestService;
@Component
public abstract class TransactionRequestServiceImpl implements ITransactionRequestService{
	
	
	
	@Autowired
	private ITransactionRequestDao transactionRequestDao;
	
	
	@Override
	public void requestTransaction(TransactionRequest request) {
		
		transactionRequestDao.createTransactionRequest(request);
	}

	@Override
	public void updateRequestTransaction(TransactionRequest request) {
		transactionRequestDao.updateTransactionRequest(request);
		
	}

	@Override
	public List<TransactionRequest> getAllRequests(Long first, Long limit) {
		
		return transactionRequestDao.getAllTransactionRequests(first, limit);
	}

	@Override
	public List<TransactionRequest> getAllRequestsByUserName(String userName, Integer first, Integer limit) {

		return  transactionRequestDao.getAllTransactionRequestsByUserName(userName, first, limit);
	}

	@Override
	public List<TransactionRequest> getAllRequestsByUserId(UUID userId, Integer first, Integer limit) {

		return  transactionRequestDao.getAllTransactionRequestsByUserId(userId, first, limit);
	}
	
	
}
