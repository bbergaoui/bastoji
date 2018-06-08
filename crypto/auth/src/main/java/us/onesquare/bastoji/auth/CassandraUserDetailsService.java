package us.onesquare.bastoji.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import us.onesquare.bastoji.UserDao;
import us.onesquare.bastoji.dao.IUserDao;
import us.onesquare.bastoji.model.admin.CryptoUserDetails;
import us.onesquare.bastoji.model.admin.User;

import java.util.logging.Logger;


@Component
public class CassandraUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserDao auctionUserDao;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = auctionUserDao.retrieveUser(username).orElseThrow(() -> new UsernameNotFoundException(username));
        Logger.getLogger("user.details").warning("username -> " + user.getEmail() + " password -> " + user.getPassword());
        return new CryptoUserDetails(user);
    }
}