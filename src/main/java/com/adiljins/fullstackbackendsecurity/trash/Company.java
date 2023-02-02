//package com.adiljins.fullstackbackendsecurity.model.essential;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="COMPANY_TBL")
//public class Company {
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String address;
//    private String number;
//    private String e_mail;
//
//
////    public Set<Ship> getShips() {
////    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
////    @JoinTable(name = "comp_ships",joinColumns = {
////            @JoinColumn(name = "company_id",referencedColumnName = "id")
////    },inverseJoinColumns = {
////            @JoinColumn(name = "ship_id",referencedColumnName = "id")
////    })
////    @JsonManagedReference
////    private Set<Ship> ships;
//        // Start - all Sets for child classes of Ship
////    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
////    @JoinTable(name = "comp_ships",joinColumns = {
////            @JoinColumn(name = "company_id",referencedColumnName = "id")
////    },inverseJoinColumns = {
////            @JoinColumn(name = "ship_id",referencedColumnName = "id")
////    })
////    @JsonManagedReference
////    private Set<Cruise> cruises;
////
////    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
////    @JoinTable(name = "comp_ships",joinColumns = {
////            @JoinColumn(name = "company_id",referencedColumnName = "id")
////    },inverseJoinColumns = {
////            @JoinColumn(name = "ship_id",referencedColumnName = "id")
////    })
////    @JsonManagedReference
////    private Set<Cargo> cargos;
////
////    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
////    @JoinTable(name = "comp_ships",joinColumns = {
////            @JoinColumn(name = "company_id",referencedColumnName = "id")
////    },inverseJoinColumns = {
////            @JoinColumn(name = "ship_id",referencedColumnName = "id")
////    })
////    @JsonManagedReference
////    private Set<Tugboat> tugboats;
////
////    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
////    @JoinTable(name = "comp_ships",joinColumns = {
////            @JoinColumn(name = "company_id",referencedColumnName = "id")
////    },inverseJoinColumns = {
////            @JoinColumn(name = "ship_id",referencedColumnName = "id")
////    })
////    @JsonManagedReference
////    private Set<Barge> barges;
////
////    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
////    @JoinTable(name = "comp_ships",joinColumns = {
////            @JoinColumn(name = "company_id",referencedColumnName = "id")
////    },inverseJoinColumns = {
////            @JoinColumn(name = "ship_id",referencedColumnName = "id")
////    })
////    @JsonManagedReference
////    private Set<Container> containers;
////
////    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
////    @JoinTable(name = "comp_ships",joinColumns = {
////            @JoinColumn(name = "company_id",referencedColumnName = "id")
////    },inverseJoinColumns = {
////            @JoinColumn(name = "ship_id",referencedColumnName = "id")
////    })
////    @JsonManagedReference
////    private Set<Tanker> tankers;
////     End - all Sets for child classes of Ship
////        return ships;
////    }
////    public void setShips(Set<Ship> ships) {
////        this.ships = ships;
////    }
////    public Set<Cargo> getCargos() {
////        return cargos;
////    }
////    public void setCargos(Set<Cargo> cargos) {
////        this.cargos = cargos;
////    }
//
//    public Long getId() {
//        return id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getAddress() {
//        return address;
//    }
//    public void setAddress(String address) {
//        this.address = address;
//    }
//    public String getNumber() {
//        return number;
//    }
//    public void setNumber(String number) {
//        this.number = number;
//    }
//    public String getE_mail() {
//        return e_mail;
//    }
//    public void setE_mail(String e_mail) {
//        this.e_mail = e_mail;
//    }
//
////    public Set<Ship> getShipsSet() {
////        return ships;
////    }
////    public void setShipsSet(Set<Ship> ships) {
////        this.ships = ships;
////    }
//
//}
