package us.onesquare.bastoji.server.photo;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import us.onesquare.bastoji.model.photo.Photo;

@Repository("photoRepository")
public interface PhotoRepository extends CassandraRepository<Photo,UUID> {

}
