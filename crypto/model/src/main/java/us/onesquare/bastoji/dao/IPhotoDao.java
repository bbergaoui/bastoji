package us.onesquare.bastoji.dao;

import java.util.List;
import java.util.UUID;

import us.onesquare.bastoji.model.photo.Photo;

public interface IPhotoDao {
	public Photo createPhoto(Photo photo);

	public Photo getPhoto(UUID id);

	public void updatePhoto(Photo photo);

	public void deletePhoto(UUID id);
	
	public void deleteAll();

	public List<Photo> getAllPhotos();

}
