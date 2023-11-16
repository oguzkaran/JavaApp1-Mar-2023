package org.csystem.util.data.test.factory;

import org.csystem.util.data.test.product.ProductInfo;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public final class ProductFactory {
    public final List<ProductInfo> PRODUCTS = new ArrayList<>();

    private static String join(String [] strings, int startIndex, int endIndex, String delimiter) //İleride tek hamlede yapacağız
    {
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < endIndex; ++i)
            sb.append(strings[i]).append(delimiter);

        return sb.substring(0, sb.length() - delimiter.length());
    }

    private static ProductInfo getProduct(String line)
    {
        var productsInfo = line.split("[,]");
        var id = Integer.parseInt(productsInfo[0]);
        var name = join(productsInfo, 1, productsInfo.length - 3, ",");
        var stock = Integer.parseInt(productsInfo[productsInfo.length - 3]);
        var cost = new BigDecimal(productsInfo[productsInfo.length - 2]);
        var price = new BigDecimal(productsInfo[productsInfo.length - 1]);

        return new ProductInfo().setId(id).setName(name).setPrice(price).setCost(cost).setStock(stock);
    }

    private ProductFactory()
    {}

    public static Optional<ProductFactory> loadFromTextFile(String path) throws IOException
    {
        Optional<ProductFactory> result = Optional.empty();

        try (var br = Files.newBufferedReader(Path.of(path), StandardCharsets.UTF_8)) {
            if (br.readLine() == null)
                return result;

            var productFactory = new ProductFactory();
            String line;

            while ((line = br.readLine()) != null)
                productFactory.PRODUCTS.add(getProduct(line));

            result = Optional.of(productFactory);
        }

        return result;
    }

    public static ProductFactory loadFromTextFile(Path path) throws IOException
    {
        var result = new ProductFactory();

        try (var br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            if (br.readLine() == null)
                return result;
            String line;

            while ((line = br.readLine()) != null)
                result.PRODUCTS.add(getProduct(line));
        }

        return result;
    }

    public Iterable<ProductInfo> getProductsAsIterable()
    {
        return PRODUCTS;
    }

    public Optional<ProductInfo> getRandomProduct(Random r)
    {
        return PRODUCTS.isEmpty() ? Optional.empty() : Optional.of(PRODUCTS.get(r.nextInt(PRODUCTS.size())));
    }
}
