package com.codetriage.scraper;

import java.math.BigDecimal;
import java.text.Bidi;

public class Results {

    private String name;
    private BigDecimal price;

    public Results(String n, BigDecimal b)
    {
        name = n;
        price = b;
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


}
