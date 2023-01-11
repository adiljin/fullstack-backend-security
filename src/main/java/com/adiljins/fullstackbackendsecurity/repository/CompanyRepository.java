package com.adiljins.fullstackbackendsecurity.repository;

import com.adiljins.fullstackbackendsecurity.model.essential.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    List<Company> findByNameContaining(String name);
}
