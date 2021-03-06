package by.slivki.trainings.service.impl;

import by.slivki.trainings.dao.api.UserRepository;
import by.slivki.trainings.dao.jpa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User activeUserInfo = userRepository.findByUsername(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole().getRoleName());
        return new org.springframework.security.core.userdetails.User(
                activeUserInfo.getUsername(),
                activeUserInfo.getPassword(),
                Collections.singletonList(authority));
    }
}
