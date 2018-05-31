package us.onesquare.bastoji.server.admin;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import us.onesquare.bastoji.model.admin.IdentityProof;

@Repository("identityProofRepository")
public interface IdentityProofRepository extends CassandraRepository<IdentityProof,UUID> {

}
