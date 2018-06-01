
package us.onesquare.bastoji.service;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import us.onesquare.bastoji.model.admin.User;

public interface IUserDao {
	public User createUser(User user);

	public User getUser(UUID id);

	public void updateUser(User user);

	public void deleteUser(UUID id);

	
	public void deleteAll();


	public List<User> getAllUsers();

	void deleteUsers(Collection<UUID> Users);

}
