package com.adiljins.fullstackbackendsecurity.accounting;

public class Lease {
    public static int getLeasing(String type, int years, int pricePerYear)
    {
        int result = 0;
        double percent;
        if(type.equals("contract"))
        {
            percent = (pricePerYear * years) / 0.9;
            pricePerYear = (int)percent;
            result = pricePerYear;
        }
        else if(type.equals("operating"))
        {
            percent = (pricePerYear * years) / 0.7;
            pricePerYear = (int)percent;
            result = pricePerYear;
        }
        return result;
    }
}
