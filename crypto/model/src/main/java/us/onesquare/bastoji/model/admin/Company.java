package us.onesquare.bastoji.model.admin;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
@Table
public class Company {

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

	public String getHeadOfficeAddress() {
		return headOfficeAddress;
	}

	public void setHeadOfficeAddress(String headOfficeAddress) {
		this.headOfficeAddress = headOfficeAddress;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@PrimaryKey
	private UUID id;

	private Long userId;

	private Long idContactDetails; // foreign key table tiers

	private Long idLogo;

	private String email;

	private String companyId;

	private String address;

	private String idTax;

	private String companyName;

	private String phoneNumber;

	private String description;

	private Date creationDate;

	private String businessActivity;

	private String companyType;
	
	private Boolean isIdentityValidated;
	
	private Boolean isAddressValidated;

	private UserCategory userCategory = UserCategory.COMPANY;
	
	private Boolean isPhoneValidated;
	
	private Double capital;
	
	private Integer employeesNumber;
	
	private String legalStatus;
	
	private String webSite;
	
	private String headOfficeAddress;

	private String director;
	
	
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Long getIdContactDetails() {
		return idContactDetails;
	}

	public void setIdContactDetails(Long idContactDetails) {
		this.idContactDetails = idContactDetails;
	}

	public UserCategory getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(UserCategory userCategory) {
		this.userCategory = userCategory;
	}

	public Long getIdLogo() {
		return idLogo;
	}

	public void setIdLogo(Long idLogo) {
		this.idLogo = idLogo;
	}

	public Boolean getIsPhoneValidated() {
		return isPhoneValidated;
	}

	public void setIsPhoneValidated(Boolean isPhoneValidated) {
		this.isPhoneValidated = isPhoneValidated;
	}

}
