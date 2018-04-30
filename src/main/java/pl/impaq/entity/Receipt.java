package pl.impaq.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Receipt {

    private List<Product> items;
    private BigDecimal totalPrice;

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        for (Product product : items) {
            result.append(String.format("%s\n", product.toString()));
        }
        result.append(String.format("\nTotal price: %.2f PLN", totalPrice));

        return result.toString();
    }
}
