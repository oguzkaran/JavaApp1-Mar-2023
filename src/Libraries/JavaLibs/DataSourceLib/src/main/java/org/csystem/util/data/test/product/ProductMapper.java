package org.csystem.util.data.test.product;

import org.csystem.util.data.test.product.dto.ProductNameStockDTO;

public class ProductMapper {
    //...
    public ProductNameStockDTO toProductStockDTO(ProductInfo productInfo)
    {
        return new ProductNameStockDTO(productInfo.getName(), productInfo.getStock());
    }
}
