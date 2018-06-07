package us.onesquare.bastoji.model.exchange;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class AgreementWithoutEscrow {

	@PrimaryKey
	private UUID id;

	private Long idProvider;

	private Long idBeneficiary;

	private Double funds;

	private Integer agreementStatus;

	private Date agreementDeadLine;

	private String fundsCurrency;

	private Double releaseFunds;

	private String releaseFundsCurrency;

	private String releaseConditions;

	private Date LimitPaymentDate;

	private Date agreementDate;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(Long idProvider) {
		this.idProvider = idProvider;
	}

	public Long getIdBeneficiary() {
		return idBeneficiary;
	}

	public void setIdBeneficiary(Long idBeneficiary) {
		this.idBeneficiary = idBeneficiary;
	}

	public Double getFunds() {
		return funds;
	}

	public void setFunds(Double funds) {
		this.funds = funds;
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

	public String getFundsCurrency() {
		return fundsCurrency;
	}

	public void setFundsCurrency(String fundsCurrency) {
		this.fundsCurrency = fundsCurrency;
	}

	public Double getReleaseFunds() {
		return releaseFunds;
	}

	public void setReleaseFunds(Double releaseFunds) {
		this.releaseFunds = releaseFunds;
	}

	public String getReleaseFundsCurrency() {
		return releaseFundsCurrency;
	}

	public void setReleaseFundsCurrency(String releaseFundsCurrency) {
		this.releaseFundsCurrency = releaseFundsCurrency;
	}

	public String getReleaseConditions() {
		return releaseConditions;
	}

	public void setReleaseConditions(String releaseConditions) {
		this.releaseConditions = releaseConditions;
	}

	public Date getLimitPaymentDate() {
		return LimitPaymentDate;
	}

	public void setLimitPaymentDate(Date limitPaymentDate) {
		LimitPaymentDate = limitPaymentDate;
	}

	public Date getAgreementDate() {
		return agreementDate;
	}

	public void setAgreementDate(Date agreementDate) {
		this.agreementDate = agreementDate;
	}
	

}
