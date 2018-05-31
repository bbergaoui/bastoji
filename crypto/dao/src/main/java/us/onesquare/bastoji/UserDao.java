package us.onesquare.bastoji;

import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class UserDao {

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

		PreparedStatement prepared = session.prepare("insert into user (id, email, password) values (?, ? ,?)");

		BoundStatement bound = prepared.bind(UUID.randomUUID(), "bitcoin@crypto.tn", "123456");
		session.execute(bound);

		getUsersAllDetails(session);

		// Update user data in users table
		System.out.println("\n*********Update User Data Example *************");
		session.execute("update user set password='updated'  where id = 2e962170-63ed-11e8-949c-310409812985");
		getUsersAllDetails(session);

		// Delete user from users table
		System.out.println("\n*********Delete User Data Example *************");
		session.execute("delete FROM user where id = 9be87a4a-a3ba-4edd-b90d-116179d4fc1c");
		getUsersAllDetails(session);

	}

	private static void getUsersAllDetails(final Session inSession) {
		// Use select to get the users table data
		ResultSet results = inSession.execute("SELECT * FROM user");
		for (Row row : results) {
			System.out.format("%s %s %s\n", row.getUUID("id"), row.getString("email"), row.getString("password"));
		}
	}

}
