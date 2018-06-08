package us.onesquare.bastoji.model.admin;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;

public class CryptoUserDetails extends org.springframework.security.core.userdetails.User{


    public CryptoUserDetails(User user) {
        this(user.getEmail(),user.getPassword(),new ArrayList<>());
    }

    public CryptoUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    @Override
    public String toString() {
        return "CryptoUserDetails{}" + getUsername() + " " + getPassword() + " " + getAuthorities();
    }
}
