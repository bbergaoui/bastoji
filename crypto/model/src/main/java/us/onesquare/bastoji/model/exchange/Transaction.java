package us.onesquare.bastoji.model.exchange;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
@Table
public class Transaction {


	@PrimaryKey
	private UUID id;

	private Date transactionDate;
	
	private String transactionType;
	

	

}
