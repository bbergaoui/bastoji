package us.onesquare.bastoji.server.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;

import us.onesquare.bastoji.model.photo.Photo;
import us.onesquare.bastoji.server.photo.PhotoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PhotoController {

	@Autowired
	PhotoRepository photoRepository;

	@GetMapping("/photos")
	public List<Photo> getAllPhotos() {
		System.out.println("Get all Photos...");

		List<Photo> photos = new ArrayList<>();
		photoRepository.findAll().forEach(photos::add);
		return photos;
	}

	@PostMapping("/photos/create")
	public ResponseEntity<Photo> createPhoto(@Valid @RequestBody Photo photo) {
		System.out.println("Create Photo: " + photo.getThumbnail() + "...");

		photo.setId(UUIDs.timeBased());
		photo.getThumbnail();
		Photo _photo = photoRepository.save(photo);
		return new ResponseEntity<>(_photo, HttpStatus.OK);
	}

	@PutMapping("/photos/{id}")
	public ResponseEntity<Photo> updatePhoto(@PathVariable("id") UUID id, @RequestBody Photo photo) {
		System.out.println("Update photo with ID = " + id + "...");

		Photo photoData = photoRepository.findById(id).get();
		if (photoData == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		photoData.setPhoto(photo.getPhoto());
		photoData.setThumbnail(photo.getThumbnail());
		
		Photo updatedPhoto = photoRepository.save(photoData);
		return new ResponseEntity<>(updatedPhoto, HttpStatus.OK);
	}

	@DeleteMapping("/photos/{id}")
	public ResponseEntity<String> deletePhoto(@PathVariable("id") UUID id) {
		System.out.println("Delete Photo with ID = " + id + "...");

		photoRepository.delete(photoRepository.findById(id).get());

		return new ResponseEntity<>("Photo has been deleted!", HttpStatus.OK);
	}

	@DeleteMapping("/photos/delete")
	public ResponseEntity<String> deleteAllPhotos() {
		System.out.println("Delete All photos...");

		photoRepository.deleteAll();

		return new ResponseEntity<>("All photos have been deleted!", HttpStatus.OK);
	}
}
