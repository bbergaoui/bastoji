
package us.onesquare.bastoji.service;

import java.util.UUID;

import com.datastax.driver.core.ResultSet;

import us.onesquare.bastoji.model.admin.User;
public interface IUserDao {
	public User createUser(User user);

	public User getUser(UUID id);

	public User updateUser(User user);

	public void deleteUser(UUID id);
	
	public void deleteAll();

	public ResultSet getAllUsers();

}
