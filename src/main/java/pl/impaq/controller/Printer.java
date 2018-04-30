package pl.impaq.controller;

import pl.impaq.entity.Receipt;

/**
 * Printer - receipt controller
 */

public class Printer {

    public void printReport(CodesScanner codesScanner) {
        Receipt receipt = createReport(codesScanner);
        printReport(receipt);
    }

    private Receipt createReport(CodesScanner codesScanner) {
        return Receipt.builder()
                .items(codesScanner.getScannedProducts())
                .totalPrice(codesScanner.calculateTotalPrice())
                .build();
    }

    private void printReport(Receipt receipt) {
        System.out.println(String.format("=== Printer ===\n\n%s\n\n===============", receipt.toString()));
    }
}
