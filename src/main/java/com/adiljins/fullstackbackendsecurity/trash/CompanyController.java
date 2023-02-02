//package com.adiljins.fullstackbackendsecurity.controller;
//
//import com.adiljins.fullstackbackendsecurity.exception.NotFoundException;
//import com.adiljins.fullstackbackendsecurity.model.essential.Company;
//import com.adiljins.fullstackbackendsecurity.repository.CompanyRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/company-ship")
//@CrossOrigin("http://localhost:3000/")
//public class CompanyController {
//
//    @Autowired
//    private CompanyRepository companyRepository;
//
//    public CompanyController(CompanyRepository companyRepository) {
//        this.companyRepository = companyRepository;
//    }
//
//    @PostMapping()
//    public Company saveCompanyWithShip(@RequestBody Company company){
//        return companyRepository.save(company);
//    }
//
//    @GetMapping("/companies")
//    public List<Company> findAllCompanies(){
//        return companyRepository.findAll();
//    }
//
////    @GetMapping("/companies")
////    public List<CompanyInfo> findAllCompanies() {
////        List<Company> companies = companyRepository.findAll();
////        List<CompanyInfo> companyInfos = new ArrayList<>();
////        for (Company company : companies) {
////            CompanyInfo info = new CompanyInfo();
////            info.setId(company.getId());
////            info.setName(company.getName());
////            info.setAddress(company.getAddress());
////            info.setNumber(company.getNumber());
////            info.setE_mail(company.getE_mail());
////            companyInfos.add(info);
////        }
////
////        return companyInfos;
////    }
//
//
//
//    @GetMapping("/find/{name}")
//    public List<Company> findCompaniesContainingByName(@PathVariable String name){
//        return companyRepository.findByNameContaining(name);
//    }
//
//    @PostMapping(path = "/company")
//    Company newCompany(@RequestBody Company newCompany){
//        return companyRepository.save(newCompany);
//    }
//
//    @GetMapping("/companies/{id}")
//    Company getCompanyById(@PathVariable Long id){
//        return companyRepository.findById(id).orElseThrow(()->new NotFoundException(id));
//    }
//
//
//    @PutMapping("/company/{id}")
//    Company updateCompany(@RequestBody Company newCompany,@PathVariable Long id){
//        return companyRepository.findById(id).map(company -> {
//            company.setName(newCompany.getName());
//            company.setAddress(newCompany.getAddress());
//            company.setNumber(newCompany.getNumber());
//            company.setE_mail(newCompany.getE_mail());
//            return companyRepository.save(company);
//        }).orElseThrow(()->new NotFoundException(id));
//    }
//
//    @DeleteMapping("/company/{id}")
//    String deleteCompany(@PathVariable Long id){
//        if(!companyRepository.existsById(id)){
//            throw new NotFoundException(id);
//        }
//        companyRepository.deleteById(id);
//        return "Company with id " + id + " has been deleted";
//    }
//
////    @GetMapping("/generate_prices")
////    public void generatePrice(){
////        List<Company> com =  companyRepository.findAll();
////
////        for(Company x:com){
////            System.out.println("X: " + x);
////            for(Ship y:x.getShipsSet()){
////                System.out.println("Y: " + y);
////                y.setPrice(getLeasing(y.getTypeLease(),y.getYears(),y.getPricePerYear()));
////                y.setPricePerYear(y.getPricePerYear());
////            }
////            companyRepository.save(x);
////        }
////    }
//}
