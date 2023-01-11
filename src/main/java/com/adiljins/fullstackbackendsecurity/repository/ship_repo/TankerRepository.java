package com.adiljins.fullstackbackendsecurity.repository.ship_repo;

import com.adiljins.fullstackbackendsecurity.model.ship.ports_20.Tanker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TankerRepository extends JpaRepository<Tanker,Long> {
}
