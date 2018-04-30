package pl.impaq.entity;

import lombok.*;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    private Barcode barcode;
    private String name;
    private BigDecimal price;

}
