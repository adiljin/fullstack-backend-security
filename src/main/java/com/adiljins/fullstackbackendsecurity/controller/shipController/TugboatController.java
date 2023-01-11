package com.adiljins.fullstackbackendsecurity.controller.shipController;

import com.adiljins.fullstackbackendsecurity.exception.NotFoundException;
import com.adiljins.fullstackbackendsecurity.model.ship.ports_10.Tugboat;
import com.adiljins.fullstackbackendsecurity.repository.ship_repo.TugboatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tugboat")
@CrossOrigin("http://localhost:3000/")
public class TugboatController {

    @Autowired
    private TugboatRepository tugboatRepository;

    @PostMapping
    Tugboat newTugboat(@RequestBody Tugboat newTugboat){
        newTugboat.generatePrice();
        return tugboatRepository.save(newTugboat);
    }

    @GetMapping("/tugboats")
    List<Tugboat> getAllTugboats(){return tugboatRepository.findAll();}

    @GetMapping("/tugboats/{id}")
    Tugboat getTugboatById(@PathVariable Long id){
        return tugboatRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    @PutMapping("/{id}")
    Tugboat updateTugboat(@RequestBody Tugboat newTugboat,@PathVariable Long id){
        return tugboatRepository.findById(id).map(cruise -> {
            cruise.setCompany(newTugboat.getCompany());
            cruise.setAddress(newTugboat.getAddress());
            cruise.setNumber(newTugboat.getNumber());
            cruise.setEmail(newTugboat.getEmail());
            return tugboatRepository.save(cruise);
        }).orElseThrow(()->new NotFoundException(id));
    }

    @DeleteMapping("/del/{id}")
    String deleteTugboat(@PathVariable Long id){
        if(!tugboatRepository.existsById(id)){
            throw new NotFoundException(id);
        }
        tugboatRepository.deleteById(id);
        return "Tugboat with id " + id + " has been deleted";
    }

}
