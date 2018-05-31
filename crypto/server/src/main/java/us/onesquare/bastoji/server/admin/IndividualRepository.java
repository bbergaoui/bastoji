package us.onesquare.bastoji.server.admin;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import us.onesquare.bastoji.model.admin.Individual;

@Repository("individualRepository")
public interface IndividualRepository  extends CassandraRepository<Individual,UUID>{
}
