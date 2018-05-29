package us.onesquare.bastoji.model.admin;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

public class Individual {
	
	@PrimaryKey
	private UUID id;

	private Long idUser; 
	
	private Long idTiers;
	
	
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


	
	
	
	

}
