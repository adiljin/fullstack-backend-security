package com.adiljins.fullstackbackendsecurity.repository.ship_repo;

import com.adiljins.fullstackbackendsecurity.model.ship.ports_10.Tugboat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TugboatRepository extends JpaRepository<Tugboat,Long>  {
}
