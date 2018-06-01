package us.onesquare.bastoji.server;


import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import us.onesquare.bastoji.model.Customer;
public interface CustomerRepository extends CassandraRepository<Customer,UUID> {

	

}
