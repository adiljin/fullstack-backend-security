package com.adiljins.fullstackbackendsecurity.controller;
import com.adiljins.fullstackbackendsecurity.exception.NotFoundException;
import com.adiljins.fullstackbackendsecurity.model.User;
import com.adiljins.fullstackbackendsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

    @Autowired
    private UserRepository userRepository;



    @PostMapping(path = "/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id).map(user -> {
            user.setUsername(newUser.getUsername());
            user.setPassword(newUser.getPassword());
            return userRepository.save(user);
        }).orElseThrow(()->new NotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if (!userRepository.existsById(id)){
            throw new NotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id " + id + " has been deleted";
    }
}
