package com.suk.market.configuration.security;

import com.suk.market.domain.User;
import com.suk.market.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class LoginUserDetailsService implements UserDetailsService
{
    private final UserService userService;

    @Autowired
    public LoginUserDetailsService(UserService userService)
    {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userService.getUserByUsername(username);
        if(user != null)
        {
            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
            return builder.password(user.getPassword()).authorities(user.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                    .collect(Collectors.toList())).build();
        }
        else throw new UsernameNotFoundException("Username not found for user "+username);
    }
}
