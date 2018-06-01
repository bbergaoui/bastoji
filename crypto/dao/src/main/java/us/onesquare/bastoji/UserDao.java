package us.onesquare.bastoji;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

		BoundStatement bound = prepared.bind(UUID.randomUUID(), user.getEmail(), user.getPassword());
		session.execute(bound);
           return user ;
	}

	@Override
	public User getUser(UUID id) {


		User u =(User) session.execute("select * from user where id=?" , id);
		return u ;
	

		
	}

	@Override
	public void updateUser(User user) {
		
		session.execute("update user set password=? ,email=? " + "  where id = ?" ,user.getPassword(),user.getEmail(),user.getId());
		
	
	}

	@Override

	public void deleteUsers(Collection<UUID> Users) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (UUID id : Users) {
			list.add(new Object[] { id });
		}
		session.execute("delete FROM user where id =?"  ,list);
	}
		

	public void deleteUser(UUID id) {

		System.out.println("\n*********Delete User Data  *************");
//		session.execute("delete FROM user where id = 9be87a4a-a3ba-4edd-b90d-116179d4fc1c");
		
		
	

	}

	@Override
	public ResultSet getAllUsers() {
		
		 ResultSet list= session.execute("SELECT * FROM user");
		
		
		return list;
	}


	@Override
	public void deleteAll() {
		
	}

}
