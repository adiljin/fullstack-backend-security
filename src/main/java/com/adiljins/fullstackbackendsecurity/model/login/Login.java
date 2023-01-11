package com.adiljins.fullstackbackendsecurity.model.login;

import org.springframework.stereotype.Component;
import javax.persistence.*;

@Entity
@Table(name = "LOGIN_TBL")
@Component
public class Login {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
