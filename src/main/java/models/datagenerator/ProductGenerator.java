package models.datagenerator;

import models.product.Product;
import properties.PropertyReader;

import java.math.BigDecimal;

public class ProductGenerator {
    public static Product createNewProduct(){
        return Product.builder()
                .author(PropertyReader.getProperty("author"))
                .description(PropertyReader.getProperty("description"))
                .id(Integer.parseInt(PropertyReader.getProperty("id")))
                .imagePath(PropertyReader.getProperty("imagePath"))
                .name(PropertyReader.getProperty("name"))
                .price(new BigDecimal(PropertyReader.getProperty("price")))
                .build();
    }
}
