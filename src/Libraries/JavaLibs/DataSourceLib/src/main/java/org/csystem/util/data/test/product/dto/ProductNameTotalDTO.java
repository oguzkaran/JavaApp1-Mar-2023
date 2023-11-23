package org.csystem.util.data.test.product.dto;

import java.math.BigDecimal;

public class ProductNameTotalDTO {
    public String name;
    public BigDecimal total;

    public ProductNameTotalDTO(String name, BigDecimal total)
    {
        this.name = name;
        this.total = total;
    }

    //...

    @Override
    public String toString()
    {
        return String.format("%s,%s", name, total);
    }
}
