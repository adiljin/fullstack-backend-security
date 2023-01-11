package com.adiljins.fullstackbackendsecurity.controller.shipController;


import com.adiljins.fullstackbackendsecurity.exception.NotFoundException;
import com.adiljins.fullstackbackendsecurity.model.ship.ports_10.Cargo;
import com.adiljins.fullstackbackendsecurity.repository.ship_repo.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargo")
@CrossOrigin("http://localhost:3000/")
public class CargoController {

    @Autowired
    private CargoRepository cargoRepository;

    @PostMapping
    Cargo newCargo(@RequestBody Cargo newCargo){
        newCargo.generatePrice();
        return cargoRepository.save(newCargo);
    }

    @GetMapping("/cargos")
    List<Cargo> cargos(){return cargoRepository.findAll();}

    @GetMapping("/cargos/{id}")
    Cargo getCargoById(@PathVariable Long id){
        return cargoRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    @PutMapping("/{id}")
    Cargo updateCargo(@RequestBody Cargo newCargo,@PathVariable Long id){
        return cargoRepository.findById(id).map(cargo -> {
            cargo.setCompany(newCargo.getCompany());
            cargo.setAddress(newCargo.getAddress());
            cargo.setNumber(newCargo.getNumber());
            cargo.setEmail(newCargo.getEmail());
            return cargoRepository.save(cargo);
        }).orElseThrow(()->new NotFoundException(id));
    }
    @DeleteMapping("/del/{id}")
    String deleteCargo(@PathVariable Long id){
        if(!cargoRepository.existsById(id)){
            throw new NotFoundException(id);
        }
        cargoRepository.deleteById(id);
        return "Cargo with id " + id + " has been deleted";
    }
}
