package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.UserDao;
import by.slivki.trainings.dao.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User activeUserInfo = userDao.findUserByUsername(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole().getRoleName());
        UserDetails userDetails =  new org.springframework.security.core.userdetails.User(
                activeUserInfo.getUsername(),
                activeUserInfo.getPassword(),
                Arrays.asList(authority));
        return userDetails;
    }
}
