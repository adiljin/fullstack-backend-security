package com.adiljins.fullstackbackendsecurity.controller;
import com.adiljins.fullstackbackendsecurity.exception.NotFoundException;
import com.adiljins.fullstackbackendsecurity.model.User;
import com.adiljins.fullstackbackendsecurity.repository.AuthorityRepository;
import com.adiljins.fullstackbackendsecurity.repository.UserRepository;
import com.adiljins.fullstackbackendsecurity.security.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:3000/")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityRepository authorityRepository;

    @PostMapping()
    void newUser(@RequestBody User newUser){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        userRepository.save(newUser);
        Authority authority = new Authority();
        authority.setAuthority("ROLE_STD");
        authority.setUser(newUser);
        authorityRepository.save(authority);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    @PutMapping("/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            return userRepository.save(user);
        }).orElseThrow(()->new NotFoundException(id));
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable Long id){
        if (!userRepository.existsById(id)){
            throw new NotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id " + id + " has been deleted";
    }
}
