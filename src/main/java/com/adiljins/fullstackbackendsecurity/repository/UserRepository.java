package com.adiljins.fullstackbackendsecurity.repository;

import com.adiljins.fullstackbackendsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
