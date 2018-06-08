
package us.onesquare.bastoji.dao;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
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

	public User findByUserNameAndPassword(String login, String password);

    Optional<User> retrieveUser(String username);
}
