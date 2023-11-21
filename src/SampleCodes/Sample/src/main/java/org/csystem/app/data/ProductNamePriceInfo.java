package org.csystem.app.data;

import java.math.BigDecimal;

public class ProductNamePriceInfo {
    private String m_name;
    private BigDecimal m_price;

    public ProductNamePriceInfo(String name, BigDecimal price)
    {
        m_name = name;
        m_price = price;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public BigDecimal getPrice()
    {
        return m_price;
    }

    public void setPrice(BigDecimal price)
    {
        m_price = price;
    }

    @Override
    public String toString()
    {
        return String.format("%s, %s", m_name, m_price);
    }
}
