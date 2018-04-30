package pl.impaq.repository;

import pl.impaq.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private static List<Product> products = new ArrayList<>();

    public static List<Product> getProducts() {
        return products;
    }
}
