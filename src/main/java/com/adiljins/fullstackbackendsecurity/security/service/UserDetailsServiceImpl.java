package com.adiljins.fullstackbackendsecurity.security.service;

import com.adiljins.fullstackbackendsecurity.exception.NotFoundException;
import com.adiljins.fullstackbackendsecurity.model.User;
//import com.adiljins.fullstackbackendsecurity.security.utility.CustomPasswordEncoder;
import com.adiljins.fullstackbackendsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//    @Autowired
//    private CustomPasswordEncoder customPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByUsername(username);
        return userOpt.orElseThrow(()-> new UsernameNotFoundException("Invalid credentials"));


//        User user = new User();
//        user.setId(1L);
//        user.setUsername(username);
////        String pass = customPasswordEncoder.getPasswordEncoder().encode("asd");
//        String pass = passwordEncoder().encode("asd");
//        System.out.println("CUSTOM " + pass);
//        user.setPassword(pass);
//        System.out.println("USER PASS: " + user.getPassword());
//        return user;
    }
}
