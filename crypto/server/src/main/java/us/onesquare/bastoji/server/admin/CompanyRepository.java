package us.onesquare.bastoji.server.admin;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import us.onesquare.bastoji.model.admin.Company;

@Repository("companyRepository")
public interface CompanyRepository  extends CassandraRepository<Company,UUID>{
    Company findByEmail(String email);
}
