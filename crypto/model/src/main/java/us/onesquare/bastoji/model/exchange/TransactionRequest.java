package us.onesquare.bastoji.model.exchange;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
@Table
public class TransactionRequest {


	@PrimaryKey
	private UUID id;

	private Date transactionDate;
	
	private Integer transactionType;
	
	private UUID userId;

	private String bitcoinAddress;
	
	private String comment;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Integer getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public String getBitcoinAddress() {
		return bitcoinAddress;
	}

	public void setBitcoinAddress(String bitcoinAddress) {
		this.bitcoinAddress = bitcoinAddress;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
