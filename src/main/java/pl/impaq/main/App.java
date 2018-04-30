package pl.impaq.main;

import pl.impaq.controller.CodesScanner;
import pl.impaq.controller.LcdDisplay;
import pl.impaq.controller.Printer;
import pl.impaq.entity.Barcode;
import pl.impaq.controller.PointOfSale;
import pl.impaq.entity.Product;
import pl.impaq.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {

    private static ProductRepository productRepository = new ProductRepository();

    public static void main(String[] args) {
        createProducts();
        Scanner in = new Scanner(System.in);
        PointOfSale pointOfSale = createPointOfSale();
        pointOfSale.run(in, productRepository);
    }

    private static PointOfSale createPointOfSale() {
        return PointOfSale.builder()
                .codesScanner(new CodesScanner())
                .lcdDisplay(new LcdDisplay())
                .printer(new Printer())
                .build();
    }


    /**
     * inserting data into 'database'
     */
    private static void createProducts() {
        productRepository.addProduct(Product.builder()
                .name("Milk")
                .barcode(new Barcode("5900017304007"))
                .price(new BigDecimal(2.90))
                .build()
        );
        productRepository.addProduct(Product.builder()
                .name("Butter")
                .barcode(new Barcode("5906217041483"))
                .price(new BigDecimal(4.29))
                .build()
        );
        productRepository.addProduct(Product.builder()
                .name("Beer")
                .barcode(new Barcode("5905927001114"))
                .price(new BigDecimal(2.99))
                .build()
        );
    }

}
