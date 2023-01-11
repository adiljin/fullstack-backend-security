package com.adiljins.fullstackbackendsecurity.controller.shipController;

import com.adiljins.fullstackbackendsecurity.exception.NotFoundException;
import com.adiljins.fullstackbackendsecurity.model.ship.ports_20.Container;
import com.adiljins.fullstackbackendsecurity.repository.ship_repo.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/container")
@CrossOrigin("http://localhost:3000/")
public class ContainerController {

    @Autowired
    private ContainerRepository containerRepository;

    @PostMapping
    Container newContainer(@RequestBody Container newContainer){
        newContainer.generatePrice();
        return containerRepository.save(newContainer);
    }

    @GetMapping("/containers")
    List<Container> getAllContainers(){return containerRepository.findAll();}

    @GetMapping("/containers/{id}")
    Container getContainerById(@PathVariable Long id){
        return containerRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    @PutMapping("/{id}")
    Container updateContainer(@RequestBody Container newContainer,@PathVariable Long id){
        return containerRepository.findById(id).map(container -> {
            container.setCompany(newContainer.getCompany());
            container.setAddress(newContainer.getAddress());
            container.setNumber(newContainer.getNumber());
            container.setEmail(newContainer.getEmail());
            return containerRepository.save(container);
        }).orElseThrow(()->new NotFoundException(id));
    }

    @DeleteMapping("/del/{id}")
    String deleteContainer(@PathVariable Long id){
        if(!containerRepository.existsById(id)){
            throw new NotFoundException(id);
        }
        containerRepository.deleteById(id);
        return "Container with id " + id + " has been deleted";
    }
}
