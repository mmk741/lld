package com.lld.behavorial.visitor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Element> items = new ArrayList<>();
        items.add(new Book("Design Patterns", 20.0));
        items.add(new Fruit("Banana", 1.2, 2.5));

        Visitor visitor = new ShoppingCartVisitor();

        for (Element item : items) {
            //single Dispatch
            item.accept(visitor);
        }
    }
}
