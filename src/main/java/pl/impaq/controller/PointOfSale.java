package pl.impaq.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.impaq.entity.Product;
import pl.impaq.repository.ProductRepository;

import java.util.Scanner;

@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PointOfSale {

    private Printer printer;
    private LcdDisplay lcdDisplay;
    private CodesScanner codesScanner;

    public void run(Scanner in, ProductRepository productRepository) {
        while (true) {
            System.out.println("Input product bar-code or use 'exit' for create report.");
            String input = in.nextLine();
            if (input.equals("exit")) {
                exitOption();
            } else if (input.length() < 1) {
                printError();
            } else {
                readBarcode(input, productRepository);
            }
        }
    }

    private void printError() {
        lcdDisplay.print("Invalid bar-code.");
    }

    private void readBarcode(String input, ProductRepository productRepository) {
        Product product = productRepository.findProduct(input);
        if (product == null) {
            lcdDisplay.print("Product not found.");
            return;
        }
        lcdDisplay.print(product.toString());
        codesScanner.addScannedProduct(product);
    }

    private void exitOption() {
        printer.printReport(codesScanner);
        lcdDisplay.print(String.format("Total price: %.2f PLN", codesScanner.calculateTotalPrice()));
        codesScanner.cleanListOfProducts();
    }

}
