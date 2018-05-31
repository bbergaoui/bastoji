package us.onesquare.bastoji;

import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

import us.onesquare.bastoji.model.admin.User;
import us.onesquare.bastoji.service.IUserDao;

public class UserDao  implements IUserDao{
	final Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
	final Session session = cluster.connect("javasampleapproach");
	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
		
	}


	@Override
	public User createUser(User user) {
		System.out.println("\n*********Insert User Data Example *************");

		PreparedStatement prepared = session.prepare("insert into user (id, email, password) values (?, ? ,?)");

		BoundStatement bound = prepared.bind(UUID.randomUUID(), "bitcoin@crypto.tn", "123456");
		session.execute(bound);
           return user ;
	}

	@Override
	public User getUser(int id) {
		return null;
		
	}

	@Override
	public User updateUser(User user) {
		
		session.execute("update user set password='updated'  where id = 2e962170-63ed-11e8-949c-310409812985");
		return user ;
	}

	@Override
	public void deleteUser(int id) {
		System.out.println("\n*********Delete User Data  *************");
		session.execute("delete FROM user where id = 9be87a4a-a3ba-4edd-b90d-116179d4fc1c");
		
	}

	@Override
	public ResultSet getAllUsers(final Session inSession) {
		
		 ResultSet list= inSession.execute("SELECT * FROM user");
		
		
		return list;
	}

}
