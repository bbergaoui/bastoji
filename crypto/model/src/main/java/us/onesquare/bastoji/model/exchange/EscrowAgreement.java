package us.onesquare.bastoji.model.exchange;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
@Table
public class EscrowAgreement {


	@PrimaryKey
	private UUID id;

	private Long idDepositor;
	
	private Long idEscrowAgent;
	
	private Long idBeneficiary;
	
	private Double escrowFunds;
	
	private String escrowFundsType;
	
	private Double releaseFunds;
	
	private String releaseConditions;
	
	private Double escrowAgentFees;
	
	private Date LimitPaymentDate;
	
	private Integer agreementStatus;
	
	private Date agreementDeadLine;
	
	private Date agreementDate;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getIdDepositor() {
		return idDepositor;
	}

	public void setIdDepositor(Long idDepositor) {
		this.idDepositor = idDepositor;
	}

	public Long getIdEscrowAgent() {
		return idEscrowAgent;
	}

	public void setIdEscrowAgent(Long idEscrowAgent) {
		this.idEscrowAgent = idEscrowAgent;
	}

	public Long getIdBeneficiary() {
		return idBeneficiary;
	}

	public void setIdBeneficiary(Long idBeneficiary) {
		this.idBeneficiary = idBeneficiary;
	}

	public Double getEscrowFunds() {
		return escrowFunds;
	}

	public void setEscrowFunds(Double escrowFunds) {
		this.escrowFunds = escrowFunds;
	}

	public String getReleaseConditions() {
		return releaseConditions;
	}

	public void setReleaseConditions(String releaseConditions) {
		this.releaseConditions = releaseConditions;
	}

	public Double getEscrowAgentFees() {
		return escrowAgentFees;
	}

	public void setEscrowAgentFees(Double escrowAgentFees) {
		this.escrowAgentFees = escrowAgentFees;
	}

	public Date getLimitPaymentDate() {
		return LimitPaymentDate;
	}

	public void setLimitPaymentDate(Date limitPaymentDate) {
		LimitPaymentDate = limitPaymentDate;
	}

	public Integer getAgreementStatus() {
		return agreementStatus;
	}

	public void setAgreementStatus(Integer agreementStatus) {
		this.agreementStatus = agreementStatus;
	}

	public Date getAgreementDeadLine() {
		return agreementDeadLine;
	}

	public void setAgreementDeadLine(Date agreementDeadLine) {
		this.agreementDeadLine = agreementDeadLine;
	}

	public Date getAgreementDate() {
		return agreementDate;
	}

	public void setAgreementDate(Date agreementDate) {
		this.agreementDate = agreementDate;
	}

	public Double getReleaseFunds() {
		return releaseFunds;
	}

	public void setReleaseFunds(Double releaseFunds) {
		this.releaseFunds = releaseFunds;
	}
	
	

}
