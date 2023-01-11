package com.adiljins.fullstackbackendsecurity.repository.ship_repo;

import com.adiljins.fullstackbackendsecurity.model.ship.ports_3.Cruise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CruiseRepository extends JpaRepository<Cruise,Long> {
}
