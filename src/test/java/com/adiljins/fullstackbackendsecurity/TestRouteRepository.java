package com.adiljins.fullstackbackendsecurity;

import com.adiljins.fullstackbackendsecurity.model.routes_management.Route;
import com.adiljins.fullstackbackendsecurity.repository.RouteRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import org.junit.After;
import org.junit.AfterClass;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class TestRouteRepository {

    @Mock
    private RouteRepository routeRepository;

    private Route route;

    @Before
    public void setUp() {
        route = new Route();
        route.setPortName("New York");
        route.setPriceFrom(100);
    }

    @Test
    public void testGetCargoByIdSuccess() {
        when(routeRepository.findById(1L)).thenReturn(java.util.Optional.of(route));
        Optional<Route> result = routeRepository.findById(1L);
        assertThat(result.get()).isEqualTo(route);
    }

    @After
    public void after() {
        System.out.println("After Test Case");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }

}
