package com.adiljins.fullstackbackendsecurity.controller;

import com.adiljins.fullstackbackendsecurity.exception.NotFoundException;
import com.adiljins.fullstackbackendsecurity.model.essential.Customer;
import com.adiljins.fullstackbackendsecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/cust")
@CrossOrigin("http://localhost:3000/")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping()
    Customer newCustomer(@RequestBody Customer newCustomer){
        return customerRepository.save(newCustomer);
    }

    @GetMapping("/get")
    List<Customer> getAllCustomers(){return customerRepository.findAll();}

    @GetMapping("/{id}")
    Customer getCustomerById(@PathVariable Long id){
        return customerRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    @PutMapping("/set/{id}")
    Customer updateCustomer(@RequestBody Customer newCustomer,@PathVariable Long id){
        return customerRepository.findById(id).map(customer -> {
            customer.setName(newCustomer.getName());
            customer.setAddress(newCustomer.getAddress());
            customer.setNumber(newCustomer.getNumber());
            customer.setE_mail(newCustomer.getE_mail());
            return customerRepository.save(customer);
        }).orElseThrow(()->new NotFoundException(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteFre(@PathVariable Long id){
        try{
            if(!customerRepository.existsById(id)){
                throw new NotFoundException(id);
            }else{
                customerRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Cannot delete, information is in use");
        }
    }

//    @DeleteMapping("/{id}")
//    String deleteCustomer(@PathVariable Long id){
//        if(!customerRepository.existsById(id)){
//            throw new NotFoundException(id);
//        }
//        customerRepository.deleteById(id);
//        return "Customer with id " + id + " has been deleted";
//    }

}
