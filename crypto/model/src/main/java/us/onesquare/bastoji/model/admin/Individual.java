package us.onesquare.bastoji.model.admin;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import us.onesquare.bastoji.model.utils.UserCategory;
@Table
public class Individual {
	
	@PrimaryKey
	private UUID id;

	private UUID idUser; 
	
	private UUID idTiers;
	
	private Boolean isIdentityValidated;
	
	private Boolean isAddressValidated;

	private Boolean isPhoneValidated;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getIdUser() {
		return idUser;
	}

	public void setIdUser(UUID idUser) {
		this.idUser = idUser;
	}

	
	public UUID getIdTiers() {
		return idTiers;
	}

	public void setIdTiers(UUID idTiers) {
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
