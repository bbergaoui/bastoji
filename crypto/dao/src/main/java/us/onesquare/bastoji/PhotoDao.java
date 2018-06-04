package us.onesquare.bastoji;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
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

	@Autowired
	private CassandraOperations cassandraOperation;

	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
	}

	@Override
	public Photo createPhoto(Photo photo) {

		PreparedStatement prepared = session.prepare("insert into photo (id, photo,thumbnail) values (?, ? ,?)");

		BoundStatement bound = prepared.bind(UUID.randomUUID(), photo.getPhoto(), photo.getThumbnail());
		session.execute(bound);
		return photo;
	}

	@Override
	public Photo getPhoto(UUID id) {

		Photo u = (Photo) session.execute("select * from photo where id=?", id);
		return u;

	}

	@Override
	public void updatePhoto(Photo photo) {

		session.execute("update photo set photo=? , thumbnai=?   where id = ?", photo.getPhoto(), photo.getThumbnail(),
				photo.getId());

	}

	@Override

	public void deletePhotos(Collection<UUID> photos) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (UUID id : photos) {
			list.add(new Object[] { id });
		}
		session.execute("delete FROM photo where id =?", list);
	}

	public void deletePhoto(UUID id) {

		session.execute("delete FROM photo where id =?", id);

	}

	@Override
	public List<Photo> getAllPhotos() {
		return cassandraOperation.select("SELECT * FROM photo", Photo.class);

	}

	@Override
	public void deleteAll() {
		session.execute("delete FROM photo ");
	}
}
