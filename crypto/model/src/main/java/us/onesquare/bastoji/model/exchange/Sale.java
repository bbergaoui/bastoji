package us.onesquare.bastoji.model.exchange;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Sale {
	@PrimaryKey
	private UUID id;
	
	private UUID userID;
	
	private Double amount;
	
	private Double requestedValue;
	
	private String amountCurrency;
	
	private String requestedCurrency;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getUserID() {
		return userID;
	}

	public void setUserID(UUID userID) {
		this.userID = userID;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getRequestedValue() {
		return requestedValue;
	}

	public void setRequestedValue(Double requestedValue) {
		this.requestedValue = requestedValue;
	}

	public String getAmountCurrency() {
		return amountCurrency;
	}

	public void setAmountCurrency(String amountCurrency) {
		this.amountCurrency = amountCurrency;
	}

	public String getRequestedCurrency() {
		return requestedCurrency;
	}

	public void setRequestedCurrency(String requestedCurrency) {
		this.requestedCurrency = requestedCurrency;
	}
	
	

}
