package us.onesquare.bastoji.server.controller.exchange;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import us.onesquare.bastoji.model.admin.User;
import us.onesquare.bastoji.model.exchange.TransactionRequest;
import us.onesquare.bastoji.service.ITransactionRequestService;
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class TransactionRequestController {

	@Autowired
	private ITransactionRequestService transactionRequestService;


	@RequestMapping(value = "/request/create", method = RequestMethod.POST)
	ResponseEntity<TransactionRequest> create(@RequestBody TransactionRequest transactionRequest) {
		transactionRequestService.requestTransaction(transactionRequest);
		 return new ResponseEntity<TransactionRequest>(transactionRequest , HttpStatus.OK);
	}

	@RequestMapping(value = "/request/update", method = RequestMethod.POST)
	TransactionRequest update(@RequestBody TransactionRequest transactionRequest) {

		transactionRequestService.updateRequestTransaction(transactionRequest);
		return transactionRequest;
	}
	@RequestMapping(value = "/requests", method = RequestMethod.GET)
	List<TransactionRequest> getAllRequestsByUserName(@RequestBody Authentication authentication,Integer first, Integer limit) {
		return transactionRequestService.getAllRequestsByUserName(authentication.getName(),first, limit);
	}
	@RequestMapping(value = "/requestsByUserId", method = RequestMethod.GET)
	List<TransactionRequest> getAllRequestsByUserId(@RequestBody User user,Integer first, Integer limit) {
		return transactionRequestService.getAllRequestsByUserId(user.getId(),first, limit);
	}
	

}
