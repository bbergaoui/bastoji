package us.onesquare.bastoji.model.admin;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

public class Individual {
	
	@PrimaryKey
	private UUID id;

	private Long idUser; 
	
	private Long idTiers;
	
	private Boolean isIdentityValidated;
	
	private Boolean isAddressValidated;

	private Boolean isPhoneValidated;
	
	private UserCategory userCategory=UserCategory.INDIVIDUAL;
	
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	
	public UserCategory getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(UserCategory userCategory) {
		this.userCategory = userCategory;
	}

	public Long getIdTiers() {
		return idTiers;
	}

	public void setIdTiers(Long idTiers) {
		this.idTiers = idTiers;
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


	
	
	
	

}
