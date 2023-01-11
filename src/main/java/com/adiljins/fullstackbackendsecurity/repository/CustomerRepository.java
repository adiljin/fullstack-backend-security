package com.adiljins.fullstackbackendsecurity.repository;

import com.adiljins.fullstackbackendsecurity.model.essential.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
