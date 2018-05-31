package us.onesquare.bastoji.server.subscription;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import us.onesquare.bastoji.model.subscription.Registration;
@Repository("registrationRepository")
public interface RegistrationRepository extends CassandraRepository<Registration,UUID> {
	Registration findByEmail(String email);
	Registration findByConfirmationToken(String confirmationToken); 
   // User findByUsername(String username);


}
