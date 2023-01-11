package com.adiljins.fullstackbackendsecurity.repository.ship_repo;

import com.adiljins.fullstackbackendsecurity.model.ship.ports_20.Container;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainerRepository extends JpaRepository<Container,Long> {
}
