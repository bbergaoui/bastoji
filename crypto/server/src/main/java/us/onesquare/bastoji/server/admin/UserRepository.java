package us.onesquare.bastoji.server.admin;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import us.onesquare.bastoji.model.admin.User;


@Repository("userRepository")
public interface UserRepository extends CassandraRepository<User,UUID> {
    User findByEmail(String email);
//    User findByConfirmationToken(String confirmationToken); 
   // User findByUsername(String username);


}
