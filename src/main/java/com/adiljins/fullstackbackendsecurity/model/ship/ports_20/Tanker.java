package com.adiljins.fullstackbackendsecurity.model.ship.ports_20;

import com.adiljins.fullstackbackendsecurity.model.ship.Ship;

import javax.persistence.*;

@Entity
public class Tanker extends Ship {
    private final int weightMin = 5000;
    private final int weightMax = 8000;
    private int pricePerYear = 4000;

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
