package us.onesquare.bastoji.model.admin;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import us.onesquare.bastoji.model.utils.ApplicationAddress;
import us.onesquare.bastoji.model.utils.UserCategory;

@Table
public class Company {
	@PrimaryKey
	private UUID id;

	private Long userId;

	private Long idContactDetails; // foreign key table tiers

	private Long idLogo;

	private String email;

	private String companyId;

	private Long  idAddress;

	private String idTax;

	private String companyName;

	private String phoneNumber;

	private String description;

	private Date foundingYear;

	private String businessActivity;

	private String companyType;

	private Boolean isIdentityValidated;

	private Boolean isAddressValidated;

	private Integer userCategory =2;

	private Boolean isPhoneValidated;

	private Double capital;

	private Integer employeesNumber;

	private String legalStatus;

	private String webSite;

	private Long idHeadQuarterAddress;

	private String director;
	
	private String legalImmatriculation;

	private Boolean isHeadquarters;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getIdContactDetails() {
		return idContactDetails;
	}

	public void setIdContactDetails(Long idContactDetails) {
		this.idContactDetails = idContactDetails;
	}

	public Long getIdLogo() {
		return idLogo;
	}

	public void setIdLogo(Long idLogo) {
		this.idLogo = idLogo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Long getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(Long idAddress) {
		this.idAddress = idAddress;
	}

	public String getIdTax() {
		return idTax;
	}

	public void setIdTax(String idTax) {
		this.idTax = idTax;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getFoundingYear() {
		return foundingYear;
	}

	public void setFoundingYear(Date foundingYear) {
		this.foundingYear = foundingYear;
	}

	public String getBusinessActivity() {
		return businessActivity;
	}

	public void setBusinessActivity(String businessActivity) {
		this.businessActivity = businessActivity;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public Boolean getIsIdentityValidated() {
		return isIdentityValidated;
	}

	public void setIsIdentityValidated(Boolean isIdentityValidated) {
		this.isIdentityValidated = isIdentityValidated;
	}

	public Boolean getIsAddressValidated() {
		return isAddressValidated;
	}

	public void setIsAddressValidated(Boolean isAddressValidated) {
		this.isAddressValidated = isAddressValidated;
	}



	public Boolean getIsPhoneValidated() {
		return isPhoneValidated;
	}

	public void setIsPhoneValidated(Boolean isPhoneValidated) {
		this.isPhoneValidated = isPhoneValidated;
	}

	public Double getCapital() {
		return capital;
	}

	public void setCapital(Double capital) {
		this.capital = capital;
	}

	public Integer getEmployeesNumber() {
		return employeesNumber;
	}

	public void setEmployeesNumber(Integer employeesNumber) {
		this.employeesNumber = employeesNumber;
	}

	public String getLegalStatus() {
		return legalStatus;
	}

	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	

	public String getDirector() {
		return director;
	}

	public Integer getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(Integer userCategory) {
		this.userCategory = userCategory;
	}

	public Long getIdHeadQuarterAddress() {
		return idHeadQuarterAddress;
	}

	public void setIdHeadQuarterAddress(Long idHeadQuarterAddress) {
		this.idHeadQuarterAddress = idHeadQuarterAddress;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getLegalImmatriculation() {
		return legalImmatriculation;
	}

	public void setLegalImmatriculation(String legalImmatriculation) {
		this.legalImmatriculation = legalImmatriculation;
	}

	public Boolean getIsHeadquarters() {
		return isHeadquarters;
	}

	public void setIsHeadquarters(Boolean isHeadquarters) {
		this.isHeadquarters = isHeadquarters;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getLegalStructure() {
		return legalStructure;
	}

	public void setLegalStructure(String legalStructure) {
		this.legalStructure = legalStructure;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryLabel() {
		return categoryLabel;
	}

	public void setCategoryLabel(String categoryLabel) {
		this.categoryLabel = categoryLabel;
	}

	public String getLegalIsNonprofit() {
		return legalIsNonprofit;
	}

	public void setLegalIsNonprofit(String legalIsNonprofit) {
		this.legalIsNonprofit = legalIsNonprofit;
	}

	private String legalName;

	private String legalStructure;
	
	private String categoryCode;
	
	private String categoryLabel;

	private String legalIsNonprofit;

	
}
