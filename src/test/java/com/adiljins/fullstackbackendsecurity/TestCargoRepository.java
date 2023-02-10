package com.adiljins.fullstackbackendsecurity;


import com.adiljins.fullstackbackendsecurity.model.essential.Customer;
import com.adiljins.fullstackbackendsecurity.model.ship.ports_10.Cargo;
import com.adiljins.fullstackbackendsecurity.repository.ship_repo.CargoRepository;
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
public class TestCargoRepository {

    @Mock
    private CargoRepository cargoRepository;

    private Cargo cargo;

    @Before
    public void setUp() {
        cargo = new Cargo();
        cargo.setCompany("Zero Company");
        cargo.setAddress("123 Main St");
        cargo.setNumber("555-555-5555");
        cargo.setEmail("zero.company@email.com");
    }

    @Test
    public void testGetCargoByIdSuccess() {
        when(cargoRepository.findById(1L)).thenReturn(java.util.Optional.of(cargo));
        Optional<Cargo> result = cargoRepository.findById(1L);
        assertThat(result.get()).isEqualTo(cargo);
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

