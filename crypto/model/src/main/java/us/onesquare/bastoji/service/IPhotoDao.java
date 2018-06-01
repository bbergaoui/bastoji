package us.onesquare.bastoji.service;

import java.util.List;
import java.util.UUID;

import us.onesquare.bastoji.model.photo.Photo;

public interface IPhotoDao {
	public Photo createPhoto(Photo photo);

	public Photo getPhoto(UUID id);

	public Photo updatePhoto(Photo photo);

	public void deletePhoto(UUID id);
	
	public void deleteAll();

	public List<Photo> getAllPhotos();

}
