package org.csystem.util.data.test.product;

import java.math.BigDecimal;

public class ProductInfo implements Comparable<ProductInfo>, Cloneable {
    private int m_id;
    private String m_name = "";
    private int m_stock;
    private BigDecimal m_cost = BigDecimal.ZERO;
    private BigDecimal m_price = BigDecimal.ZERO;

    public int getId()
    {
        return m_id;
    }

    public ProductInfo setId(int id)
    {
        m_id = id;

        return this;
    }

    public String getName()
    {
        return m_name;
    }

    public ProductInfo setName(String name)
    {
        m_name = name;

        return this;
    }

    public int getStock()
    {
        return m_stock;
    }

    public ProductInfo setStock(int stock)
    {
        m_stock = stock;

        return this;
    }

    public BigDecimal getCost()
    {
        return m_cost;
    }

    public ProductInfo setCost(BigDecimal cost)
    {
        m_cost = cost;

        return this;
    }

    public BigDecimal getPrice()
    {
        return m_price;
    }

    public ProductInfo setPrice(BigDecimal price)
    {
        m_price = price;

        return this;
    }

    public BigDecimal getTotal()
    {
        return m_price.subtract(m_cost).multiply(BigDecimal.valueOf(m_stock));
    }


    @Override
    public int hashCode()
    {
        return m_id;
    }

    @Override
    public boolean equals(Object other)
    {
        return other instanceof ProductInfo pi && m_id == pi.m_id;
    }


    @Override
    public String toString()
    {
        return String.format("[%d]%s(%d)-%s * %s = %s", m_id, m_name, m_stock, m_cost, m_price, this.getTotal());
    }

    @Override
    public int compareTo(ProductInfo other)
    {
        return m_price.compareTo(other.m_price);
    }

    @Override
    public Object clone()
    {
        return new ProductInfo()
                .setId(m_id)
                .setName(m_name)
                .setStock(m_stock)
                .setCost(m_cost)
                .setPrice(m_price);
    }
}
