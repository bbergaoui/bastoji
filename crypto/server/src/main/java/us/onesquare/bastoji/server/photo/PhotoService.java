package us.onesquare.bastoji.server.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import us.onesquare.bastoji.model.photo.Photo;

@Service
public class PhotoService {
	private PhotoRepository photoRepository;

	@Autowired
    public void PhotoRepository(PhotoRepository photoRepository) { 
      this.photoRepository = photoRepository;
    }

	public void savePhoto(Photo photo) {
		photoRepository.save(photo);
	}

}
