package us.onesquare.bastoji.model.subscription;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("registration")
public class Registration {

	@PrimaryKey("id")
	private UUID id;

	@Column("email")
	private String email;

	private String password;

	private Boolean isCompany;

	private String companyEmail;

	private String country;
	private String streetNumber;
	private String streetName;
	private String postalCode;
	private String city;

	private String companyName;

	private String companyId;

	private String firstName;

	private String lastName;

	private Boolean enabled;

	private String phoneNumber;

	private String mailConfirmationToken;
	
	private String phoneConfirmationToken;



	public String getMailConfirmationToken() {
		return mailConfirmationToken;
	}

	public void setMailConfirmationToken(String mailConfirmationToken) {
		this.mailConfirmationToken = mailConfirmationToken;
	}

	public String getPhoneConfirmationToken() {
		return phoneConfirmationToken;
	}

	public void setPhoneConfirmationToken(String phoneConfirmationToken) {
		this.phoneConfirmationToken = phoneConfirmationToken;
	}

	private Date subscriptionDate;

	public Registration() {
	}

	public Registration(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean value) {
		this.enabled = value;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public Boolean getIsCompany() {
		return isCompany;
	}

	public void setIsCompany(Boolean isCompany) {
		this.isCompany = isCompany;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", name=" + firstName + " " + lastName + ", email=" + email + ", password="
				+ password + "]";
	}
}
