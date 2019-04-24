package org.ebullq.service;

import org.ebullq.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    public UserService userService;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getUserByLogin(login);
        if(user==null){
            throw new UsernameNotFoundException(login);
        }
        return user;
    }
}
