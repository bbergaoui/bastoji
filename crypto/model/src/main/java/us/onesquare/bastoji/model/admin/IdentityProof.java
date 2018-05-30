package us.onesquare.bastoji.model.admin;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
@Table
public class IdentityProof {
	
	@PrimaryKey
	private UUID id;

	private Long userId;

	private String description;

	private byte[] proof;

	private byte[] thumbnail;

	public IdentityProof() {
	}

	public IdentityProof(byte[] proof, byte[] thumbnail) {
		super();
		this.proof = proof;
		this.thumbnail = thumbnail;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getProof() {
		return proof;
	}

	public void setProof(byte[] proof) {
		this.proof = proof;
	}

	public byte[] getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
}
