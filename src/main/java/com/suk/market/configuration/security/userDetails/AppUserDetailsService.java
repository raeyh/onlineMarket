package com.suk.market.configuration.security.userDetails;

import com.suk.market.domain.User;
import com.suk.market.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AppUserDetailsService implements UserDetailsService {
   @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(s);
        user.orElseThrow(()->new UsernameNotFoundException("UserName not Found"));

        return new AppUserDetails(user.get());
    }
}
