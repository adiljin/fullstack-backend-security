package com.adiljins.fullstackbackendsecurity.controller;
import com.adiljins.fullstackbackendsecurity.exception.NotFoundException;
import com.adiljins.fullstackbackendsecurity.model.User;
import com.adiljins.fullstackbackendsecurity.repository.AuthorityRepository;
import com.adiljins.fullstackbackendsecurity.repository.UserRepository;
import com.adiljins.fullstackbackendsecurity.security.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    ResponseEntity<Object> newUser(@RequestBody User newUser){
        try{
            if (!userRepository.findByUsername(newUser.getUsername()).isPresent()){
                PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String encodedPassword = passwordEncoder.encode(newUser.getPassword());
                newUser.setPassword(encodedPassword);
                userRepository.save(newUser);
                Authority authority = new Authority();
                authority.setAuthority("ROLE_STD");
                authority.setUser(newUser);
                authorityRepository.save(authority);
                return ResponseEntity.ok().build();
            }else{
                throw new UsernameNotFoundException("This username already exist");
            }
        }catch (UsernameNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
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
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(newUser.getPassword());
            user.setPassword(encodedPassword);
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
