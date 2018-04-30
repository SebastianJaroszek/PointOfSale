package pl.impaq.controller;

import org.junit.Assert;
import org.junit.Test;
import pl.impaq.entity.Product;

import java.math.BigDecimal;

public class CodesScannerTest {

    @Test
    public void addScannedProductMethodShouldEnlargeListOfScannedProducts() {
        CodesScanner codesScanner = new CodesScanner();
        int sizeBeforeAdd = codesScanner.getScannedProducts().size();
        codesScanner.addScannedProduct(Product.builder().build());
        int sizeAfterAdd = codesScanner.getScannedProducts().size();

        Assert.assertEquals(sizeBeforeAdd + 1, sizeAfterAdd);
    }

    @Test
    public void calculateTotalPriceMethodShouldReturnSumOfProductsPrice() {
        CodesScanner codesScanner = new CodesScanner();
        codesScanner.addScannedProduct(Product.builder().price(new BigDecimal(5)).build());
        codesScanner.addScannedProduct(Product.builder().price(new BigDecimal(10)).build());
        codesScanner.addScannedProduct(Product.builder().price(new BigDecimal(20)).build());

        BigDecimal methodResult = codesScanner.calculateTotalPrice();

        Assert.assertEquals(new BigDecimal(35), methodResult);
    }

    @Test
    public void calculateTotalPriceMethodShouldReturnZeroWhenThereAreNotAnyScannedProducts() {
        CodesScanner codesScanner = new CodesScanner();

        BigDecimal methodResult = codesScanner.calculateTotalPrice();

        Assert.assertEquals(BigDecimal.ZERO, methodResult);
    }

    @Test
    public void clearListOfProductsMethodShouldDeleteAllItemsFromList() {
        CodesScanner codesScanner = new CodesScanner();
        codesScanner.addScannedProduct(Product.builder().build());
        codesScanner.addScannedProduct(Product.builder().build());

        codesScanner.cleanListOfProducts();

        Assert.assertEquals(0, codesScanner.getScannedProducts().size());
    }

}
