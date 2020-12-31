package com.codetriage.scraper;

import java.math.BigDecimal;
import java.text.Bidi;

public class Result {

    private String name;
    private BigDecimal price;
    private String url;

    public Result(String n, BigDecimal b, String u)
    {
        name = n;
        price = b;
        url = u;
    }

    public void setName(String n)
    {
        name = n;
    }
    public String getName()
    {
        return name;
    }

    public void setPrice(BigDecimal b)
    {
        price = b;
    }
    public BigDecimal getPrice()
    {
        return price;
    }

    public void setURL(String u){url = u;}
    public String getURL(){return url;}

    public String toString()
    {
        return("Item name: " + name + "\n Item price: $" + price.toString() + "\n Item URL: + " + url + "\n");
    }



}
