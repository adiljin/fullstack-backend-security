package com.adiljins.fullstackbackendsecurity.controller.shipController;

import com.adiljins.fullstackbackendsecurity.exception.NotFoundException;
import com.adiljins.fullstackbackendsecurity.model.ship.ports_20.Tanker;
import com.adiljins.fullstackbackendsecurity.repository.ship_repo.TankerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tanker")
@CrossOrigin("http://localhost:3000/")
public class TankerController {

    @Autowired
    private TankerRepository tankerRepository;

    @PostMapping
    Tanker newTanker(@RequestBody Tanker newTanker){
        newTanker.generatePrice();
        return tankerRepository.save(newTanker);
    }

    @GetMapping("/tankers")
    List<Tanker> getAllTankers(){return tankerRepository.findAll();}

    @GetMapping("/tankers/{id}")
    Tanker getTankerById(@PathVariable Long id){
        return tankerRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    @PutMapping("/{id}")
    Tanker updateTanker(@RequestBody Tanker newTanker,@PathVariable Long id){
        return tankerRepository.findById(id).map(tanker -> {
            tanker.setCompany(newTanker.getCompany());
            tanker.setAddress(newTanker.getAddress());
            tanker.setNumber(newTanker.getNumber());
            tanker.setEmail(newTanker.getEmail());
            return tankerRepository.save(tanker);
        }).orElseThrow(()->new NotFoundException(id));
    }

    @DeleteMapping("/del/{id}")
    ResponseEntity<Object> deleteTanker(@PathVariable Long id){
        try{
            if(!tankerRepository.existsById(id)){
                throw new NotFoundException(id);
            }else{
                tankerRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Cannot delete, information is in use");
        }
    }

//    @DeleteMapping("/del/{id}")
//    String deleteTanker(@PathVariable Long id){
//        if(!tankerRepository.existsById(id)){
//            throw new NotFoundException(id);
//        }
//        tankerRepository.deleteById(id);
//        return "Tanker with id " + id + " has been deleted";
//    }
}
