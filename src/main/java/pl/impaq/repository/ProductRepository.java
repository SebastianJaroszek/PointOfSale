package pl.impaq.repository;

import pl.impaq.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * database stub
 */

public class ProductRepository {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product findProduct(String code) {
        return products.stream()
                .filter(p -> p.getBarcode().getCode().equals(code))
                .findFirst().orElse(null);
    }
}
