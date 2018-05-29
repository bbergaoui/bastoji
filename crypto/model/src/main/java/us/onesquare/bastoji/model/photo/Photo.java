package us.onesquare.bastoji.model.photo;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;

public class Photo {
	@PrimaryKey
	private UUID id;

	private byte[] photo;

	private byte[] thumbnail;

	public Photo() {
	}

	public Photo(byte[] photo, byte[] thumbnail) {
		super();
		this.photo = photo;
		this.thumbnail = thumbnail;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public byte[] getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(byte[] thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
}
