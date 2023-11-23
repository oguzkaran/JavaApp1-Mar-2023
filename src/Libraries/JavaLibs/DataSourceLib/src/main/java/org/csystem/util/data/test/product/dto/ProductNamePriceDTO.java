package org.csystem.util.data.test.product.dto;

import java.math.BigDecimal;

public class ProductNamePriceDTO {
    private String m_name;
    private BigDecimal m_price;

    public ProductNamePriceDTO(String name, BigDecimal price)
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
