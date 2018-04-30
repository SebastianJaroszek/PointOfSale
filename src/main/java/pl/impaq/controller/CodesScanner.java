package pl.impaq.controller;

import pl.impaq.entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * CodesScanner - barcode controller
 */

public class CodesScanner {

    private List<Product> scannedProducts = new ArrayList<>();

    public void addScannedProduct(Product product) {
        scannedProducts.add(product);
    }

    public List<Product> getScannedProducts() {
        return scannedProducts;
    }

    public BigDecimal calculateTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Product product : scannedProducts) {
            totalPrice = totalPrice.add(product.getPrice());
        }
        return totalPrice;
    }

    public void cleanListOfProducts() {
        scannedProducts.clear();
    }
}
