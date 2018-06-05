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
import us.onesquare.bastoji.model.admin.Company;

@Component
public class CompanyDao implements ICompanyDao {

	@Autowired
	private Session session;

	@Autowired
	private CassandraOperations cassandraOperation;

	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
	}

	@Override
	public Company createCompany(Company company) {
		cassandraOperation.insert(company);
		return company;
	}

	@Override
	public Company getCompany(UUID id) {
		//Company u = (Company) session.execute("select * from company where id=?", id);
		return cassandraOperation.selectOneById(id, Company.class);

	}

	@Override
	public void updateCompany(Company company) {
		cassandraOperation.update(company);

//		session.execute(
//				"update company set  email=?, business_activity=?,capital=?,category_code=?,"
//						+ "category_label=?,company_id=?,company_name=?,company_type=?, "
//						+ "description=?,director=?,employees_number=?,founding_year=?,"
//						+ "id_address,id_contact_details=?,id_headquarter_address=?,id_tax=?,"
//						+ " is_address_validated=?,is_headquarter=?, is_identity_validated=?, is_phone_validated=?,"
//						+ " legal_immatriculation=?,id_logo=?,legal_name=?, legal_status=?,"
//						+ " legal_structure=?,phone_number=?,user_category=?,user_id=?,"
//						+ "web_site=?   where id = ?",
//				company.getEmail(), company.getBusinessActivity(), company.getCapital(), company.getCategoryCode(),
//				company.getCategoryLabel(), company.getCompanyId(), company.getCompanyName(), company.getCompanyType(),
//				company.getDescription(), company.getDirector(), company.getEmployeesNumber(),company.getFoundingYear(),
//				company.getIdAddress(), company.getIdContactDetails(),company.getIdHeadQuarterAddress(), company.getIdTax(),
//				company.getIsAddressValidated(),company.getIsHeadquarters(), company.getIsIdentityValidated(), company.getIsPhoneValidated(),
//				company.getLegalImmatriculation(), company.getIdLogo(), company.getLegalName(),company.getLegalStatus(),
//				company.getLegalStructure(), company.getPhoneNumber(),company.getUserCategory(), company.getUserId(), 
//				company.getWebSite(), company.getId());

	}

	@Override

	public void deleteCompanies(Collection<UUID> companies) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (UUID id : companies) {
			list.add(new Object[] { id });
		}
		cassandraOperation.delete(list);
	}

	public void deleteCompany(UUID id) {

		cassandraOperation.deleteById(id, Company.class);

	}

	@Override
	public List<Company> getAllCompanies() {

		return cassandraOperation.select("SELECT * FROM company", Company.class);

	}

	@Override
	public void deleteAll() {
		
		session.execute("delete FROM company ");
	}

}
