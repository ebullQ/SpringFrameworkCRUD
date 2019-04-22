package org.ebullq.util;

import org.ebullq.model.User;
import org.ebullq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    @Autowired
    private UserService service;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        User user = service.getUserByLogin(login);
        if(user == null)
            throw new UsernameNotFoundException("User haven't been found");
        String password = authentication.getCredentials().toString();
        if(!password.equals(user.getPassword()))
            throw new BadCredentialsException("Bad credentials");
        Collection<? extends GrantedAuthority> authorities = user.getAuthority();
        return new UsernamePasswordAuthenticationToken(user,null,authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
       return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
