package us.onesquare.bastoji.model.admin;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import us.onesquare.bastoji.model.utils.ApplicationAddress;
import us.onesquare.bastoji.model.utils.Gender;
import us.onesquare.bastoji.model.utils.TradingExperience;
@Table
public class Tiers {
	
	
	@PrimaryKey
	private UUID id;
	
	private String idCard;

	private String passport;

	private String firstName;

	private String lastName;

	private Date birthdate;

	private Gender gender;

	private UUID idPhoto;

	private UUID idAddress;

	private String email;

	private String function;

	private String facebook;

	private Integer idTradingExperience;

	private Date subscriptionDate;

	private String phoneNumber;

	private String idTax;
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public UUID getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(UUID idPhoto) {
		this.idPhoto = idPhoto;
	}
	
	public UUID getAddress() {
		return idAddress;
	}

	public void setAddress(UUID idaddress) {
		idAddress = idaddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public Integer getIdTradingExperience() {
		return idTradingExperience;
	}

	public void setIdTradingExperience(Integer idTradingExperience) {
		this.idTradingExperience = idTradingExperience;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getIdTax() {
		return idTax;
	}

	public void setIdTax(String idTax) {
		this.idTax = idTax;
	}



}
