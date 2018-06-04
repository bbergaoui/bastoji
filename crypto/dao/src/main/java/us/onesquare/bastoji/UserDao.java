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

import us.onesquare.bastoji.dao.IUserDao;
import us.onesquare.bastoji.model.admin.User;

@Component
public class UserDao implements IUserDao {
	
	
	@Autowired
	private Session session;
	
	
	
	@Autowired
	private CassandraOperations cassandraOperation;

	public static Cluster connect(String node) {
		return Cluster.builder().addContactPoint(node).build();
	}
	 


	@Override
	public User createUser(User user) {

		PreparedStatement prepared = session.prepare("insert into user (id, email, password) values (?, ? ,?)");

		BoundStatement bound = prepared.bind(UUID.randomUUID(), user.getEmail(), user.getPassword());
		session.execute(bound);
		return user;
	}

	@Override
	public User getUser(UUID id) {

		User u = (User) session.execute("select * from user where id=?", id);
		return u;

	}

	@Override
	public void updateUser(User user) {

		session.execute("update user set password=? ,email=? " + "  where id = ?", user.getPassword(), user.getEmail(),
				user.getId());

	}

	@Override

	public void deleteUsers(Collection<UUID> Users) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (UUID id : Users) {
			list.add(new Object[] { id });
		}
		session.execute("delete FROM user where id =?", list);
	}

	public void deleteUser(UUID id) {

		
		session.execute("delete FROM user where id =?",id);
	

	}

	@Override
	public List<User> getAllUsers() {
		return cassandraOperation.select("SELECT * FROM user" , User.class);
		
	}

	@Override
	public void deleteAll() {
		session.execute("delete FROM user ");
	}



	@Override
	public User findByUserNameAndPassword(String login, String password) {
		PreparedStatement prepared = session.prepare("insert into user (id, email, password) values (?, ? ,?)");
		BoundStatement bound = prepared.bind( login, password);
		return cassandraOperation.selectOne(bound, User.class);
		
	}

}
