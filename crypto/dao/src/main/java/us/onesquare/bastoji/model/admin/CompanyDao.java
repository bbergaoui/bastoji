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

import us.onesquare.bastoji.dao.ICompanyDao;
import package us.onesquare.bastoji.model.admin;


@Component
public class CompanyDao implements ICompanyDao{
	
	
	@Autowired
	private Session session;
	
	
	
	@Autowired
	private CassandraOperations cassandraOperation;

	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
	}
	 


	@Override
	public Company createCompany(Company company) {

		PreparedStatement prepared = session.prepare("insert into company (id, email, password) values (?, ? ,?)");

		BoundStatement bound = prepared.bind(UUID.randomUUID(), company.getEmail(), company.getPassword());
		session.execute(bound);
		return company;
	}

	@Override
	public Company getCompany(UUID id) {

		Company u = (Company) session.execute("select * from company where id=?", id);
		return u;

	}

	@Override
	public void updateCompany(Company company) {

		session.execute("update company set password=? ,email=? " + "  where id = ?", company.getPassword(), company.getEmail(),
				company.getId());

	}

	@Override

	public void deleteCompanys(Collection<UUID> Companys) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (UUID id : Companys) {
			list.add(new Object[] { id });
		}
		session.execute("delete FROM company where id =?", list);
	}

	public void deleteCompany(UUID id) {

		
		session.execute("delete FROM company where id =?",id);
	

	}

	@Override
	public List<Company> getAllCompanies() {
		return cassandraOperation.select("SELECT * FROM company" , Company.class);
		
	}

	@Override
	public void deleteAll() {
		session.execute("delete FROM company ");
	}



	@Override
	public Company findByCompanyNameAndPassword(String login, String password) {
		PreparedStatement prepared = session.prepare("insert into company (id, email, password) values (?, ? ,?)");
		BoundStatement bound = prepared.bind( login, password);
		return cassandraOperation.selectOne(bound, Company.class);
		
	}

}
