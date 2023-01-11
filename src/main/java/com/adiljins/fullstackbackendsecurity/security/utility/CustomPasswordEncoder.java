//package com.adiljins.fullstackbackendsecurity.security.utility;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CustomPasswordEncoder {
//    private PasswordEncoder passwordEncoder;
//
//    public CustomPasswordEncoder(){
//        this.passwordEncoder = new BCryptPasswordEncoder();
//        System.out.println("CREATED " + this.passwordEncoder);
//    }
//
//    public PasswordEncoder getPasswordEncoder() {
//        System.out.println("RETURNING " + this.passwordEncoder);
//        return this.passwordEncoder;
//    }
//}
