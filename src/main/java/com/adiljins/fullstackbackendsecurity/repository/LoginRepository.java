package com.adiljins.fullstackbackendsecurity.repository;

import com.adiljins.fullstackbackendsecurity.model.login.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Long> {
}
