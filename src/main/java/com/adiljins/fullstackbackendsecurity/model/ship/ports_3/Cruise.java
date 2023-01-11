package com.adiljins.fullstackbackendsecurity.model.ship.ports_3;

import com.adiljins.fullstackbackendsecurity.model.ship.Ship;

import javax.persistence.Entity;

@Entity
public class Cruise extends Ship {
    private final int weightMin = 50;
    private final int weightMax = 1000;
    private int pricePerYear = 1000;

    public int getWeightMin() {
        return weightMin;
    }
    public int getWeightMax() {
        return weightMax;
    }
    public int getPricePerYear() {
        return pricePerYear;
    }
    public void setPricePerYear(int pricePerYear) {
        this.pricePerYear = pricePerYear;
    }
}
