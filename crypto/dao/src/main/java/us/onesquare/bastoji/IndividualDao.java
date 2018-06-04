package us.onesquare.bastoji;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import us.onesquare.bastoji.dao.IIndividualDao;
import us.onesquare.bastoji.model.admin.Individual;


@Component
public class IndividualDao  implements IIndividualDao{
	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
	}

	public static void main(String[] args) {
		// Connect to the cluster and keyspace "devjavasource"
		final Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
		final Session session = cluster.connect("javasampleapproach");

		// Retrieve all User details from Users table
		System.out.println("\n*********Retrive User Data Example *************");
		getUsersAllDetails(session);

		// Insert new User into users table
		System.out.println("\n*********Insert User Data Example *************");

		PreparedStatement prepared = session.prepare("insert into Individual (id, idUser,idTiers,isIdentityValidated,isAddressValidated,isPhoneValidated, userCategory) values (?, ? ,?,?, ? ,?,?)");

		BoundStatement bound = prepared.bind(UUID.randomUUID(),1,2 ,true,false,true,"INDIVIDUAL");
		session.execute(bound);

		getUsersAllDetails(session);

		// Update user data in users table
		System.out.println("\n*********Update User Data Example *************");
		session.execute("update Individual set idTiers=2  where isIdentityValidated = true");
		getUsersAllDetails(session);

		// Delete user from users table
		System.out.println("\n*********Delete User Data Example *************");
		session.execute("delete FROM Individual where idTiers=2");
		getUsersAllDetails(session);

	}

	private static void getUsersAllDetails(final Session inSession) {
		// Use select to get the users table data
		ResultSet results = inSession.execute("SELECT * FROM Individual");
		for (Row row : results) {
			System.out.format("%s %s %s %s %s %s %s \n", row.getUUID("id"), row.getLong("idUser"), row.getLong("idTiers") ,row.getBool("isIdentityValidated"), row.getBool("isAddressValidated"),row.getBool("isPhoneValidated"), row.getString ("userCategory"));
		}
	}

	@Override
	public Individual createIndividual(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Individual getIndividual(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateIndividual(Individual individual) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteIndividual(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Individual> getAllIndividuals() {
		// TODO Auto-generated method stub
		return null;
	}

}

