package us.onesquare.bastoji.server.controller.exchange;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import us.onesquare.bastoji.model.exchange.TransactionRequest;
import us.onesquare.bastoji.service.ITransactionRequestService;

public class TransactionRequestController {

	@Autowired
	private ITransactionRequestService transactionRequestService;


	@RequestMapping(value = "/request", method = RequestMethod.POST)
	ResponseEntity<TransactionRequest> create(@RequestBody TransactionRequest transactionRequest) {
		transactionRequestService.requestTransaction(transactionRequest);
		 return new ResponseEntity<TransactionRequest>(transactionRequest , HttpStatus.OK);
	}

	@RequestMapping(value = "/request", method = RequestMethod.POST)
	TransactionRequest update(@RequestBody TransactionRequest transactionRequest) {

		transactionRequestService.updateRequestTransaction(transactionRequest);
		return transactionRequest;
	}
	@RequestMapping(value = "/requests", method = RequestMethod.GET)
	List<TransactionRequest> getAllRequests(@RequestBody Authentication authentication,Long first, Integer limit) {
		return transactionRequestService.getAllRequestsByUserName(authentication.getName(),first, limit);
	}
	

}
