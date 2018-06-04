package us.onesquare.bastoji;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;

import us.onesquare.bastoji.dao.IPhotoDao;
import us.onesquare.bastoji.model.photo.Photo;


@Component
public class PhotoDao implements IPhotoDao {
	
	@Autowired
	private Session session;
	

	@Override
	public Photo createPhoto(Photo photo) {
		System.out.println("\n*********Insert User Data *************");

		PreparedStatement prepared = session.prepare("insert into photo (id,  photo, thumbnail) values (?, ? ,?)");

		BoundStatement bound = prepared.bind(UUID.randomUUID(), photo.getPhoto(), photo.getThumbnail());
		session.execute(bound);
		return photo;
	}

	@Override
	public Photo getPhoto(UUID id) {
		Photo t = (Photo) session.execute("select * from photo where id=?", id);
		return t;
	}

	@Override
	public void updatePhoto(Photo photo) {
		session.execute("update photo set photo=? ,thumbnail=?  " + "  where id = ?", photo.getPhoto(),
				photo.getThumbnail());

		//return photo;
	}

	@Override
	public void deletePhoto(UUID id) {
		session.execute("delete FROM photo where id =?");

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Photo> getAllPhotos() {
		List list = (List) session.execute("SELECT * FROM photo");

		return list;
	}

}
