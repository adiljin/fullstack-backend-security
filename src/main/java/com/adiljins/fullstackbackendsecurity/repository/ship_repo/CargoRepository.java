package com.adiljins.fullstackbackendsecurity.repository.ship_repo;

import com.adiljins.fullstackbackendsecurity.model.ship.ports_10.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo,Long> {
}
