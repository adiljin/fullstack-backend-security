package com.adiljins.fullstackbackendsecurity.security;

import com.adiljins.fullstackbackendsecurity.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serial;

@Entity
@Table(name="AUTH_TBL")
@Component
public class Authority implements GrantedAuthority {
//    @Serial
//    private static final long serialVersionUID = 8132219101674303151L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
    @ManyToOne(optional = false)
    private User user;
    private String authority;

    public Authority() {
    }

    public Authority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
