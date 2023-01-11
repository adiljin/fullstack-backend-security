package com.adiljins.fullstackbackendsecurity.model.ship.ports_10;

import com.adiljins.fullstackbackendsecurity.model.ship.Ship;

import javax.persistence.*;

@Entity
public class Tugboat extends Ship {

    private final int weightMin = 3000;
    private final int weightMax = 6000;
    private int pricePerYear = 3000;

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
