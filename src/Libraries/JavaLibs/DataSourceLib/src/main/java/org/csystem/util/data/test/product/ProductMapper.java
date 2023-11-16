package org.csystem.util.data.test.product;

public class ProductMapper {
    //...
    public ProductNameStockDTO toProductStockDTO(ProductInfo productInfo)
    {
        return new ProductNameStockDTO(productInfo.getName(), productInfo.getStock());
    }
}
