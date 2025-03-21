package models.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private String author;
    private String description;
    private Integer id;
    private String imagePath;
    private String name;
    private BigDecimal price;
}
