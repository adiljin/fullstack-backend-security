package com.adiljins.fullstackbackendsecurity.repository.ship_repo;

import com.adiljins.fullstackbackendsecurity.model.ship.ports_20.Barge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BargeRepository extends JpaRepository<Barge,Long> {
}
