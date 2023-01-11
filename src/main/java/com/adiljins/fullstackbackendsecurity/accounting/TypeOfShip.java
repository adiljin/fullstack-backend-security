package com.adiljins.fullstackbackendsecurity.accounting;

import com.adiljins.fullstackbackendsecurity.model.ship.Ship;
import com.adiljins.fullstackbackendsecurity.model.ship.ports_10.Cargo;
import com.adiljins.fullstackbackendsecurity.model.ship.ports_10.Tugboat;
import com.adiljins.fullstackbackendsecurity.model.ship.ports_20.Barge;
import com.adiljins.fullstackbackendsecurity.model.ship.ports_20.Container;
import com.adiljins.fullstackbackendsecurity.model.ship.ports_20.Tanker;
import com.adiljins.fullstackbackendsecurity.model.ship.ports_3.Cruise;

public class TypeOfShip {
    public static Ship getTypeOfShip(String type)
    {
        Ship shipResult = null;
        if(type.equals("cruise")){
            shipResult = new Cruise();
        }else if(type.equals("cargo")){
            shipResult = new Cargo();
        }else if(type.equals("tugboat")){
            shipResult = new Tugboat();
        }else if(type.equals("barge")){
            shipResult = new Barge();
        }else if(type.equals("container")){
            shipResult = new Container();
        } else if(type.equals("tanker")){
            shipResult = new Tanker();
        }
        return shipResult;
    }
}
