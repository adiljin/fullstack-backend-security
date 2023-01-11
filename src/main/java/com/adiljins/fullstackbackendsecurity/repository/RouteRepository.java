package com.adiljins.fullstackbackendsecurity.repository;

import com.adiljins.fullstackbackendsecurity.model.routes_management.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route,Long> {
}
