package pl.impaq.controller;

import pl.impaq.entity.Product;

public class LcdDisplay {

    public void print(String message) {
        System.out.println(String.format("=== LCD Display ===\n\n%s\n\n===================", message));
    }

}
