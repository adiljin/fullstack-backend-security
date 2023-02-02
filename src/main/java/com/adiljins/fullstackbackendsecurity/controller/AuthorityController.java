package com.adiljins.fullstackbackendsecurity.controller;

import com.adiljins.fullstackbackendsecurity.exception.NotFoundException;
import com.adiljins.fullstackbackendsecurity.repository.AuthorityRepository;
import com.adiljins.fullstackbackendsecurity.security.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authority")
@CrossOrigin("http://localhost:3000/")
public class AuthorityController {

    @Autowired
    private AuthorityRepository authorityRepository;

    @PostMapping()
    Authority newAuthority(@RequestBody Authority newAuthority){
        return authorityRepository.save(newAuthority);
    }

    @GetMapping("/get")
    List<Authority> getAuthorities(){
        return authorityRepository.findAll();
    }

    @PutMapping("/{id}")
    Authority updateAuthority(@RequestBody Authority newAuthority, @PathVariable Long id){
        return authorityRepository.findById(id).map(authority->{
            authority.setUser(authority.getUser());
            authority.setAuthority(newAuthority.getAuthority());
            return authorityRepository.save(authority);
        }).orElseThrow(()->new NotFoundException(id));
    }

    @DeleteMapping("/{id}")
    String deleteAuthority(@PathVariable Long id){
        if(!authorityRepository.existsById(id)){
            throw new NotFoundException(id);
        }
        authorityRepository.deleteById(id);
        return "Authority with id " + id + " has been deleted";
    }

}
