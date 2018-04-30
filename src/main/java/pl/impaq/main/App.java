package pl.impaq.main;

import pl.impaq.controller.LcdDisplay;
import pl.impaq.controller.Printer;
import pl.impaq.entity.Barcode;
import pl.impaq.entity.Product;
import pl.impaq.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {

    private static ProductRepository productRepository = new ProductRepository();
    private static LcdDisplay lcdDisplay = new LcdDisplay();
    private static Printer printer = new Printer();

    public static void main(String[] args) {
        createProducts();
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("Input product barcode or use 'exit' for create report.");
            String option = in.nextLine();
            if (option.equals("exit")) {
                /*printer.printReport();*/
                //receipt is printed on printer containing a list of all previously scanned items names and prices
                // as well as total sum to be paid for all items; the total sum is also printed on LCD display
            } else if (option.length() < 1) {
                lcdDisplay.print("Invalid bar-code.");
            } else {
                Product product = productRepository.findProduct(option);
                if (product == null){
                    lcdDisplay.print("Product not found.");
                    continue;
                }
                lcdDisplay.print(String.format("name: %s\nprice: %.2f PLN",
                        product.getName(), product.getPrice()));
            }
        }
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
