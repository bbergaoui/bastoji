
package us.onesquare.bastoji.service;

import java.util.List;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

import us.onesquare.bastoji.model.admin.User;
public interface IUserDao {
	public User createUser(User user);

	public User getUser(int id);

	public User updateUser(User user);

	public void deleteUser(int id);

	public ResultSet getAllUsers( Session inSession);

}
