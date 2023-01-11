package com.adiljins.fullstackbackendsecurity.model.routes_management;

import java.util.List;

public class Routes {
    private int port1, port2, quantity;


    public Routes(int port1, int port2, int quantity) {
        this.port1 = port1;
        this.port2 = port2;
        this.quantity = quantity;
    }

    public int getPort1() {
        return port1;
    }
    public int getPort2() {
        return port2;
    }
    public int getQuantity() {
        return quantity;
    }

    public int priceGenerator(List<Route> routes) {
        boolean may = false;
        int counterPrice = 0;
        int result;

        for (Route x : routes) {
            if(x.getId() == this.port1) {
                may = true;
            }
            if(may) {
                counterPrice = counterPrice + x.getPriceFrom();
            }
            if(x.getId() == this.port2) {
                break;
            }
        }
        if (routes.size() == 0) {
            System.out.println("System does not have any routes");
        }

        result = counterPrice;
        return result;
    }
}
